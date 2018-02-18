package ratpack.graphql.example.data.link;

import com.google.common.collect.Lists;
import com.google.inject.Singleton;
import ratpack.exec.Blocking;
import ratpack.exec.Operation;
import ratpack.exec.Promise;
import ratpack.graphql.example.data.link.model.Link;

import java.util.List;

@Singleton
public class DefaultLinkRepository implements LinkRepository {
    private final List<Link> links = Lists.newArrayList();

    public DefaultLinkRepository() {
        links.add(new Link("https://www.netifi.com", "Autonomous microservices platform"));
        links.add(new Link("http://howtographql.com", "Your favorite GraphQL page"));
        links.add(new Link("http://graphql.org/learn/", "The official docks"));
    }

    @Override
    public List<Link> findAll() {
        return links;
    }

    @Override
    public void save(Link link) {
        links.add(link);
    }
}
