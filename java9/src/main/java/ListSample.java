import java.util.List;

public class ListSample {
    public static void main(String[] args) {
        //불변 컬렉션 생성
        List<String> fruits = List.of("banana", "apple");

        //UnsupportedOperationException
        fruits.add("tomato");

        System.out.println(fruits);
    }
}
