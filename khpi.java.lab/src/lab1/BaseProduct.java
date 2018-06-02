package lab1;


import java.lang.ref.SoftReference;
import java.util.ArrayList;

public abstract class BaseProduct {
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


    public BaseProduct() {
        this(0,"");
    }

    public BaseProduct(float price, String name) {
        this.price = price;
        this.name = name;

        allProducts.add(new ProductSoftReverence(this));
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

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
}
