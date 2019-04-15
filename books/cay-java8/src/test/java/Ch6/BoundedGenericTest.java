package Ch6;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class BoundedGenericTest {

    @Test
    public void closeAll() throws Exception {
        List<PrintStream> printStreams = Arrays.asList(new PrintStream("1"), new PrintStream("2"));
        BoundedGeneric.closeAll(printStreams);
    }
}