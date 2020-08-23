package test.java.hw_3_testng;


import main.java.hw_3_testng_java.Task2TestNGJava;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class Task2_test {

    Task2TestNGJava task2TestNGJava;


    @BeforeClass
    public void beforeAllMethods () {
        task2TestNGJava = new Task2TestNGJava ();
    }

    @BeforeMethod
    public void setUp (){
        //task2TestNGJava = new Task2TestNGJava ();
    }

    @AfterMethod
    public void tearDown () {
        System.out.println("- After Method");
    }

    @AfterClass
    public void afterAllMethods () {
        System.out.println("- After all Methods");
    }


    @Test //(groups = "test matrix")
    public void testMatrixRowEquality () { // test checked that matrix has 5 rows

        String result = task2TestNGJava.returnNameUsingForLoop();

        int expectedRowAmount = 5;
        int actualRowAmount = result.split("\n").length;
        assertEquals(actualRowAmount,expectedRowAmount);

    }

    @Test // (groups = "test matrix")
    public void testMatrixRowsLengthEquality () { // test checked that matrix's row length is 10

        String result = task2TestNGJava.returnNameUsingForLoop();

       String rows [] = result.split("\n");

       for (String row: rows) {
           int expectedRowLength = 10;
           int actualRowLength = row.split(" ").length ;
           assertEquals(expectedRowLength, actualRowLength);

       }

    }

}
