package test.java.hw_3_testng;

import main.java.hw_3_testng_java.Task1TestNGJava;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Task1_test {


    @Test
    public void  test1 () {
        int arr [] = {2,-4, 7, 9};
        int actual = Task1TestNGJava.minOfThreeIntNumbers(arr);
        int expected = -4;
        assertEquals(actual, expected);
    }
}
