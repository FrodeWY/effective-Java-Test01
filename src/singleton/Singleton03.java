package singleton;

/**
 * Created by mac on 2017/10/9.
 */

/**
 * 单元素枚举类型是实现singleton的最佳方法*/
public enum Singleton03 {
    INSTANCE;
    private int age=10;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void leava(){
        System.out.println(1);
    }

}
