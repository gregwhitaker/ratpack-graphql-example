package ratpack.graphql.example;

import ratpack.graphql.example.graphql.GraphQLModule;
import ratpack.graphql.example.graphql.handler.GraphQLHandler;
import ratpack.graphql.example.data.DataModule;
import ratpack.guice.Guice;
import ratpack.server.BaseDir;
import ratpack.server.RatpackServer;

/**
 * Starts the ratpack-graphql-example application.
 */
public class Main {

    public static void main(String... args) throws Exception {
        RatpackServer.start(s -> s
                .serverConfig(c -> c
                        .env()
                        .baseDir(BaseDir.find())
                        .build()
                )
                .registry(Guice.registry(b -> b
                        .module(GraphQLModule.class)
                        .module(DataModule.class))
                )
                .handlers(chain -> chain
                        .post("graphql", GraphQLHandler.class)
                )
        );
    }
}
