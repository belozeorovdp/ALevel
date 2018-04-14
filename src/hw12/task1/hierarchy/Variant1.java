package hw12.task1.hierarchy;

import java.io.*;

public class Variant1
{
    Fridge fridgeDeserial = null;
    WashingMachine washingMachineDeserial = null;
    Iron ironDeserial = null;
    PushButtonPhone pushButtonPhoneDeserial = null;
    Smartphone smartphoneDeserial = null;

    public void execution()
    {
        System.out.println("Вариант 1.");

        Fridge fridge = new Fridge(1000.f, 80.f, 0, "Холодильник Samsung",-10);
        WashingMachine washingMachine = new WashingMachine(2000.f, 100.f, 0, "Cтиральная машина LG", 10);
        Iron iron = new Iron(800.f, 1.5f, 0, "Утюг LG", "Керамическая гладящая поверхность");
        PushButtonPhone pushButtonPhone = new PushButtonPhone(0.1f, 0.2f, 1200f, "Nokia N1",12);
        Smartphone smartphone = new Smartphone(30.f, 0.2f, 1200, "Смартфон Nexus 5", "Android 7.0");

        write(fridge, washingMachine, iron, pushButtonPhone, smartphone);

        read();

        printData();
    }

    private void write(Fridge fridge, WashingMachine washingMachine, Iron iron, PushButtonPhone pushButtonPhone, Smartphone smartphone)
    {
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
    }

    private void read()
    {
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
    }

    private void printData()
    {
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
    }
}
