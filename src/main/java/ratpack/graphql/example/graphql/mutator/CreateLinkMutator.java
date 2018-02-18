package ratpack.graphql.example.graphql.mutator;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import ratpack.graphql.example.data.link.LinkRepository;
import ratpack.graphql.example.data.link.model.Link;

public class CreateLinkMutator implements DataFetcher<Link> {

    private final LinkRepository linkRepo;

    public CreateLinkMutator(LinkRepository linkRepo) {
        this.linkRepo = linkRepo;
    }

    @Override
    public Link get(DataFetchingEnvironment environment) {
        String url = environment.getArgument("url");
        String desc = environment.getArgument("description");

        Link link = new Link(url, desc);

        linkRepo.save(link);

        return link;
    }
}
