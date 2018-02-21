package hw5a;
public class PushButtonPhone extends MobilePhone
{
    private String name;
    private int  numberButton;

    PushButtonPhone()
    {
        super();
        name = "Простой кнопочный телефон";
        numberButton = 9;
    }
    PushButtonPhone(float power_consumption, float weight, float signalTransmissionFrequency, String name, int numberButton)
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