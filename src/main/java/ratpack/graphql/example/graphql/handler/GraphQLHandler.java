package ratpack.graphql.example.graphql.handler;

import com.google.inject.Inject;
import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.jackson.Jackson;
import ratpack.server.BaseDir;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;

public class GraphQLHandler implements Handler {
    private static final String GRAPHQL_SCHEMA = "schema.graphqls";
    private static final String DATA = "data";
    private static final String ERRORS = "errors";
    private static final String QUERY = "query";
    private static final String VARIABLES = "variables";
    private final GraphQL graphql;

    @Inject
    public GraphQLHandler(RuntimeWiring wiring) {
        Path schemaPath = BaseDir.find().resolve(GRAPHQL_SCHEMA);

        if (!Files.exists(schemaPath)) {
            throw new IllegalArgumentException(String.format("GraphQL schema file '%s' not found in Ratpack basedir", GRAPHQL_SCHEMA));
        }

        SchemaParser schemaParser = new SchemaParser();
        TypeDefinitionRegistry registry;

        try {
            registry = schemaParser.parse(schemaPath.toFile());
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid GraphQL schema", e);
        }

        SchemaGenerator schemaGenerator = new SchemaGenerator();
        this.graphql = GraphQL.newGraphQL(schemaGenerator.makeExecutableSchema(registry, wiring)).build();
    }

    @Override
    public void handle(Context ctx) throws Exception {
        ctx.parse(Map.class).then(payload -> {
            Map<String, Object> variables = (Map<String, Object>) payload.get(VARIABLES);

            ExecutionInput executionInput = ExecutionInput.newExecutionInput()
                    .query(payload.get(QUERY).toString())
                    .variables(variables)
                    .build();

            final ExecutionResult executionResult = graphql.execute(executionInput);

            Map<String, Object> result = new LinkedHashMap<>();
            if (executionResult.getErrors().isEmpty()) {
                result.put(DATA, executionResult.getData());
            } else {
                result.put(ERRORS, executionResult.getErrors());
            }

            ctx.render(Jackson.json(result));
        });
    }
}
