package tpo.triangle;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

public class Triangle{
    private float a;
    private float b;
    private float c;

    public Triangle(float oneSide, float secondSide, float thirdSide) {
        a = oneSide;
        b = secondSide;
        c = thirdSide;
    }

    public boolean isIsosceles(){
        if(a == b || b == c || a == c){
            return true;
        }else {
            return false;
        }
    }
    public boolean isEquilateral(){
        if(a == b && b == c){
            return true;
        }else {
            return false;
        }
    }

    public boolean isRectangular(){
        if (a*a+b*b==c*c||b*b+c*c==a*a||a*a+c*c==b*b) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean isTriangle(float side_one, float side_second, float side_tree){
        float max_side = Math.max(side_one, Math.max(side_one, side_tree));
        if((side_one+side_second+side_tree-max_side) > max_side){
            return true;
        }else{
            return false;
        }
    }
}