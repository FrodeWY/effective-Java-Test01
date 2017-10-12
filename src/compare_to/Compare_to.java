package compare_to;

/**
 * Created by mac on 2017/10/12.
 */

/**
 * compareTo 约定：
 * 1.sgn(x.compareTo(y)==-sgn(y.compareTo(x)))对称性
* 2.x.compareTo(y)>0&&y.compareTo(z)>0则x.compareTo(z)>0传递性
 * 3.x.compareTo(y)==0 sgn(x.compareTo(z))==sgn(y.compareTo(z))
 * 4.强连建议：(x.compareTo(y)==0)==x.equals(y),因为有序集合(TreeSet,TreeMap)通用约定的是按照compareTo()方法定义的，无序集合则是按照equals()定义的,
 * 例如：new BigDecimal("1.0")和new BigDecimal("1.00")在HashSet中被当作两个实例，而在TreeSet中被当作一个
 * 5.compareTo 比较顺序，从最关键的开始逐渐比较所有重要域*/
public class Compare_to implements Comparable<Compare_to>{

    private  int areaCode;
    private  int prefix;
    private  double price;
    private  float aFloat;
    private  int lineNumber;

    public Compare_to(int areaCode, int prefix, int lineNumber) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNumber = lineNumber;
    }

    public Compare_to(int areaCode, int prefix, int lineNumber, double price, float aFloat) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNumber = lineNumber;
        this.price = price;
        this.aFloat = aFloat;
    }

    public Compare_to(int areaCode, int prefix) {
        this.areaCode = areaCode;
        this.prefix = prefix;
    }
/*这种技巧可以提高运行速度，但是需要注意，最大值和最小值只差小于或等于INTEGER.MAX_VALUE(2^31-1),否则溢出*/
    @Override
    public int compareTo(Compare_to o) {
        int areaCodeResult=this.areaCode-o.areaCode;
        if(areaCodeResult!=0){
            return areaCodeResult;
        }
        int prefixResult=this.prefix-o.prefix;
        if (prefixResult!=0){
            return prefixResult;
        }
        int priceResult=Double.compare(price,o.price);
        if(priceResult!=0){
            return priceResult;
        }
        int aFloatResult=Float.compare(aFloat,o.aFloat);
        if(aFloatResult!=0){
            return aFloatResult;
        }
        return lineNumber-o.lineNumber;
    }

    public static void main(String[] args) {
        Compare_to a=new Compare_to(12,35,53,12.51,42.1f);
        Compare_to b=new Compare_to(12,35,53,13.41,42.1f);
        Compare_to c=new Compare_to(12,31,53);
        Compare_to d=new Compare_to(12,35);
        System.out.println(a.compareTo(b));
        System.out.println(b.compareTo(c));
        System.out.println(a.compareTo(d));

    }
}
