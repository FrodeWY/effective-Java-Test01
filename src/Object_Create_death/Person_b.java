package Object_Create_death;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by mac on 2017/10/10.
 */
public class Person_b {
    private  final Date BIRTHDATE;
    private static  final Date BOOM_START;
    private static  final Date BOOM_END;

    public Person_b(Date BIRTHDATE) {
        this.BIRTHDATE = BIRTHDATE;
    }

    static {
        Calendar gmt = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmt.set(1946,1,0,0,0,0);
        BOOM_START=gmt.getTime();
        gmt.set(1965, 1, 0, 0, 0, 0);
        BOOM_END=gmt.getTime();
    }
    public boolean isBabyBoomer(){
        return BIRTHDATE.compareTo(BOOM_START)>=0&&BIRTHDATE.compareTo(BOOM_END)<0;
    }
}
