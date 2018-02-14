package hw4;

// Создать двумерный массив из 8 строк по 5 столбцов в каждой из случайных целых чисел из отрезка [10;99].
// Вывести массив на экран.

import java.util.Arrays;

public class Massif_task1
{
    public static void main(String[] args)
    {
        int n = 8;
        int m = 5;
        int[][] massif = new int[n][m];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                int a = 10;  // Начальное значение диапазона - "от"
                int b = 100; // Конечное значение диапазона - "до"
                int b_mr = b - a;
                massif[i][j] = a + (int) (Math.random() * b_mr);
            }
        }
        for (int i = 0; i < n; i++)
        {
            System.out.println(Arrays.toString(massif[i]));
        }
    }
}