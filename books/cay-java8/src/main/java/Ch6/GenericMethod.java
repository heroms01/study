package Ch6;
/*
#제네릭 메서드
 제네릭 메서드는 타입 파라미터를 받는 메서드다.
 선언시 타입 파라미터를 반환 타입 앞에 둔다.
 호출시 타입 파라미터를 명시하지 않도 컴파일러가 추론 한다.
 원한다면 타입을 명시적으로 지정할 수 있다.
 지정시 더 자세한 오류 메시지를 얻을수 있다.
 */
public class GenericMethod {
    public static <T> T returnData(T data) {
        return data;
    }
}
