package ratpack.graphql.example;

import ratpack.graphql.example.api.ApiModule;
import ratpack.graphql.example.api.GraphQLHandler;
import ratpack.graphql.example.service.ServiceModule;
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
                        .module(ApiModule.class)
                        .module(ServiceModule.class))
                )
                .handlers(chain -> chain
                        .post("graphql", GraphQLHandler.class)
                )
        );
    }
}
