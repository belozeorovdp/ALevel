package hw5a;

public class Fridge extends HouseholdAppliances
{
    private String name;
    private float temperatureFreezer;

    Fridge()
    {
        super();
        name = "Простой холодильник";
        temperatureFreezer = 0;
    }

    Fridge(float power_consumption, float weight, int electricCurrent, String name, float temperatureFreezer)
    {
        super(power_consumption, weight, electricCurrent);
        this.name = name;
        this.temperatureFreezer = temperatureFreezer;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setTemperatureFreezer(float temperatureFreezer)
    {
        this.temperatureFreezer = temperatureFreezer;
    }

    public float getTemperatureFreezer()
    {
        return temperatureFreezer;
    }

    @Override
    public void working()
    {
        System.out.println("Уу.. Уу.. Уу.. Уу..");
    }

    public void working(boolean openDoor)
    {
        if (openDoor == true)
        {
            System.out.println("Уу.. сигнал \" Тепло уходит \" Уу.. \" Тепло уходит \" Уу.. \" Тепло уходит \" Уу.. \" Тепло уходит \"");
        }
        else
        {
            this.working();
        }
    }
}