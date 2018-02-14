package hw4;

// Для введённого пользователем с клавиатуры натурального числа посчитайте сумму всех его цифр
// (заранее не известно сколько цифр будет в числе).

import java.util.Scanner;

public class Cycles_task1
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите натуральное число типа int (не больше 2^31 - 1): ");
        int number = in.nextInt();
        if(number < 0)
        {
            System.out.println("Error! Вы ввели отрицательное число.");
            return;
        }
        else
        {
            // определяем разрядность числа
            int result = number;
            int rank = 0;
            do
            {
                result /= 10;
                rank++;
            }while (result != 0);
            System.out.println("rank: " + rank);
            // определяем цифру в разряде и вычисляем сумму цифр
            int sum = 0;
            for(int i = 0; i < rank; i++)
            {
                if (i == 0)
                {
                    result = number%(int)Math.pow(10,(i + 1));
                }
                else
                {
                    result = (number%(int)Math.pow(10,(i + 1)))/(int)Math.pow(10,i);
                }
                System.out.println("digit: " + result);
                sum += result;
            }
            System.out.println("sum: " + sum);
        }
    }
}
