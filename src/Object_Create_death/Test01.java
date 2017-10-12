package Object_Create_death;

/**
 * Created by mac on 2017/10/10.
 */
public class Test01 {
    public static void main(String[] args) {
        String s="a";
        String a="a";
        String c=new String("a");
        System.out.println(s==a);
        System.out.println(s==c);
        s="c";
        System.out.println(s==a);
        System.out.println(s.equals(a));
        Boolean aBoolean=new Boolean("true");
        Boolean bBoolean=new Boolean("true");
        System.out.println(aBoolean==bBoolean);
        Boolean aBoolean1=Boolean.valueOf("true");//静态工厂方法Boolean.valueof()几乎总是优先构造器Boolean()使用，避免创建不必要的对象；
        Boolean aBoolean2=Boolean.valueOf("true");
        System.out.println(aBoolean1==aBoolean2);


    }
}
