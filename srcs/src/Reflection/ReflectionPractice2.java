package Reflection;

import java.lang.reflect.Method;

//객체, 메서드 이름으로 메서드를 조회
public class ReflectionPractice2 {
    public static void main(String[] args) {
        try {
            Class find = Class.forName("java.lang.Math");
            Method method = find.getDeclaredMethod("abs", float.class);
            System.out.println("method.getName() = " + method.getName());
            System.out.println("method.getDeclaringClass() = " + method.getDeclaringClass());
            Class[] parameterTypes = method.getParameterTypes();
            for (Class parameterType : parameterTypes) {
                System.out.println("parameterType = " + parameterType);
            }
            Class[] exceptionTypes = method.getExceptionTypes();
            if (exceptionTypes.length == 0) {
                System.out.println("exceptionType = ");
            } else {
                for (Class exceptionType : exceptionTypes) {
                    System.out.println("exceptionType = " + exceptionType);
                }
            }
            System.out.println("method.getReturnType() = " + method.getReturnType());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
method.getName() = abs
method.getDeclaringClass() = class java.lang.Math
parameterType = float
exceptionType =
method.getReturnType() = float
 */
