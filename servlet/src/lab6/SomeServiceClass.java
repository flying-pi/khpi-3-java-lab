package lab6;

import java.util.ArrayList;

public class SomeServiceClass {
    public static class Product{
        public String name;
        public float price;

        public String getName() {
            return name;
        }

        public float getPrice() {
            return price;
        }

        public Product(String name, float price) {
            this.name = name;
            this.price = price;
        }
    }
    public ArrayList<Product> getProducts(){
        ArrayList<Product> result = new ArrayList<>();
        result.add(new Product("product1",123));
        result.add(new Product("product2",345));
        return result;
    }
}
