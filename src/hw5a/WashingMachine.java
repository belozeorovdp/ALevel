package hw5a;

public class WashingMachine extends HouseholdAppliances
{
    private String name;
    private int washCycle;

    WashingMachine()
    {
        super();
        name = "Простая стиральная машина";
        washCycle = 0;
    }
    WashingMachine(float power_consumption, float weight, int electricCurrent, String name, int washCycle)
    {
        super(power_consumption, weight, electricCurrent);
        this.name = name;
        this.washCycle = washCycle;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setWashCycle(int washCycle)
    {
        this.washCycle = washCycle;
    }

    public String getName()
    {
        return name;
    }

    public int getWashCycle()
    {
        return washCycle;
    }

    @Override
    public void working()
    {
        switch (washCycle)
        {
            case 0:
                System.out.println("Молчит");
                break;
            case 1:
                System.out.println("Вжи..");
                break;
            case 2:
                System.out.println("Вжи.. Вжи..");
                break;
            case 3:
                System.out.println("Вжи.. Вжи.. Вжи..");
                break;
            case 4:
                System.out.println("Вжи.. Вжи.. Вжи.. Вжи..");
                break;
            default:
                System.out.println("Что-то не то");
        }
    }
}