package hw4;

// Выведите на экран первые 11 членов последовательности Фибоначчи. Напоминаем, что первый и
// второй члены последовательности равны единицам, а каждый следующий — сумме двух предыдущих.
// для проверки числа Фибоначчи:
// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711

import java.util.Scanner;

public class Cycles_task2
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество чисел Фибоначчи для просмотра: ");
        int number = in.nextInt();
        for (int i = 0; i <= number; i++)
        {
            System.out.println("Число Фибоначчи номер(" + i + ")= " + Fibonacci(i));
        }
    }

    public static int Fibonacci(int number)
    {
        if ( number <= 0)
        {
            return 0;
        }
        else if ( number <= 2)
        {
            return 1;
        }
        return Fibonacci(number - 1) + Fibonacci(number - 2);
    }
}
