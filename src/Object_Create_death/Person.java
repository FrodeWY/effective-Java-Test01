package Object_Create_death;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by mac on 2017/10/10.
 */
public class Person {
    private final Date BIRTHDATE;

    public Person(Date BIRTHDATE) {
        this.BIRTHDATE = BIRTHDATE;

    }
    public boolean isBabyBoomer(){
        Calendar gmt=Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmt.set(1946,Calendar.JANUARY,1,0,0,0);
        Date boomStart=gmt.getTime();
        gmt.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomEnd=gmt.getTime();
        return BIRTHDATE.compareTo(boomStart)>=0&&BIRTHDATE.compareTo(boomEnd)<0;
    }
}
