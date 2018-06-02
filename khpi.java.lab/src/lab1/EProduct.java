package lab1;

import java.net.URL;

public class EProduct extends BaseProduct {
    private String productURL;

    public EProduct(){
        this(0,"","");
    }

    public EProduct(float price, String name, String productURL) {
        super(price, name);
        this.productURL = productURL;
    }

    public String getProductURL() {
        return productURL;
    }

    public void setProductURL(String productURL) {
        this.productURL = productURL;
    }

    @Override
    public String toString() {
        return (new StringBuilder())
                .append(super.toString())
                .append(" path to product: ")
                .append(productURL)
                .toString();
    }
}
