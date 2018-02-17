package ratpack.graphql.example.service.product.model;

public class Image {

    enum ImageType {
        PRIMARY,
        THUMBNAIL
    }

    private Long id;
    private String url;
    private String alt;
    private ImageType type;

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
}
