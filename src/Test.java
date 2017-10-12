import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by mac on 2017/10/9.
 */
public class Test {
    //创建参数化类型实例时，使代码更简洁
    public static <K,V>HashMap<K,V> newInstance(){
        return new HashMap<K,V>();
    }

    public static void main(String[] args) {
        HashMap<String,List<String>>m=Test.newInstance();
        List<String> list=new ArrayList<String>();
        m.put("1",list);
    }
}
