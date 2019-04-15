package Ch6;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EntryTest {
    Entry<String, Integer> entry;
    String key = "K1";
    Integer value = 1;

    @Before
    public void setUp() throws Exception {
        entry = new Entry<String, Integer>(key, value);
    }

    @Test
    public void getKey() {
        assertEquals(entry.getKey(), key);
    }

    @Test
    public void getValue() {
        assertEquals(entry.getValue(), value);
    }
}