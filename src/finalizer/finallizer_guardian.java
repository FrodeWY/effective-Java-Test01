package finalizer;

/**
 * Created by mac on 2017/10/10.
 */
public class finallizer_guardian {
    //匿名类，终结守卫者
    private final Object finalizerGuardian=new Object(){
        //终结守卫者的终结方法将被执行
            @Override protected void finalize() throws Throwable{
                System.out.println("A finalize by the finalizerGuardian");
            }

    };
    //由于终结方法被子类覆盖，该终结方法并不会被执行
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finallizer_guardian finalize by the finalize method");
    }

    public static void main(String[] args) throws InterruptedException {
        /*忘了手动调用超类的终结方法，，则超类的终结方法永远不会被调用到，可以为每个将被终结的对象创建一个附加的对象，不是把终结方法放在要求终结处理的类中，
        而是把终结方法放在匿名类中，该匿名类的每一个实例都被称为终结方法守卫者*/
        B b = new B();
        b=null;
        System.gc();
        Thread.sleep(500);
    }
}
class B extends finallizer_guardian{
    @Override
    protected void finalize() throws Throwable {
        System.out.println("B finalize by the finalize method");
    }
}