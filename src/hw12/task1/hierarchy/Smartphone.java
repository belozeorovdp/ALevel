package hw12.task1.hierarchy;

import java.io.Serializable;

public class Smartphone extends MobilePhone implements Serializable
{
    private String name;
    private String operatingSystem;

    public Smartphone()
    {
        super();
        name = "Смартфон китайский";
        operatingSystem = "DOS 5.01";
    }

    public Smartphone(float power_consumption, float weight, float signalTransmissionFrequency, String name, String operatingSystem)
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
