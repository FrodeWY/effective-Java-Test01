package equals_test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by mac on 2017/10/10.
 */
public class CountPoint extends Point{
    private static final AtomicInteger count=new AtomicInteger();//AtomicInteger 原子性操作，线程安全的实现增减

    public CountPoint(int x, int y) {
        super(x, y);
        count.incrementAndGet();
    }
    public  int numberCreated(){
        return count.get();
    }

    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            CountPoint countPoint=new CountPoint(1,3);

            System.out.println(countPoint.numberCreated());
        }

    }
}
