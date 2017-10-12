package HashCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mac on 2017/10/11.
 */
/**
 * 覆蓋equals时总是要覆盖hashCode()*/
public class Test {
    private final short areaCode;
    private final short prefix;
    private final short lineNumber;
    private final boolean flag;
    private final long number;
    private final float aFloat;
    private final double aDouble;

    private volatile int hashcode;

    public Test(int areaCode, int prefix, int lineNumber,boolean flag,long number,float aFloat,double aDouble) {
        rangCheck(areaCode,999,"areaCode");
        rangCheck(prefix,999,"prefix");
        rangCheck(lineNumber,9999,"lineNumber");
        this.areaCode = (short) areaCode;
        this.prefix = (short)prefix;
        this.lineNumber = (short)lineNumber;
        this.flag = flag;
        this.number = number;
        this.aFloat = aFloat;
        this.aDouble=aDouble;
    }

    private static  void rangCheck(int arg, int max, String name){
        if(arg<0||arg>max){
            throw new IllegalArgumentException(name+": "+arg);
        }

    }
    @Override
    public boolean equals(Object obj) {
        if(obj==this){
            return true;
        }
        if(!(obj instanceof Test)){
            return false;
        }
        Test o=(Test) obj;
        return areaCode==o.areaCode&&prefix==o.prefix&&lineNumber==o.lineNumber&&flag==o.flag &&number==o.number &&aFloat==o.aFloat&&aDouble==o.aDouble;
    }

    @Override
    public int hashCode() {
        int result = hashcode;
        long LDouble=Double.doubleToLongBits(aDouble);
        if (result ==0 ){
            result=17;
            result=result*31+(int) areaCode;
            result=result*31+(int) prefix;
            result=result*31+(int) lineNumber;
            result=result*31+(flag?1:0);
            result=result*31+((int)(number^(number>>>32)));
            result=result*31+Float.floatToIntBits(aFloat);
            result=result*31+(int)(LDouble^(LDouble>>>32));
            hashcode=result;
        }
        return result;
    }

    public static void main(String[] args) {

        Map<Test,String> stringMap=new HashMap<>();
        Test a=new Test(707, 867, 5306,false,2L,32.12f,32.12);
        Test b=new Test(707, 867, 5306,false,2L,32.12f,32.12);
        System.out.println(a.equals(b));
        System.out.println(a.hashCode()+"  "+a.hashcode);
        stringMap.put(a,"jjj");
        System.out.println(stringMap.get(b));
    }
}
