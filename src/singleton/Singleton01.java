package singleton;

import java.io.Serializable;

/**
 * Created by mac on 2017/10/9.
 */
public class Singleton01 implements Serializable{
    private final static long SerialVersionUID=1L;

    public static long getSerialVersionUID() {
        return SerialVersionUID;
    }

    private int anInt=1;

    public int getAnInt() {
        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    private final static Singleton01 INSTANCE=new Singleton01();
    private Singleton01(){}
    public static Singleton01 getInstance(){
        return  INSTANCE;
    }

    public static void main(String[] args) {
        Singleton01 instance = Singleton01.getInstance();
        System.out.println(instance.getAnInt());
        instance.setAnInt(2);
        Singleton01 instance1 = Singleton01.getInstance();
        System.out.println(instance1.getAnInt());

        byte[] bytes= Serializable_test.serialize(instance);
        Singleton01 singleton01= (Singleton01) Serializable_test.unserialize(bytes);
        Singleton01 singleton02= (Singleton01) Serializable_test.unserialize(bytes);
        System.out.println(singleton01==singleton02);//没有readResolve()，每次反序列化得到的对象都是新的，违背了singleton原则

        Singleton02 singleton2= Singleton02.getInstance();
        byte[]bytes2= Serializable_test.serialize(singleton2);
        Singleton02 singleton2_Unseria1= (Singleton02) Serializable_test.unserialize(bytes2);
        Singleton02 singleton2_Unseria2 = (Singleton02) Serializable_test.unserialize(bytes2);
        System.out.println(singleton2_Unseria1==singleton2_Unseria1);//通过readResolve()两次反序列化得到的对象是同一个对象

    }
}
