package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

//필드의 값을 변경하기

public class ReflectionPractice7 {
    public static void main(String[] args) {
        try {
            Class find = Class.forName("ReflectionPractice7$UpdateMe");
            Field field1 = find.getDeclaredField("field1");
            Constructor constructor = find.getDeclaredConstructor();
            Object updateMe = constructor.newInstance();
            System.out.println("before field1 = " + ((UpdateMe) updateMe).field1);
            field1.set(updateMe, "Change");
            System.out.println("after field1 = " + ((UpdateMe) updateMe).field1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class UpdateMe {
        String field1 = "default";
    }
}

/*
updateMe.field1 = default
updateMe.field1 = Change
*/