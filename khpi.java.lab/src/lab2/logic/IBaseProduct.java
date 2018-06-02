package lab2.logic;

public interface IBaseProduct {
    float getPrice();

    String getName();

    void setPrice(float price) throws NegativePriceException;

    void setName(String name);
}
