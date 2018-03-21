package hw12.task1.hierarchy;

import java.io.Serializable;

public class PushButtonPhone extends MobilePhone implements Serializable
{
    private String name;
    private int  numberButton;

    public PushButtonPhone()
    {
        super();
        name = "Простой кнопочный телефон";
        numberButton = 9;
    }
    public PushButtonPhone(float power_consumption, float weight, float signalTransmissionFrequency, String name, int numberButton)
    {
        super(power_consumption, weight, signalTransmissionFrequency);
        this.name = name;
        this.numberButton = numberButton;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setNumberButton(int numberButton)
    {
        this.numberButton = numberButton;
    }

    public String getName()
    {
        return name;
    }

    public int getNumberButton()
    {
        return numberButton;
    }
}