package factory.structure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreatorTest {

    @Test
    void someOperation() {
        String type = "B";
        Creator creator = null;

        if (type.equals("A"))
            creator = new CreatorA();
        else if (type.equals("B"))
            creator = new CreatorB();

        creator.someOperation();
    }
}