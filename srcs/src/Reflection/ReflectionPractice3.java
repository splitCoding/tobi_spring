package Reflection;

import java.lang.reflect.Constructor;

//객체이름으로 객체의 생성자 조회
public class ReflectionPractice3 {
    public static void main(String[] args) {
        try {
            Class find = Class.forName("ReflectionPractice3$FindMe");
            Constructor[] constructors = find.getConstructors();
            for (Constructor constructor : constructors) {
                System.out.println("constructor = " + constructor.getName());
                Class[] parameterTypes = constructor.getParameterTypes();
                for (int i = 0; i < parameterTypes.length; i++) {
                    System.out.println(i + " param = " + parameterTypes[i]);
                }
                System.out.println("----");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static class FindMe {
        public FindMe() {
        }

        public FindMe(int a, int b) {
        }
    }
}


/*
constructor = Reflection.ReflectionPractice3$FindMe
----
constructor = Reflection.ReflectionPractice3$FindMe
0 param = int
1 param = int
----
 */
