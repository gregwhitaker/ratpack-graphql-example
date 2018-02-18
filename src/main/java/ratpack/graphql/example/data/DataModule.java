package ratpack.graphql.example.data;

import com.google.inject.AbstractModule;
import ratpack.graphql.example.data.link.DefaultLinkRepository;
import ratpack.graphql.example.data.link.LinkRepository;

public class DataModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(LinkRepository.class).to(DefaultLinkRepository.class);
    }
}
