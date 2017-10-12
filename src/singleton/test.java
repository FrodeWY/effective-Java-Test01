package singleton;


/**
 * Created by mac on 2017/10/9.
 */
public class test {


    public static void main(String[] args) {
        Singleton03 singleton1=Singleton03.INSTANCE;
        System.out.println(singleton1.getAge());
        singleton1.setAge(23);
        Singleton03 singleton2=Singleton03.INSTANCE;
        System.out.println(singleton2.getAge());
        System.out.println(singleton1==singleton2);
    }

}
