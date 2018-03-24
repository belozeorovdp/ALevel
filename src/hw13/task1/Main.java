package hw13.task1;

// Создать консольный ипподром.
// Перед стартом выписывается варианты лошадей которые будут бегать.(номер и имя).
// Далее, после того как были сделаны ставки, лошадей выпускают на бега.
// Длина круга 1000м. Лошадь за раз пробегает рандомно [30-50]м и “засыпает” на [300 -400] миллисекунд. При пересечении
// финиша, надо выписать какая лошадь победила и кто делал на нее ставку

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        int indexWin = -1;
        List<Car> cars = new ArrayList<Car>();
        for(int i = 0; i < 5; i++)
        {
            cars.add(new Car());
        }

        // пусть имя будет название потока, а порядковый номер индекс в массиве
        System.out.println("В заезде участвует:");
        for(int i = 0; i < 5; i++)
        {
            System.out.println(cars.get(i).getName() + ", " + i);
        }
        System.out.println();
        System.out.println("Выберите на кого ставите.");
        Scanner scan = new Scanner(System.in);
        int indexPlay = scan.nextInt();

        for(int i = 0; i < 5; i++)
        {
            cars.get(i).start();
        }

        boolean check = true;
        do
        {
            for(int i = 0; i < 5; i++)
            {
                if (!cars.get(i).isAlive())
                {
                   indexWin = i;
                   check = false;
                   for (int j = 0; j < 5; j++)
                   {
                       if  (j != i)
                       {
                           cars.get(j).interrupt();
                       }
                   }
                   break;
                }
            }
        } while(check);

        if (indexPlay == indexWin)
        {
            System.out.println("Вы выйграли!");
            System.out.println("Первая приехала машина " + cars.get(indexWin).getName());
        }
        else
        {
            System.out.println("Вы проирали.");
            System.out.println("Первая приехала машина " + cars.get(indexWin).getName());
        }

        System.out.println("Итоги заезда.");
        for(int i = 0; i < 5; i++)
        {
            System.out.println(cars.get(i).getName() + ". Значение distance = " + cars.get(i).getDistance());
        }
    }
}
