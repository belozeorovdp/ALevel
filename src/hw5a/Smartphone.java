package hw5a;
public class Smartphone extends MobilePhone
{
    private String name;
    private String operatingSystem;

    Smartphone()
    {
        super();
        name = "Смартфон китайский";
        operatingSystem = "DOS 5.01";
    }

    Smartphone(float power_consumption, float weight, float signalTransmissionFrequency, String name, String operatingSystem)
    {
        super(power_consumption, weight, signalTransmissionFrequency);
        this.name = name;
        this.operatingSystem = operatingSystem;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setOperatingSystem(String operatingSystem)
    {
        this.operatingSystem = operatingSystem;
    }

    public String getName()
    {
        return name;
    }



    public String getOperatingSystem()
    {
        return operatingSystem;
    }
}
