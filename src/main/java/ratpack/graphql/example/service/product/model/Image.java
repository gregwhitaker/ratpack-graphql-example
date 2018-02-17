package ratpack.graphql.example.service.product.model;

public class Image {

    public enum ImageType {
        PRIMARY("primary"),
        THUMBNAIL("thumbnail");

        private final String value;

        ImageType(final String value) {
            this.value = value;
        }
    }

    private Long id;
    private String url;
    private String alt;
    private ImageType type;
    private Integer sortOrder;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public ImageType getType() {
        return type;
    }

    public void setType(ImageType type) {
        this.type = type;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }
}
