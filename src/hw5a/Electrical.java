package hw5a;

public class Electrical
{
    private float power_consumption;
    private float weight;

    Electrical()
    {
        power_consumption = 0;
        weight = 0;
    }

    Electrical(float power_consumption,float weight)
    {
        this.power_consumption = power_consumption;
        this.weight = weight;
    }

    public void setPower_consumption(float power_consumption)
    {
        this.power_consumption = power_consumption;
    }

    public void setWeight(float weight)
    {
        this.weight = weight;
    }

    public float getPower_consumption()
    {
        return power_consumption;
    }

    public float getWeight()
    {
        return weight;
    }


}
