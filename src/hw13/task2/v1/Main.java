package hw13.task2.v1;

// Реализовать поиск простых чисел внутри заданного диапазона.
// Ввести с клавиатуры интервал поиска чисел (например, от 1 до 10000) и число потоков.
// Проверку на простоту реализовать самым простым способом: циклом от 2 до числа/2.
// Найденные числа должны быть записаны в одну общую коллекцию.
//
// Сделать на Thread и на Executor-ахю

// примечание: задание делал по памяти, при комите только посмотрел, отличается от исходной тем что ввода диапазона
// нет с клавиатуры, диапозон выбран от 0 до 10000, разбит на потоки, в данном случае на 2, каждый переберает свой
// диапозон в конце решения склеиваются.

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        Prime solve1 = new Prime(1,5000);
        Prime solve2 = new Prime(5001,10000);

        solve1.start();
        solve2.start();

        while(solve1.isAlive()|| solve2.isAlive())
        {
        }

        List<Long> listResult = new ArrayList<Long>(solve1.getMassif());
        listResult.addAll(solve2.getMassif());

        for(int i = 0; i < listResult.size(); i++)
        {
            System.out.println(listResult.get(i));
        }
    }
}
