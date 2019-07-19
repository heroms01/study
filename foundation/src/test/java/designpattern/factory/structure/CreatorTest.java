package designpattern.factory.structure;

import org.junit.jupiter.api.Test;

import java.util.Random;

class CreatorTest {

    @Test
    void someOperation() {
        Random random = new Random();

        Integer type = random.nextInt(2);
        Creator creator = null;

        if (type.equals(0))
            creator = new CreatorA();
        else if (type.equals(1))
            creator = new CreatorB();

        creator.someOperation();
    }
}
