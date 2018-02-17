package ratpack.graphql.example.data.inventory.model;

public class SkuInventory {

    private String skuId;
    private Integer count;

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
