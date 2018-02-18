package ratpack.graphql.example.graphql.query;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import ratpack.graphql.example.data.link.LinkRepository;
import ratpack.graphql.example.data.link.model.Link;

import java.util.List;

/**
 * DataFetcher that returns all links in the repository.
 */
public class AllLinksFetcher implements DataFetcher<List<Link>> {

    private final LinkRepository linkRepo;

    public AllLinksFetcher(LinkRepository linkRepo) {
        this.linkRepo = linkRepo;
    }

    @Override
    public List<Link> get(DataFetchingEnvironment environment) {
        try {
            // The graphql java implementation is blocking :(
            return linkRepo.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
