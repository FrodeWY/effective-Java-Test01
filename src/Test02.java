/**
 * Created by mac on 2017/10/9.
 */
/**
 * 层叠构造器模式*/
public class Test02 {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carvohydrate;

    public Test02(int ServingSize,int servings){
        this(ServingSize,servings,0);
    }

    public Test02(int servingSize, int servings, int calories) {
        this(servingSize,servings,calories,0);
    }

    public Test02(int servingSize, int servings, int calories, int fat) {
        this(servingSize,servings,calories,fat,0);
    }

    public Test02(int servingSize, int servings, int calories, int fat, int sodium) {
        this(servingSize,servings,calories,fat,sodium,0);
    }

    public Test02(int servingSize, int servings, int calories, int fat, int sodium, int carvohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carvohydrate = carvohydrate;
    }

    public static void main(String[] args) {
        Test02 test02 = new Test02(1,2);
        System.out.println("end");
    }
}
