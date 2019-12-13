import static org.junit.jupiter.api.Assertions.*;

class RamenFactoryTest {

    @org.junit.jupiter.api.Test
    void solution() {
        RamenFactory ramenFactory = new RamenFactory();
        assertEquals(0, ramenFactory.solution(20, new int[] {4,10,15}, new int[] {20,5,10}, 20));
//        assertEquals(2, ramenFactory.solution(4, new int[] {4,10,15}, new int[] {20,5,10}, 30));
    }
}
