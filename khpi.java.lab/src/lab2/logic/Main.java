package lab2.logic;

public class Main {


    public static void main(String[] args) {
        testNegativePrice();
        testWrongIndex();
    }

    private static void testWrongIndex() {
        //write in output for exceptions for preventing mixing of the messages.
        System.err.println("Test incorrect index : ");
        try {
            new ProductCollection().getAt(123);
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }

    private static void testNegativePrice() {
        //write in output for exceptions for preventing mixing of the messages.
        System.err.println("Test incorrect price : ");
        try {
            new SomeFood(-1,"milk");
        } catch (NegativePriceException e) {
            e.printStackTrace();
        }
    }

}
