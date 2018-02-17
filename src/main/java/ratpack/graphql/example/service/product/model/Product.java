package ratpack.graphql.example.service.product.model;

import java.util.List;
import java.util.function.Supplier;

public class Product {

    private Long id;
    private String name;
    private String longName;
    private boolean active = true;
    private Gender gender;
    private Prices prices;
    private List<Image> images;
    private List<Sku> skus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Prices getPrices() {
        return prices;
    }

    public void setPrices(Prices prices) {
        this.prices = prices;
    }

    public void setPrices(Supplier<Prices> prices) {
        this.prices = prices.get();
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public void setImages(Supplier<List<Image>> images) {
        this.images = images.get();
    }

    public List<Sku> getSkus() {
        return skus;
    }

    public void setSkus(List<Sku> skus) {
        this.skus = skus;
    }

    public void setSkus(Supplier<List<Sku>> skus) {
        this.skus = skus.get();
    }
}
