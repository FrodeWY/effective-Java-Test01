package equals_test;

import java.awt.*;

/**
 * Created by mac on 2017/10/10.
 */
public class ColorPoint {
    private  final  Point point;
    private  final Color color;

    public ColorPoint(int x,int y, Color color) {
        if(color ==null) throw new NullPointerException();
        point=new Point(x,y);
        this.color=color;
    }
    /*point-view*/
    public Point asPoint(){
        return point;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof  ColorPoint))
            return false;
        ColorPoint colorPoint= (ColorPoint) obj;
        return colorPoint.point.equals(((ColorPoint) obj).asPoint())&&colorPoint.color.equals(color);
    }
    
}
