package Object_Create_death;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by mac on 2017/10/10.
 */
public class Long_long {
    public static void main(String[] args) {
        Long sum=0L;//使用包装类，for循环创建了2的31次方个Long实例，大大影响了性能
        long start=System.currentTimeMillis();
        for(long i=0;i<Integer.MAX_VALUE;i++){
            sum+=i;
        }
        long end=System.currentTimeMillis();
        System.out.println("Long用时："+(end-start));
        System.out.println(sum);

        long sum1=0L;
        long start1=System.currentTimeMillis();
        for(long i=0;i<Integer.MAX_VALUE;i++){
            sum1+=i;
        }
        long end1=System.currentTimeMillis();
        System.out.println("Long用时："+(end1-start1));
        System.out.println(sum1);
        
    }
}
