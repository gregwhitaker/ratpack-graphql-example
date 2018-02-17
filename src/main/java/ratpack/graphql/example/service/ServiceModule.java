package ratpack.graphql.example.service;

import com.google.inject.AbstractModule;
import ratpack.graphql.example.service.inventory.DefaultInventoryService;
import ratpack.graphql.example.service.inventory.InventoryService;
import ratpack.graphql.example.service.product.DefaultProductService;
import ratpack.graphql.example.service.product.ProductService;

public class ServiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(InventoryService.class).to(DefaultInventoryService.class);
        bind(ProductService.class).to(DefaultProductService.class);
    }
}
