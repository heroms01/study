package Ch6;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/*
#타입 경계
 타입 파라미터의 타입을 제한할 수 있다.
 */
public class BoundedGeneric {
    /*
    다음과 같이 다중 경계를 지정할 수도 있다.
    public static <T extends Runnable & AutoCloseable> void closeAll(List<T> elements) throws Exception {
     */
    public static <T extends AutoCloseable> void closeAll(List<T> elements) throws Exception {
        for (T el : elements) {
            el.close();
        }
    }
}
