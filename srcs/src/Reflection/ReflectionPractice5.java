package Reflection;

import java.lang.reflect.Method;

//메서드 정보로 메서드 호출하기

public class ReflectionPractice5 {
    public static void main(String[] args) {
        try {
            Class find = Class.forName("ReflectionPractice5$FindMe");
            Method add = find.getMethod("add", new Class[]{Integer.class, Integer.class});
            Object addResult = add.invoke(new FindMe(), new Object[]{1, 20});
            System.out.println("addResult = " + addResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class FindMe {
        public int add(Integer a, Integer b) {
            return a + b;
        }
    }
}

/*
addResult = 21
*/