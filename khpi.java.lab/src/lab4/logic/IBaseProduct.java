package lab4.logic;

public interface IBaseProduct extends Cloneable{
    float getPrice();

    String getName();

    void setPrice(float price) throws NegativePriceException;

    void setName(String name);

    IBaseProduct clone() throws CloneNotSupportedException;
}
