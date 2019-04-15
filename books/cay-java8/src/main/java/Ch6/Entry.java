package Ch6;

/*
#제네릭 클래스
 제네릭 클래스는 타입 파라미터를 한개 이상 받는 클래스다.
 타입 파라미터 인스턴스는 기본타입으로 만들수 없다.
 제네릭 클래스의 개개체를 생성할 때 생성자에 타입 파라미터를 생략할 수 있다.
 빈 꺽쇠를 다이아몬드라 한다.
 */
public class Entry<K, V> {
    K key;
    V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() { return key; }
    public V getValue() { return value; }
}
