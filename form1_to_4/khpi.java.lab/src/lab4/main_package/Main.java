package lab4.main_package;

import lab4.logic.*;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.StreamSupport;

public class Main {
    public static <T extends IBaseProduct> float avg(ProductCollection<T> list) {
        return (float) StreamSupport
                .stream(Spliterators.spliteratorUnknownSize(list.iterator(), Spliterator.ORDERED), false)
                .mapToDouble(IBaseProduct::getPrice).average().orElse(0);
    }

    public static void main(String[] args) {
        ProductCollection<EProduct> products = new ProductCollection<>();
        products.add(new EProduct(10,"product1",""));
        products.add(new EProduct(30,"product2",""));
        System.out.println("AVERRAGE TEST: ");
        System.out.println("Avg: "+String.valueOf(avg(products)));


        System.out.println("\n\nCOPY TEST: ");

        try {
            ProductCollection<EProduct> copy = products.clone();
            copy.getAt(0).setName("copy product!!!");

            System.out.println("Original collection: ");
            System.out.println(products.getPrintedListOfProduct());

            System.out.println("Copied collection: ");
            System.out.println(copy.getPrintedListOfProduct());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


    }
}
