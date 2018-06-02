package lab1;

import sun.security.ssl.Debug;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) {
        testAverage();
        testCollection();
    }

    public static Stream<BaseProduct> generateTest(int size) {

        final int[] i = {0};
        Random rand = new Random();
        return Stream.generate(() -> {
            i[0]++;
            String name = "product#" + String.valueOf(i[0]);
            float price = rand.nextFloat() * 1000;
            if (rand.nextBoolean())
                return new EProduct(price, name, "https://boo.com/" + name);
            else
                return new SomeFood(price, name);
        }).limit(size);
    }

    private static void testAverage() {
        System.out.println("AVERAGE PRICE TEST");
        System.out.println("Current average : "+ String.valueOf(BaseProduct.getAvaragePriceOfExistProduct()));
        Object[] products = generateTest(123).toArray();
        System.out.println(
                "Average after adding some product : "+ String.valueOf(BaseProduct.getAvaragePriceOfExistProduct())
        );
        //for prevent garbage collection.
        int a = products.hashCode();
        System.out.println("\n\n");
    }

    private static void testCollection() {
        System.out.println("COLLECTION SORT TEST");
        ProductCollection collection = new ProductCollection();
        generateTest(10).forEach(collection::add);
        System.out.println("Created collection");
        System.out.print(collection.getPrintedListOfProduct());
        collection.sortByPrice();
        System.out.println("After sorting by price");
        System.out.print(collection.getPrintedListOfProduct());
    }
}
