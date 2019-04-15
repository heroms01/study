package Ch6;

import org.junit.Test;

import static org.junit.Assert.*;

public class GenericMethodTest {

    @Test
    public void returnData() {
        String data1 = "D1";
        Integer data2 = 1;

        assertEquals(data1, GenericMethod.returnData(data1));
        assertEquals(data2, GenericMethod.returnData(data2));
    }

    @Test
    public void 타입지정() {
        String data1 = "D1";
        Integer data2 = 1;

        assertEquals(data1, GenericMethod.<String>returnData(data1));
        assertEquals(data2, GenericMethod.<Integer>returnData(data2));
    }
}