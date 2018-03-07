package hw10;

/*
1.	Переделать Shelf на параметризованный класс.  AppleShelf и PenShelf удалить.
2.	Переписать BagImpl с использованием ArrayList вместо массива.
3.	Сделать так, чтобы Position расширяла Comparable. В качестве натурального порядка сортировки использовать сортировку
    по имени.
4.	Юзер должен хранить совершенные заказы в Map. Ключ - время совершения заказа, значение - сам заказ (корзина).
*/

import hw10.bag.ATBPacket;
import hw10.bag.Bag;
import hw10.bag.BagImpl;
import hw10.manager.ShopManager;
import hw10.person.Person;
import hw10.position.Position;
import hw10.position.impl.Apple;
import hw10.position.impl.Pen;
import hw10.shelf.Shelfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        // 1. Заполняем полки товаром (недостаток: полки заполняются случайным образом, поэтому товар не систематизирован)
        Shelfs<Pen> shelfPen1 = fillShelvesPen();
        Shelfs<Apple> shelfApple1 = fillShelvesApple();

        Scanner scanner = new Scanner(System.in);

        // 2. Формируем покупателя (недостаток: реализован всего лишь один покупатель)
        System.out.println("Как Вас зовут?");
        String name = scanner.nextLine();
        Person person = new Person(name);
        System.out.println("Покупатель с именем: " + name);
        System.out.println("Ваш статус " + person.getStatus());

        Bag bag;

        // 3. Выбираем сумку (недостаток: не реализована возможность взять несколько сумок)
        while(true)
        {
            // Сумки отличаются только вместимостью
            System.out.println("Покупатель какую сумку выбираем?");
            System.out.println("1: ATB-пакет");
            System.out.println("2: Обычная сумка");
            System.out.println("3 и др: не выбрали");
            switch (scanner.nextInt()) {
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

            // 4. Бродим по магазину с суммкой, пока не подходим к кассе
            while (true)
            {
                boolean exiteWhile = false;
                System.out.println("Что делаем дальше?");
                System.out.println("1: Идем за покупками.");
                System.out.println("2: Идем к кассе.");
                switch (scanner.nextInt())
                {
                    case 1:
                        Pokupku(person, scanner, shelfPen1, shelfApple1);
                        break;
                    case 2:
                        NaCassu(person);
                        exiteWhile = true;
                        break;
                    default:
                        System.out.println("Выберите нормально чего Вы хотите.");
                }
                if (exiteWhile)
                {
                    break;
                }
            }

            // 5. Выход из магазина, можем вернуться обратно, беря новую сумку
            System.out.println("Вы у выхода в магазин, что делаем дальше?");
            System.out.println("1: Идем обратно.");
            System.out.println("2: Уходим из магазина");
            switch (scanner.nextInt())
            {
                case 1:
                    break;
                case 2:
                    exitOfStore(person);
                    break;
                default:
                    System.out.println("Выберите нормально чего Вы хотите.");
            }
        }
    }

    // метод заполнения полки товаром ручки
    private static Shelfs fillShelvesPen()
    {
        int n = 1000;
        List<Pen> pens = new ArrayList<Pen>(n);
        int a = 0;  // Начальное значение диапазона - "от"
        int b = 3;  // Конечное значение диапазона - "до"
        int b_mr = b - a;
        for (int i = 0; i < n; i++)
        {
            int index = a + (int) (Math.random() * b_mr);
            switch (index)
            {
                case 0:
                    pens.add(new Pen(10,"Ручка простая"));
                    break;
                case 1:
                    pens.add(new Pen(15,"Ручка сложная"));
                    break;
                case 2:
                    pens.add(new Pen(100,"Ручка Паркер"));
                    break;
            }
        }
        return new Shelfs(pens);
    }

    // метод заполнения полки товаром яблоки
    private static Shelfs fillShelvesApple()
    {
        int n = 1000;
        List<Apple> apples = new ArrayList<Apple>(n);
        int a = 0;  // Начальное значение диапазона - "от"
        int b = 2;  // Конечное значение диапазона - "до"
        int b_mr = b - a;
        for (int i = 0; i < n; i++)
        {
            int index = a + (int) (Math.random() * b_mr);
            switch (index)
            {
                case 0:
                    apples.add(new Apple(5, "Яблоко красное"));
                    break;
                case 1:
                    apples.add(new Apple(10, "Яблоко белый налив"));
                    break;
            }
        }
        return new Shelfs(apples);
    }

    // метод выбора покупателем полки с товаром
    private static void Pokupku(Person person, Scanner scanner, Shelfs<Pen> shelfPen, Shelfs<Apple> shelfApple)
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
    private static void takeFromPenShelf(int amount, Person person, Shelfs<Pen> shelfPen)
    {
        Bag bag = person.getBag();
        for (int i = 0; i < amount; i++)
        {
            bag.add(shelfPen.get());
        }
        person.setBag(bag);
    }

    // метод взятия покупателем продукта-ручка с полки (недостаток: нет возможность выбрать конкретный товар,
    // берется все кучей, а так как заполнение полки было случайным, может попасть какой угодно товар по имени
    // и цене данной категории)
    private static void takeFromAppleShelf(int amount, Person person, Shelfs<Apple> shelfApple)
    {
        Bag bag = person.getBag();
        for (int i = 0; i < amount; i++)
        {
            bag.add(shelfApple.get());
        }
        person.setBag(bag);
    }

    // метод посчета суммы купленого товара
    private static void NaCassu(Person person)
    {
        ShopManager babaGala = new ShopManager();
        try
        {
            // Учитываем скидку на товар
            Bag bag = person.getBag();
            bag.sort();
            bag.discount();
            person.setBag(bag);
            // Передаем суммку с новой ценной кассиру
            int sum = babaGala.sum(person.getBag());
            if (sum > 0)
            {
                person.setStatus("PAID");
                person.addBagToMap(person.getBag());
            }
            System.out.println("Отчет о покупателе у кассы:");
            System.out.println("Имя покупателя: " + person.getName() + ", статус покупателя " + person.getStatus() + ".");
        } catch (InterruptedException e)
        {
            System.out.println("Error! Method NaCassu(). " + e);
        }
    }

    // метод выход из магазина
    private static void exitOfStore(Person person)
    {
        System.out.println("Имя покупателя: " + person.getName() + ", статус покупателя " + person.getStatus() + ".");
        Map<String, Bag> map = person.getMap();
        int i = 0;
        for (Map.Entry<String, Bag> entry : map.entrySet())
        {
            i++;
            System.out.println("Сумка номер:" + i);
            System.out.println("Время оплаты товара:" + entry.getKey());
            Bag bag =  entry.getValue();
            bag.sortName();
            List<Position> positions = bag.getListBag();
            for(int j = 0; j < bag.getRealIndex(); j++)
            {
                System.out.println("Название товара: " + positions.get(j).getName() + ", цена: " + positions.get(j).getPrice());
            }
        }
        System.exit(0);
    }
}