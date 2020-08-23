package test.java.hw_3_testng;

import main.java.hw_3_testng_java.Task5TestNGJava;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Task5_test {

    @Test
    public static void test1 () {

        String str = "Hello world!!!";

        String actual = Task5TestNGJava.returnReverseString(str);
        String expected = "!!!dlrow olleH";
        assertEquals(actual, expected);
    }

    @Parameters ({"string_to_reverse", "reversed_string"})
    @Test
    public void xmlParams (@Optional String string_to_reverse, @Optional String reversed_string) {

        assertEquals(string_to_reverse, reversed_string);

    }
}
