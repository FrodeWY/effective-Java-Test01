package weakHashMap;

import java.util.*;

/**
 * Created by mac on 2017/10/10.
 */
public class weakHashMap_test2 {
    public static void main(String[] args) {
        /*这两段代码比较可以看到WeakHashMap的功效，如果在系统中需要一张很大的Map表，Map中的表项作为缓存只用，
        这也意味着即使没能从该Map中取得相应的数据，系统也可以通过候选方案获取这些数据。虽然这样会消耗更多的时间，但是不影响系统的正常运行。
        在这种场景下，使用WeakHashMap是最合适的。因为WeakHashMap会在系统内存范围内，保存所有表项，而一旦内存不够，在GC时，没有被引用的表项又会很快被清除掉，
        从而避免系统内存溢出。 */
       /* Map<Integer,Object> map=new HashMap<>();
        for (int i=0;i<100000;i++){
            Integer ii=new Integer(i);
            map.put(ii,new byte[i]);

        }*/


        /*Map<Integer,Object> weakmap=new WeakHashMap<>();
        for (int i=0;i<100000;i++){
            Integer ii=new Integer(i);
            weakmap.put(ii,new byte[i]);
        }*/



        /*如果存放在WeakHashMap中的key都存在强引用，那么WeakHashMap就会退化成HashMap。如果在系统中希望通过WeakHashMap自动清楚数据，
        请尽量不要在系统的其他地方强引用WeakHashMap的key，否则，这些key就不会被回收，WeakHashMap也就无法正常释放它们所占用的表项。*/
        Map<Integer,Object> weakmap2=new WeakHashMap<>();
        List<Integer>list=new ArrayList<>();
        for (int i=0;i<100000;i++){

            Integer ii=new Integer(i);
            list.add(ii);
            weakmap2.put(ii,new byte[i]);
        }
    }
}
