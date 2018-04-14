package hw12.task1.hierarchy;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Variant3
{
    Object smartphoneArrayListsRead = new ArrayList<Smartphone>();

    public void execution()
    {
        System.out.println();
        System.out.println("Вариант 3.");

        read();

        printData();
    }

    private void read()
    {
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
    }

    private void printData()
    {
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
