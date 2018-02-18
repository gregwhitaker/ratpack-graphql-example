package ratpack.graphql.example.data.link;

import ratpack.graphql.example.data.link.model.Link;

import java.util.List;

public interface LinkRepository {

    List<Link> findAll();

    void save(Link link);
}
