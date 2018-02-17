package ratpack.graphql.example.data;

import com.google.inject.AbstractModule;
import ratpack.graphql.example.data.inventory.DefaultInventoryDao;
import ratpack.graphql.example.data.inventory.InventoryDao;
import ratpack.graphql.example.data.product.DefaultProductDao;
import ratpack.graphql.example.data.product.ProductDao;

public class DataModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(InventoryDao.class).to(DefaultInventoryDao.class);
        bind(ProductDao.class).to(DefaultProductDao.class);
    }
}
