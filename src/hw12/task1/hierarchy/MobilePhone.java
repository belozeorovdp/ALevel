package hw12.task1.hierarchy;

import java.io.Serializable;

public class MobilePhone extends Electrical implements Serializable
{
    private float signalTransmissionFrequency;

    MobilePhone()
    {
        super();
        signalTransmissionFrequency = 800;
    }
    MobilePhone(float power_consumption, float weight, float signalTransmissionFrequency)
    {
        super(power_consumption, weight);
        this.signalTransmissionFrequency = signalTransmissionFrequency;
    }

    public void setSignalTransmissionFrequency(float signalTransmissionFrequency)
    {
        this.signalTransmissionFrequency = signalTransmissionFrequency;
    }

    public float getSignalTransmissionFrequency()
    {
        return signalTransmissionFrequency;
    }

    public void call()
    {
        System.out.println("Гудок дозвона");
    }


}
