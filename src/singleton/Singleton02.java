package singleton;

import java.io.Serializable;

/**
 * Created by mac on 2017/10/9.
 */
public class Singleton02 implements Serializable{
    private static final long serialVersionUID=1L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    private int anInt=1;

    public int getAnInt() {
        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    private final static Singleton02 INSTANCE=new Singleton02();
    private Singleton02(){}
    public static Singleton02 getInstance(){
        return  INSTANCE;
    }

    private  Object readResolve(){
        return  INSTANCE;
    }
}
