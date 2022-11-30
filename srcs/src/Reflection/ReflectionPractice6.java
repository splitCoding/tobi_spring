package Reflection;

import java.lang.reflect.Constructor;

//새로운 객체 생성하기

public class ReflectionPractice6 {
    public static void main(String[] args) {
        try {
            Class find = Class.forName("Reflection.ReflectionPractice1");
            Constructor[] constructors = find.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                int parameterCount = constructor.getParameterCount();
                //인자가 없는 생성자만 사용
                if(parameterCount == 0){
                    Object o = constructor.newInstance();
                    System.out.println("o.getClass() = " + o.getClass());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
o.getClass() = class Reflection.ReflectionPractice1
*/