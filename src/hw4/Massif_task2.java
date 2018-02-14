package hw4;

// Cоздать двумерный массив из 7 строк по 4 столбца в каждой из случайных целых чисел из отрезка [-5;5].
// Вывести массив на экран. Определить и вывести на экран индекс строки с наибольшим по модулю произведением
// элементов. Если таких строк несколько, то вывести индекс первой встретившейся из них.

import java.util.Arrays;

public class Massif_task2
{
    public static void main(String[] args)
    {
        int n = 7;
        int m = 4;
        int[][] massif = new int[n][m];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                int a = -5;  // Начальное значение диапазона - "от"
                int b =  5;  // Конечное значение диапазона - "до"
                int b_mr = b - a;
                massif[i][j] = a + (int) (Math.random() * b_mr);
            }
        }
        for (int i = 0; i < n; i++)
        {
            System.out.println(Arrays.toString(massif[i]));
        }
        int multiplication = 1;
        int max_multiplication = 0;
        int index_max_multiplication = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                multiplication *=  massif[i][j];
            }
            multiplication = Math.abs(multiplication);
            if (max_multiplication < multiplication)
            {
                max_multiplication = multiplication;
                index_max_multiplication = i;
            }
        }
        System.out.println("index_max_multiplication = " + index_max_multiplication);
        System.out.println(Arrays.toString(massif[index_max_multiplication]));
    }
}