package lab2.logic;

public class NegativePriceException extends Exception {
    public NegativePriceException(float price) {
        super((new StringBuilder()).append("Incorrect price: ").append(price).toString());
    }
}
