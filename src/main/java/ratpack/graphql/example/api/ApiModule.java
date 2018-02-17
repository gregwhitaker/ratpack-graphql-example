package ratpack.graphql.example.api;

import com.google.inject.AbstractModule;

public class ApiModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(GraphQLHandler.class);
    }
}
