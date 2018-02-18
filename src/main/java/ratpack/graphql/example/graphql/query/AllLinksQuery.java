package ratpack.graphql.example.graphql.query;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import ratpack.graphql.example.data.link.LinkRepository;
import ratpack.graphql.example.data.link.model.Link;

import java.util.List;

/**
 * DataFetcher that returns all links in the repository.
 */
public class AllLinksQuery implements DataFetcher<List<Link>> {

    private final LinkRepository linkRepo;

    public AllLinksQuery(LinkRepository linkRepo) {
        this.linkRepo = linkRepo;
    }

    @Override
    public List<Link> get(DataFetchingEnvironment environment) {
        try {
            return linkRepo.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
