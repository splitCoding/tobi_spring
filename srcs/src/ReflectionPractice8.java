import java.lang.reflect.Array;

//배열 생성, 사용

public class ReflectionPractice8 {
    public static void main(String[] args) {
        try {
            Class find = Class.forName("java.lang.String");
            Object arr = Array.newInstance(find, 10);
            Array.set(arr, 0, "a");
            Array.set(arr, 1, "b");
            Array.set(arr, 2, "c");
            Array.set(arr, 3, "d");
            Array.set(arr, 4, "e");
            Array.set(arr, 5, "f");
            for (int i = 0; i < 6; i++) {
                String result = (String) Array.get(arr, i);
                System.out.println("result = " + result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
result = a
result = b
result = c
result = d
result = e
result = f
*/