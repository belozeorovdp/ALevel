package hw5a;

public class Main
{
    public static void main(String[] args)
    {
        Fridge fridge = new Fridge(1000.f, 80.f, 0, "Холодильник Samsung",-10);
        System.out.println(fridge.getName());
        fridge.working();
        fridge.working(true);
        fridge.working(false);
        System.out.println();

        WashingMachine washingMachine = new WashingMachine();
        System.out.println(washingMachine.getName());
        washingMachine.setWashCycle(1);
        washingMachine.working();
        washingMachine.setWashCycle(2);
        washingMachine.working();
        washingMachine.setWashCycle(3);
        washingMachine.working();
        washingMachine.setWashCycle(4);
        washingMachine.working();
        washingMachine.setWashCycle(0);
        washingMachine.working();
        System.out.println();

        Iron iron = new Iron(800.f, 1.5f, 0, "Утюг LG", "Керамическая гладящая поверхность");
        System.out.println(iron.getName());
        System.out.println(iron.getPower_consumption() + "Вт");
        if (iron.getElectricCurrent() == 0)
        {
            System.out.println("Ток переменный");
        }
        else
        {
            System.out.println("Ток постоянный");
        }
        System.out.println(iron.getIroningSurface());
        iron.working();
        System.out.println();

        PushButtonPhone pushButtonPhone = new PushButtonPhone();
        System.out.println(pushButtonPhone.getName());
        pushButtonPhone.call();
        System.out.println();

        Smartphone smartphone = new Smartphone(30.f, 0.2f, 1200, "Смартфон Nexus 5", "Android 7.0");
        System.out.println(smartphone.getName());
        System.out.println(smartphone.getPower_consumption() + " Вт");
        System.out.println(smartphone.getSignalTransmissionFrequency() + " МГц");
        System.out.println(smartphone.getOperatingSystem());
        smartphone.call();
        System.out.println();

    }
}
