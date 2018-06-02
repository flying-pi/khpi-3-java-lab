package lab3.main_package;

import lab3.logic.NegativePriceException;
import lab3.logic.ProductCollection;
import lab3.logic.SomeFood;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ProductCollection collection = new ProductCollection();
        try {
            for(int i=0;i<10;i++) {
                collection.add(new SomeFood((float) (i*12.3), "product#1"));
            }
        } catch (NegativePriceException e) {
            e.printStackTrace();
        }
        Iterator itr = collection.iterator();
        System.out.println("COMMON ITERATOR");
        while (itr.hasNext())
            System.out.println(itr.next());


        System.out.println("\n\nITERATOR FOR PRICE IN [30;100]");

        itr = collection.iterator(30,100);
        while (itr.hasNext())
            System.out.println(itr.next());

    }
}
