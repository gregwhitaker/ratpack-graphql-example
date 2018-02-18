package ratpack.graphql.example.data.link.model;

public class Link {
    private final String url;
    private final String description;

    public Link(final String url, final String description) {
        this.url = url;
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }
}
