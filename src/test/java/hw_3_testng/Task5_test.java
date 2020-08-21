package test.java.hw_3_testng;

import main.java.hw_3_testng_java.Task5TestNGJava;
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
}
