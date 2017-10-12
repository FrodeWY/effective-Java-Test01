package finalizer;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by mac on 2017/10/10.
 */
public class Finalizer_super {
    @Override
    protected void finalize() throws Throwable {

        System.out.println("Finalizer_super will be finalize");

    }

    public static void main(String[] args) {

        C c = new C();
        c=null;
        System.gc();

    }
}

class C extends Finalizer_super{

    /*如果子类覆盖了父类的终结方法，子类的终结方法就必须手动调用超类的终结方法*/
    @Override
    protected void finalize() throws Throwable {


        try {
            System.out.println(" c will be finalize");
        } finally {
            super.finalize();
        }
    }
}
