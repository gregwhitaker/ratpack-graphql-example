package ratpack.graphql.example.data.product;

import com.google.inject.Singleton;
import ratpack.graphql.example.service.product.model.Gender;
import ratpack.graphql.example.service.product.model.Image;
import ratpack.graphql.example.service.product.model.Prices;
import ratpack.graphql.example.service.product.model.Product;
import ratpack.graphql.example.service.product.model.Sku;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Singleton
public class DefaultProductDao implements ProductDao {
    private final Map<Long, Product> products = new HashMap<>();

    public DefaultProductDao() {
        init();
    }

    private void init() {
        Product product1 = new Product();
        product1.setId(1L);
        product1.setName("Widget1");
        product1.setLongName("Widget1 - SuperPlus1");
        product1.setActive(true);
        product1.setGender(Gender.MEN);
        product1.setPrices(() -> {
            Prices prices = new Prices();
            prices.setCurrency("USD");
            prices.setMsrp(2299);
            prices.setList(2299);
            prices.setSale(1599);
            prices.setFormattedMsrp("$22.99");
            prices.setFormattedList("$22.99");
            prices.setFormattedSale("$15.99");
            
            return prices;
        });
        product1.setImages(() -> {
            List<Image> images = new ArrayList<>();

            Image image1 = new Image();
            image1.setId(11L);
            image1.setAlt("Widget1 - Thumbnail");
            image1.setType(Image.ImageType.THUMBNAIL);
            image1.setUrl("http://via.placeholder.com/100x100");
            image1.setSortOrder(1);

            Image image2 = new Image();
            image2.setId(11L);
            image2.setAlt("Widget1 - Primary");
            image2.setType(Image.ImageType.PRIMARY);
            image2.setUrl("http://via.placeholder.com/350x500");
            image2.setSortOrder(2);

            Image image3 = new Image();
            image3.setId(11L);
            image3.setAlt("Widget1 - Primary2");
            image3.setType(Image.ImageType.PRIMARY);
            image3.setUrl("http://via.placeholder.com/500x500");
            image3.setSortOrder(3);

            images.add(image1);
            images.add(image2);
            images.add(image3);

            return images;
        });
        product1.setSkus(() -> {
            List<Sku> skus = new ArrayList<>();

            Sku sku1 = new Sku();
            sku1.setSkuId("123-1");
            sku1.setSize("S");

            Sku sku2 = new Sku();
            sku2.setSkuId("123-2");
            sku2.setSize("M");

            Sku sku3 = new Sku();
            sku3.setSkuId("123-3");
            sku3.setSize("L");

            Sku sku4 = new Sku();
            sku4.setSkuId("123-4");
            sku4.setSize("XL");

            skus.add(sku1);
            skus.add(sku2);
            skus.add(sku3);
            skus.add(sku4);

            return skus;
        });

        products.put(1L, product1);
    }
}
