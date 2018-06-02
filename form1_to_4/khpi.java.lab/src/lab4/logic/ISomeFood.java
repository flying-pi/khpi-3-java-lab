package lab4.logic;

import java.util.Date;

public interface ISomeFood extends IBaseProduct {
    Date getExparationDate();

    void setExparationDate(Date exparationDate);
}
