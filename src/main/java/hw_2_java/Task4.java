package main.java.hw_2_java;

/* Мое имя
Вывести на экран свое имя 5 строк по 10 раз (через пробел).
System.out.println, System.out.print можно использовать только по одному разу
для этого нужно воспользоваться циклом do () while
*/

public class Task4 {

    public static void main(String[] args) {

        String myName = "Alexandra";

        int i = 0;

        do {
            int  j=0;
            // вложенный do-while выводит строку с 10ю именами
            do {
                System.out.print(myName + " ");
                j++;

            } while (j < 10);

            System.out.println();
            i++;
        }

        while (i < 5);
    }

}
