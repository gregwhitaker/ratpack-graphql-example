package ratpack.graphql.example.data.inventory;

import com.google.inject.Singleton;

import java.util.HashMap;
import java.util.Map;

@Singleton
public class DefaultInventoryDao implements InventoryDao {
    private final Map<String, Integer> skus = new HashMap<>();

    public DefaultInventoryDao() {
        init();
    }

    private void init() {
        // Product1
        skus.put("123-1", 20);
        skus.put("123-2", 12);
        skus.put("123-3", 0);
        skus.put("123-4", 9);

        // Product2
        skus.put("456-1", 2);
        skus.put("456-2", 0);
        skus.put("456-3", 3);

        // Product3
        skus.put("789-1", 100);
        skus.put("789-2", 100);
        skus.put("789-3", 75);
        skus.put("789-4", 25);
    }
}
