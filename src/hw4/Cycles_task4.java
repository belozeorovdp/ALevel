package hw4;

// Электронные часы показывают время в формате от 00:00 до 23:59. Подсчитать сколько раз за сутки случается
// так, что слева от двоеточия показывается симметричная комбинация для той, что справа от двоеточия
//(например, 02:20, 11:11 или 15:51).

public class Cycles_task4
{
    public static void main(String[] args)
    {
        int hour1;
        int hour2;
        int minute1;
        int minute2;
        int count = 0;
        for (int i = 0; i < 24; i++)
        {
            hour1 = i%10;
            hour2 = i/10;
            for(int j = 0; j < 60; j++)
            {
                minute1 = j%10;
                minute2 = j/10;
                if(hour1 == minute2 && hour2 == minute1)
                {
                    count++;
                }
            }
        }
        System.out.println("count = " + count);
    }
}
