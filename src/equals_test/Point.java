package equals_test;

/**
 * Created by mac on 2017/10/10.
 */
public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass()!=getClass()){//用instanceof会导致如果point 子类拓展了属性，将违反equals的传递性约定，但是使用getClass会违背里氏替换原则
            return false;
        }
        Point p=(Point)obj;
        return x==p.x&&y==p.y;
    }
}
