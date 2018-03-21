package hw12.task1;

// Задание 1.

// 1. Создать список для хранения объектов из вашей собственной иерархии.
// 2. Попытаться заполнить список значениями из файла.
// 3. Если файл пуст - заполнить список значениями по умолчанию (5 объектов)
// 4. Записать список в файл.
// 5. Завершить программу.

// Пояснения: Классы делались давно в них не было реализованы переопределения toString, поэтому элементы вытаскивались
// через get-еры, вышло немного громозко.
// Заданию соответсвует варианты 2,3 не совсем попорядку пунктам самого задания, первый вариант озвучивался устно.


import hw12.task1.hierarchy.*;

import java.io.*;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        // 1) Сеариализация и десеариализация объектов имплементирующих Serializable
        System.out.println("Вариант 1.");
        Fridge fridge = new Fridge(1000.f, 80.f, 0, "Холодильник Samsung",-10);
        WashingMachine washingMachine = new WashingMachine(2000.f, 100.f, 0, "Cтиральная машина LG", 10);
        Iron iron = new Iron(800.f, 1.5f, 0, "Утюг LG", "Керамическая гладящая поверхность");
        PushButtonPhone pushButtonPhone = new PushButtonPhone(0.1f, 0.2f, 1200f, "Nokia N1",12);
        Smartphone smartphone = new Smartphone(30.f, 0.2f, 1200, "Смартфон Nexus 5", "Android 7.0");

        try (ObjectOutputStream objOStrm = new ObjectOutputStream(new FileOutputStream("serial_01.dat")) )
        {
            objOStrm.writeObject(fridge);
            objOStrm.writeObject(washingMachine);
            objOStrm.writeObject(iron);
            objOStrm.writeObject(pushButtonPhone);
            objOStrm.writeObject(smartphone);
        }
        catch(IOException e)
        {
            System.out.println("Exception during serialization: " + e);
        }

        Fridge fridgeDeserial = null;
        WashingMachine washingMachineDeserial = null;
        Iron ironDeserial = null;
        PushButtonPhone pushButtonPhoneDeserial = null;
        Smartphone smartphoneDeserial = null;

        try (ObjectInputStream objIStrm = new ObjectInputStream(new FileInputStream("serial_01.dat")))
        {
            fridgeDeserial = (Fridge)objIStrm.readObject();
            washingMachineDeserial = (WashingMachine)objIStrm.readObject();
            ironDeserial = (Iron)objIStrm.readObject();
            pushButtonPhoneDeserial = (PushButtonPhone)objIStrm.readObject();
            smartphoneDeserial = (Smartphone)objIStrm.readObject();
        }
        catch(Exception e)
        {
            System.out.println("Exception during deserialization: " + e);
        }

        System.out.println(fridgeDeserial.getName());
        System.out.println(fridgeDeserial.getWeight() + " Кг");
        System.out.println(fridgeDeserial.getPower_consumption() + " Вт");
        System.out.println(fridgeDeserial.getPower_consumption() + "Вт");
        if (fridgeDeserial.getElectricCurrent() == 0)
        {
            System.out.println("Ток переменный");
        }
        else
        {
            System.out.println("Ток постоянный");
        }
        System.out.println(fridgeDeserial.getTemperatureFreezer() + " C");

        System.out.println(washingMachineDeserial.getName());
        System.out.println(washingMachineDeserial.getWeight() + " Кг");
        System.out.println(washingMachineDeserial.getPower_consumption() + "Вт");
        if (washingMachineDeserial.getElectricCurrent() == 0)
        {
            System.out.println("Ток переменный");
        }
        else
        {
            System.out.println("Ток постоянный");
        }
        System.out.println(washingMachineDeserial.getWashCycle());

        System.out.println(ironDeserial.getName());
        System.out.println(ironDeserial.getWeight() + " Кг");
        System.out.println(ironDeserial.getPower_consumption() + "Вт");
        if (ironDeserial.getElectricCurrent() == 0)
        {
            System.out.println("Ток переменный");
        }
        else
        {
            System.out.println("Ток постоянный");
        }
        System.out.println(ironDeserial.getIroningSurface());

        System.out.println(pushButtonPhoneDeserial.getName());
        System.out.println(pushButtonPhoneDeserial.getWeight() + " Кг");
        System.out.println(pushButtonPhoneDeserial.getPower_consumption() + " Вт");
        System.out.println(pushButtonPhoneDeserial.getSignalTransmissionFrequency() + " МГц");
        System.out.println(pushButtonPhoneDeserial.getNumberButton());

        System.out.println(smartphoneDeserial.getName());
        System.out.println(smartphoneDeserial.getWeight() + " Кг");
        System.out.println(smartphoneDeserial.getPower_consumption() + " Вт");
        System.out.println(smartphoneDeserial.getSignalTransmissionFrequency() + " МГц");
        System.out.println(smartphoneDeserial.getOperatingSystem());

        // 2) Сеариализация и десеариализация через ArrayList
        System.out.println();
        System.out.println("Вариант 2.");
        ArrayList<Smartphone> smartphoneArrayLists = new ArrayList<Smartphone>();
        smartphoneArrayLists.add(new Smartphone(10.f, 0.1f, 1200, "Смартфон Nexus 7", "Android 8.0"));
        smartphoneArrayLists.add(new Smartphone(15.f, 0.15f, 1200, "Смартфон LG A50", "Android 4.4"));
        smartphoneArrayLists.add(new Smartphone(17.f, 0.1f, 1200, "Смартфон ASUS F9", "Android 7.1"));
        smartphoneArrayLists.add(new Smartphone(20.f, 0.2f, 1800, "Смартфон Samsung K5", "Android 7.0"));
        smartphoneArrayLists.add(new Smartphone(20.f, 0.2f, 1800, "IPhone 8", "IOS 8"));

        try (ObjectOutputStream objOStrm = new ObjectOutputStream(new FileOutputStream("serial_02.dat")) )
        {
            objOStrm.writeObject(smartphoneArrayLists);
        }
        catch(IOException e)
        {
            System.out.println("Exception during serialization: " + e);
        }

        Object smartphoneArrayListsRead = new ArrayList<Smartphone>();
        try (ObjectInputStream objIStrm = new ObjectInputStream(new FileInputStream("serial_02.dat")))
        {
            smartphoneArrayListsRead = objIStrm.readObject();

        }
        catch(Exception e)
        {
            System.out.println("Exception during deserialization: " + e);
        }
        ArrayList<Smartphone> smartphoneArrayListsDeserial =  (ArrayList<Smartphone>) smartphoneArrayListsRead;
        for (int i = 0; i < smartphoneArrayListsDeserial.size(); i++)
        {
            System.out.println(smartphoneArrayListsDeserial.get(i).getName());
            System.out.println(smartphoneArrayListsDeserial.get(i).getWeight() + " Кг");
            System.out.println(smartphoneArrayListsDeserial.get(i).getPower_consumption() + " Вт");
            System.out.println(smartphoneArrayListsDeserial.get(i).getSignalTransmissionFrequency() + " МГц");
            System.out.println(smartphoneArrayListsDeserial.get(i).getOperatingSystem());
        }

        // 3) Когда файл пустой.
        System.out.println();
        System.out.println("Вариант 3.");
        smartphoneArrayListsRead = new ArrayList<Smartphone>();
        try (ObjectInputStream objIStrm = new ObjectInputStream(new FileInputStream("serial_22.dat")))
        {
            smartphoneArrayListsRead = objIStrm.readObject();

        }
        catch(Exception e)
        {
            System.out.println("Exception during deserialization: " + e);
            for (int i = 0; i < 5; i++)
            {
                ((ArrayList<Smartphone>) smartphoneArrayListsRead).add(new Smartphone());
            }
        }

        for (int i = 0; i < ((ArrayList<Smartphone>) smartphoneArrayListsRead).size(); i++)
        {
            System.out.println(((ArrayList<Smartphone>) smartphoneArrayListsRead).get(i).getName());
            System.out.println(((ArrayList<Smartphone>) smartphoneArrayListsRead).get(i).getWeight() + " Кг");
            System.out.println(((ArrayList<Smartphone>) smartphoneArrayListsRead).get(i).getPower_consumption() + " Вт");
            System.out.println(((ArrayList<Smartphone>) smartphoneArrayListsRead).get(i).getSignalTransmissionFrequency() + " МГц");
            System.out.println(((ArrayList<Smartphone>) smartphoneArrayListsRead).get(i).getOperatingSystem());
        }
    }
}
