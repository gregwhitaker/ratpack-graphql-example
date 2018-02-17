package ratpack.graphql.example.service.product.model;

public enum Gender {
    MEN("men"),
    WOMEN("women"),
    UNISEX("unisex");

    private final String value;

    Gender(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
