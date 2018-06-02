package lab4.logic;

public class NegativePriceException extends RuntimeException {
    public NegativePriceException(float price) {
        super((new StringBuilder()).append("Incorrect price: ").append(price).toString());
    }
}
