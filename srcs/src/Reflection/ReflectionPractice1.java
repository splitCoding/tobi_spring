package Reflection;

import java.lang.reflect.Method;

public class ReflectionPractice1 {
    public static void main(String[] args) {
        try{
            Class find = Class.forName("java.lang.Math");
            Method[] methods = find.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(find +".method = " + method);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

/*
class java.lang.Math.method = public static float java.lang.Math.abs(float)
class java.lang.Math.method = public static long java.lang.Math.abs(long)
...
class java.lang.Math.method = static double java.lang.Math.powerOfTwoD(int)
class java.lang.Math.method = static float java.lang.Math.powerOfTwoF(int)
 */