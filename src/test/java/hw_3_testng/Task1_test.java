package test.java.hw_3_testng;

import main.java.hw_3_testng_java.Task1TestNGJava;
import org.testng.annotations.DataProvider;
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


    //data provider

    @Test (dataProvider = "dataProviderforTask1")
    public void  test2 (int arr [], int expected) {

        // создаем объект класса чтобы при каждом запуске теста создавался новый объект
        Task1TestNGJava task1TestNGJava = new Task1TestNGJava();
        int actual = task1TestNGJava.minOfThreeIntNumbers(arr);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "dataProviderforTask1")
    public Object[][] provider () {

        return new Object[][]{
                {new int [] {3, 6, 8, 0, -1}, -1},
                {new int [] {80, -60, 4, 13, 67, 23}, -60},
                {new int [] {0, 5, 3}, 0},
                {new int [] {8, 5, -17, 8}, -17}
        };
    }

}
