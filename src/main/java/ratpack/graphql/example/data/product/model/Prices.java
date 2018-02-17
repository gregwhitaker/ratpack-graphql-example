package ratpack.graphql.example.data.product.model;

public class Prices {

    private String currency;
    private Integer msrp;
    private Integer list;
    private Integer sale;
    private String formattedMsrp;
    private String formattedList;
    private String formattedSale;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getMsrp() {
        return msrp;
    }

    public void setMsrp(Integer msrp) {
        this.msrp = msrp;
    }

    public Integer getList() {
        return list;
    }

    public void setList(Integer list) {
        this.list = list;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public String getFormattedMsrp() {
        return formattedMsrp;
    }

    public void setFormattedMsrp(String formattedMsrp) {
        this.formattedMsrp = formattedMsrp;
    }

    public String getFormattedList() {
        return formattedList;
    }

    public void setFormattedList(String formattedList) {
        this.formattedList = formattedList;
    }

    public String getFormattedSale() {
        return formattedSale;
    }

    public void setFormattedSale(String formattedSale) {
        this.formattedSale = formattedSale;
    }
}
