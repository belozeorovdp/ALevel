package hw8;

import hw8.bag.ATBPacket;
import hw8.bag.Bag;
import hw8.bag.BagImpl;
import hw8.manager.ShopManager;
import hw8.person.Person;
import hw8.position.impl.Apple;
import hw8.position.impl.Pen;
import hw8.shelf.shelfpen.ShelfApple;
import hw8.shelf.shelfpen.ShelfPen;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        // общие недостатоки:
        // - main переполнен использованием общих методов, которые, возможно, можно было бы организовать в отдельный
        //   класс, например Магазин.
        // - не успел проверить что будет, если брать с полки в сумку товара больше чем в нее можно поместить, оставил
        //   как было сделано в программе до меня, возможен баг

        // 1. Заполняем полки товаром (недостаток: полки заполняются случайным образом, поэтому товар не систематизирован)
        ShelfPen shelfPen = fillShelvesPen();
        ShelfApple shelfApple = fillShelvesApple();

        Scanner scanner = new Scanner(System.in);

        // 2. Формируем покупателя (недостаток: реализован всего лишь один покупатель, можно было бы поставить в цикле)
        System.out.println("Как Вас зовут?");
        String name = scanner.nextLine();
        Person person = new Person(name);
        System.out.println("Покупатель с именем: " + name);
        System.out.println("Ваш статус " + person.getStatus());

        // 3. Выбираем сумку (недостаток: не реализована возможность взять несколько сумок)
        Bag bag;
        // Сумки отличаются только вместимостью
        System.out.println("Покупатель какую сумку выбираем?");
        System.out.println("1: ATB-пакет");
        System.out.println("2: Обычная сумка");
        System.out.println("3 и др: не выбрали");
        switch (scanner.nextInt())
        {
            case 1:
                bag = new ATBPacket();
                System.out.println("Вы выбрали ATBPacket.");
                break;
            case 2:
                bag = new BagImpl();
                System.out.println("Вы выбрали обычную сумку.");
                break;
            default:
                System.out.println("Не выбрали, возмите обычную сумку.");
                bag = new BagImpl();
        }
        person.setBag(bag);

        // 4. Бродим по магазину с суммкой, пока не подходим к кассе (недостаток: не можем вернуться за покупками,
        //    если уже подошли к кассе)
        while (true)
        {
            System.out.println("Что делаем дальше?");
            System.out.println("1: Идем за покупками.");
            System.out.println("2: Идем к кассе.");
            switch (scanner.nextInt())
            {
                case 1:
                    Pokupku(person, scanner, shelfPen, shelfApple);
                    break;
                case 2:
                    NaCassu(person);
                    break;
                default:
                    System.out.println("Выберите нормально чего Вы хотите.");
            }
        }
    }

    // метод заполнения полки товаром ручки
    private static ShelfPen fillShelvesPen()
    {
        int n = 1000;
        Pen pens[] = new Pen[n];
        int a = 0;  // Начальное значение диапазона - "от"
        int b = 3;  // Конечное значение диапазона - "до"
        int b_mr = b - a;
        for (int i = 0; i < n; i++)
        {
            int index = a + (int) (Math.random() * b_mr);
            switch (index)
            {
                case 0:
                    pens[i] = new Pen(10,"Ручка простая");
                    break;
                case 1:
                    pens[i] = new Pen(15,"Ручка сложная");
                    break;
                case 2:
                    pens[i] = new Pen(100,"Ручка Паркер");
                    break;
            }
        }
        ShelfPen shelfPen = new ShelfPen(pens);
        return shelfPen;
    }

    // метод заполнения полки товаром яблоки
    private static ShelfApple fillShelvesApple()
    {
        int n = 1000;
        Apple apples[] = new Apple[n];
        int a = 0;  // Начальное значение диапазона - "от"
        int b = 2;  // Конечное значение диапазона - "до"
        int b_mr = b - a;
        for (int i = 0; i < n; i++)
        {
            int index = a + (int) (Math.random() * b_mr);
            switch (index)
            {
                case 0:
                    apples[i] = new Apple(5, "Яблоко красное");
                    break;
                case 1:
                    apples[i] = new Apple(10, "Яблоко белый налив");
                    break;
                case 2:
            }
        }
        ShelfApple shelfApple = new ShelfApple(apples);
        return shelfApple;
    }

    // метод выбора покупателем полки с товаром
    private static void Pokupku(Person person, Scanner scanner, ShelfPen shelfPen, ShelfApple shelfApple)
    {
        boolean key = true;
        while (key)
        {
            System.out.println("Выберите чего Вы хотите.");
            System.out.println("1: Полка с ручками.");
            System.out.println("2: Полка с яблоками.");
            System.out.println("3: Выход");
            switch (scanner.nextInt())
            {
                case 1:
                    System.out.println("Хватаем с полки на угад количество ручек равное:");
                    takeFromPenShelf(scanner.nextInt(), person, shelfPen);
                    break;
                case 2:
                    System.out.println("Хватаем с полки на угад количество яблок равное:");
                    takeFromAppleShelf(scanner.nextInt(), person, shelfApple);
                    break;
                default:
                    key = false;
            }
        }
    }

    // метод взятия покупателем продукта-ручка с полки (недостаток: нет возможность выбрать конкретный товар,
    // берется все кучей, а так как заполнение полки было случайным, может попасть какой угодно товар по имени
    // и цене данной категории)
    private static void takeFromPenShelf(int amount, Person person, ShelfPen shelfPen)
    {
        Bag bag = person.getBag();
        for (int i = 0; i < amount; i++)
        {
            bag.add(shelfPen.get());
        }
        bag.sort();
        bag.discount();
        person.setBag(bag);
    }

    // метод взятия покупателем продукта-ручка с полки (недостаток: нет возможность выбрать конкретный товар,
    // берется все кучей, а так как заполнение полки было случайным, может попасть какой угодно товар по имени
    // и цене данной категории)
    private static void takeFromAppleShelf(int amount, Person person, ShelfApple shelfApple)
    {
        Bag bag = person.getBag();
        for (int i = 0; i < amount; i++)
        {
            bag.add(shelfApple.get());
        }
        bag.sort();
        bag.discount();
        person.setBag(bag);
    }

    // метод посчета суммы купленого товара
    private static void NaCassu(Person person)
    {
        ShopManager babaGala = new ShopManager();
        try
        {
            int sum = babaGala.sum(person.getBag());
            System.out.println("Почему так дорого? Кошмар.");
            if (sum > 0)
            {
                person.setStatus("PAID");
            }
            System.out.println("Имя покупателя: " + person.getName() + ", статус покупателя " + person.getStatus() + ".");
            System.exit(0);
        } catch (InterruptedException e)
        {
            System.out.println("Error! Method NaCassu(). " + e);
        }
    }
}
