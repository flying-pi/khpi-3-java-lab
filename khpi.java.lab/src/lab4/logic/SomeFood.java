package lab4.logic;

import java.util.Calendar;
import java.util.Date;

public class SomeFood extends BaseProduct implements ISomeFood {
    private Date exparationDate;

    private static Date getTemorrow(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR,1);
        return calendar.getTime();
    }

    public SomeFood() throws NegativePriceException {
        this(0,"");
    }

    public SomeFood(float price, String name) throws NegativePriceException {
        this(price, name, getTemorrow());
    }

    public SomeFood(float price, String name, Date exparationDate) throws NegativePriceException {
        super(price, name);
        this.exparationDate = exparationDate;
    }

    @Override
    public String toString() {
        return (new StringBuilder())
                .append(super.toString())
                .append(" eparation date : ")
                .append(exparationDate.toString())
                .toString();
    }

    @Override
    public Date getExparationDate() {
        return exparationDate;
    }

    @Override
    public void setExparationDate(Date exparationDate) {
        this.exparationDate = exparationDate;
    }

    @Override
    public SomeFood clone() throws CloneNotSupportedException {
        SomeFood result = (SomeFood) super.clone();
        result.exparationDate = new Date(exparationDate.getTime());
        return result;
    }
}
