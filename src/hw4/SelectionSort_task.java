package hw4;

// Сортировка обменами. Дана последовательность чисел а 1 , а 2 , ..., а n . Требуется
// переставить числа в порядке возрастания. Для этого сравниваются два соседних числа аi
// и a i+1. Если а i  больше а i+1 , то делается перестановка. Так продолжается до тех пор,
// пока все элементы не станут расположены в порядке возрастания. Составить алгоритм сортировки,
// подсчитывая при этом количество перестановок.

// Примечание: задача была сделана в дз №2.

import java.util.Arrays;

public class SelectionSort_task
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

        System.out.println("SelectionSort:");
        SelectionSort ss = new SelectionSort();
        System.out.println("проверка (метод без рекурсии):");
        int count = ss.sort(array);
        System.out.println("количество перестановок: " + count);
        System.out.println(Arrays.toString(array));
        System.arraycopy(base_array, 0, array, 0, n);
        System.out.println("проверка (рекурсивный метод):");
        ss.sort(array, array.length);
        System.out.println(Arrays.toString(array));
    }
}

class SelectionSort
{
    public int sort(int [] array)
    {
        int count = 0;
        int max;
        int i_max;
        int buf;
        int n = array.length;
        for(int i = 0; i < n; i++)
        {
            i_max = 0;
            max = array[0];
            for(int j = 0; j < n - i; j++)
            {
                if (max < array[j])
                {
                    max = array[j];
                    i_max = j;
                    count++;
                }
            }
            buf = array[(n - 1) - i];
            array[(n - 1) - i] = max;
            array[i_max] = buf;
        }
        return count;
    }

    public void sort(int [] array, int lenght)
    {
        if (lenght > 0)
        {
            int max = array[0];
            int i_max = 0;
            for(int j = 0; j < lenght; j++)
            {
                if (max < array[j])
                {
                    max = array[j];
                    i_max = j;
                }
            }
            int buf = array[lenght - 1];
            array[lenght - 1] = max;
            array[i_max] = buf;
            lenght--;
            sort(array, lenght);
        }
    }
}
