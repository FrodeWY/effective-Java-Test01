package Object_Create_death;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mac on 2017/10/10.
 */
public class Person_test {

/**
 * 改进后的person类，只有在初始化的时候创建Calendar,TimeZone和Date一次，而不是每次调用isBabyBoomer都创建这些实例，显著提高性能*/
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
        Date birthday=format.parse("1948-11-01 13:34:51");
        Person person=new Person(birthday);
        System.out.println(person.isBabyBoomer());
        long start=System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            person.isBabyBoomer();
        }
        long end=System.currentTimeMillis();
        System.out.println("person用时：" + (end - start));
        Person_b person_b=new Person_b(birthday);
        System.out.println(person_b.isBabyBoomer());
        long start2=System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            person_b.isBabyBoomer();
        }
        long end2=System.currentTimeMillis();
        System.out.println("perons_b用时："+(end2-start2));

    }
}
