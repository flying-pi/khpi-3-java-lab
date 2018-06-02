package lab1;

import java.util.Calendar;
import java.util.Date;

public class SomeFood extends BaseProduct {
    private Date exparationDate;

    private static Date getTemorrow(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR,1);
        return calendar.getTime();
    }

    public SomeFood(){
        this(0,"");
    }

    public SomeFood(float price, String name) {
        this(price, name, getTemorrow());
    }

    public SomeFood(float price, String name, Date exparationDate) {
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

    public Date getExparationDate() {
        return exparationDate;
    }

    public void setExparationDate(Date exparationDate) {
        this.exparationDate = exparationDate;
    }
}
