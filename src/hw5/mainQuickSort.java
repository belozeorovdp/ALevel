package hw5;

import java.util.Arrays;

public class mainQuickSort
{
    public static void main(String[] args)
    {
        int n = 10;
        int base_array[] = new int[n];
        for (int i = 0; i < n; i++)
        {
            base_array[i]= (int)(Math.random()*10);
        }
        System.out.println("Исходный массив:");
        System.out.println(Arrays.toString(base_array));

        int array [] = new int[n];
        System.arraycopy(base_array, 0, array, 0, n);

        System.out.println("QuickSort:");
        System.out.println("проверка:");
        QuickSort qs = new QuickSort();
        int first = 0;
        int last  = n - 1;
        qs.sort(array, first, last);
        System.out.println(Arrays.toString(array));
    }
}
