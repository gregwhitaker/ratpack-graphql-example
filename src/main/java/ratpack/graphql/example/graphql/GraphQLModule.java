package ratpack.graphql.example.graphql;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provides;
import graphql.schema.idl.RuntimeWiring;
import ratpack.graphql.example.data.link.LinkRepository;
import ratpack.graphql.example.graphql.handler.GraphQLHandler;
import ratpack.graphql.example.graphql.mutator.CreateLinkMutator;
import ratpack.graphql.example.graphql.query.AllLinksQuery;

public class GraphQLModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(GraphQLHandler.class);
    }

    @Inject
    @Provides
    public RuntimeWiring runtimeWiring(LinkRepository linkRepo) {
        return RuntimeWiring.newRuntimeWiring()
                .type("QueryType", wiring -> wiring
                        .dataFetcher("allLinks", new AllLinksQuery(linkRepo))
                )
                .type("MutationType", wiring -> wiring
                        .dataFetcher("linkCreate", new CreateLinkMutator(linkRepo))
                )
                .build();
    }
}
