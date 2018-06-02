package lab3.logic;

public class EProduct extends BaseProduct implements IEProduct {
    private String productURL;

    public EProduct() throws NegativePriceException {
        this(0,"","");
    }

    public EProduct(float price, String name, String productURL) throws NegativePriceException {
        super(price, name);
        this.productURL = productURL;
    }

    @Override
    public String getProductURL() {
        return productURL;
    }

    @Override
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
