package datastructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class StackArrayTest {
    @Test
    void testStackPushAndPop() {
        StackArray stackArray = new StackArray();
        stackArray.push("Model 1");
        stackArray.push("Model 2");
        stackArray.push("Model 3");

        assertEquals("Model 3", stackArray.pop());
        assertEquals("Model 2", stackArray.pop());
        assertEquals("Model 1", stackArray.pop());
        assertNull(stackArray.pop());
    }
}
