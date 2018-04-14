package hw12.task1.hierarchy;

import java.io.*;
import java.util.ArrayList;

public class Variant2
{
    ArrayList<Smartphone> smartphoneArrayLists = new ArrayList<Smartphone>();
    Object smartphoneArrayListsRead = new ArrayList<Smartphone>();
    public void execution()
    {
        System.out.println();
        System.out.println("Вариант 2.");

        add();

        read();

        write();

        printData();

    }

    private void add()
    {
        smartphoneArrayLists.add(new Smartphone(10.f, 0.1f, 1200, "Смартфон Nexus 7", "Android 8.0"));
        smartphoneArrayLists.add(new Smartphone(15.f, 0.15f, 1200, "Смартфон LG A50", "Android 4.4"));
        smartphoneArrayLists.add(new Smartphone(17.f, 0.1f, 1200, "Смартфон ASUS F9", "Android 7.1"));
        smartphoneArrayLists.add(new Smartphone(20.f, 0.2f, 1800, "Смартфон Samsung K5", "Android 7.0"));
        smartphoneArrayLists.add(new Smartphone(20.f, 0.2f, 1800, "IPhone 8", "IOS 8"));
    }

    private void write()
    {
        try (ObjectOutputStream objOStrm = new ObjectOutputStream(new FileOutputStream("serial_02.dat")) )
        {
            objOStrm.writeObject(smartphoneArrayLists);
        }
        catch(IOException e)
        {
            System.out.println("Exception during serialization: " + e);
        }
    }

    private void read()
    {
        try (ObjectInputStream objIStrm = new ObjectInputStream(new FileInputStream("serial_02.dat")))
        {
            smartphoneArrayListsRead = objIStrm.readObject();

        }
        catch(Exception e)
        {
            System.out.println("Exception during deserialization: " + e);
        }
    }

    private void printData()
    {
        ArrayList<Smartphone> smartphoneArrayListsDeserial =  (ArrayList<Smartphone>) smartphoneArrayListsRead;
        for (int i = 0; i < smartphoneArrayListsDeserial.size(); i++)
        {
            System.out.println(smartphoneArrayListsDeserial.get(i).getName());
            System.out.println(smartphoneArrayListsDeserial.get(i).getWeight() + " Кг");
            System.out.println(smartphoneArrayListsDeserial.get(i).getPower_consumption() + " Вт");
            System.out.println(smartphoneArrayListsDeserial.get(i).getSignalTransmissionFrequency() + " МГц");
            System.out.println(smartphoneArrayListsDeserial.get(i).getOperatingSystem());
        }
    }
}
