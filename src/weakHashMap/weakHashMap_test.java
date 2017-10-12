package weakHashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by mac on 2017/10/10.
 */
public class weakHashMap_test {
/*WeakHashMap和HashMap一样key和value的值都可以为null，并且也是无序的。
但是HashMap的null是存在table[0]中的，这是固定的，并且null的hash为0，而在WeakHashMap中的null却没有存入table[0]中。 */
    public static void main(String[] args) {
        Map<String,Integer> map=new WeakHashMap<String,Integer>();
        map.put("s1",1);
        map.put("s2",2);
        map.put("s3",3);
        map.put("s4",4);
        map.put(null,5);
        map.put("s5", 6);
        map.put(null,7);
        for (Map.Entry<String,Integer>entry:map.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        System.out.println(map);
        System.out.println("---------------------");
        Map<String,Integer> map1=new HashMap<>();
        map1.put("a",1);
        map1.put("b",12);
        map1.put("c",4);
        map1.put("d",3);
        map1.put(null,2);
        map1.put("e", 5);
        map1.put(null,11);
        for (Map.Entry<String,Integer>entry:map1.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

        System.out.println(map1);
    }
}
