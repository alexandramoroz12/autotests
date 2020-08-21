package main.java.hw_2_java;

 /* Минимум трех чисел
    Написать функцию, которая вычисляет минимум из трёх чисел.
    */

public class Task1 {

    public static void main(String[] args) {

        System.out.println(min(0,3,3));
    }

    public static int min(int a, int b, int c) {

        int min_value;

        if (a < b || a < c) {min_value = a;}
        else
        if (b < a || b < c) {min_value = b;}
        else min_value = c;

        return min_value;
    }

}



