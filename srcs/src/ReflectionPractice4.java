import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

//객체 이름으로 필드 조회하기
public class ReflectionPractice4 {
    public static void main(String[] args) {
        try {
            Class find = Class.forName("ReflectionPractice4$FindMe");
            Field[] fields = find.getDeclaredFields();
            for (Field field : fields) {
                int modifiers = field.getModifiers();
                System.out.println("modifiers = " + Modifier.toString(modifiers));
                System.out.println("field.getType() = " + field.getType());
                System.out.println("field.getName() = " + field.getName());
                System.out.println("---");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class FindMe {
        public final String field1 = "";
        private int field2 = 0;
        protected boolean field3 = true;

        public FindMe() {
        }

        public FindMe(int a, int b) {
        }
    }
}

/*
modifiers = public final
field.getType() = class java.lang.String
field.getName() = field1
---
modifiers = private
field.getType() = int
field.getName() = field2
---
modifiers = protected
field.getType() = boolean
field.getName() = field3
---
 */