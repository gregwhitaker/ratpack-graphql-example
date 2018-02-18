package ratpack.graphql.example.data.link;

import ratpack.graphql.example.data.link.model.Link;

import java.util.List;

/**
 * Repository for managing links.
 */
public interface LinkRepository {

    List<Link> findAll();

    void save(Link link);
}
