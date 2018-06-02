package lab4.logic;


import java.lang.ref.SoftReference;
import java.util.ArrayList;

public abstract  class BaseProduct implements IBaseProduct {
    private float price;
    private String name;

    private static ArrayList<ProductSoftReverence> allProducts = new ArrayList<>();

    private static class ProductSoftReverence extends SoftReference<BaseProduct> {

        ProductSoftReverence(BaseProduct referent) {
            super(referent);
        }

        @Override
        public void clear() {
            super.clear();
            allProducts.remove(this);
        }
    }

    public static float getAvaragePriceOfExistProduct(){
        return (float)allProducts.stream()
                .filter(productSoftReverence -> productSoftReverence.get() != null)
                .mapToDouble(value -> value.get().getPrice()).average().orElse(0.0);
    }


    public BaseProduct() throws NegativePriceException {
        this(0,"");
    }

    public BaseProduct(float price, String name) throws NegativePriceException {
        this.setName(name);
        this.setPrice(price);
        allProducts.add(new ProductSoftReverence(this));
    }

    @Override
    public float getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setPrice(float price) throws NegativePriceException {
        if(price<0)
            throw new NegativePriceException(price);
        this.price = price;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return (new StringBuilder())
                .append("<")
                .append(this.getClass().getTypeName())
                .append(">\t")
                .append("Product with name `")
                .append(name)
                .append("` and price: ")
                .append(price).toString();
    }

    @Override
    public BaseProduct clone() throws CloneNotSupportedException {
        BaseProduct result = (BaseProduct) super.clone();
        result.price = price;
        result.name = name;
        return result;
    }
}
