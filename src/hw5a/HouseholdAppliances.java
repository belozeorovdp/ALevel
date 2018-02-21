package hw5a;

public class HouseholdAppliances extends Electrical
{
    private int electricCurrent;

    HouseholdAppliances()
    {
        super();
        electricCurrent = 0;
    }
    HouseholdAppliances(float power_consumption, float weight, int electricCurrent)
    {
        super(power_consumption,weight);
        this.electricCurrent = electricCurrent;
    }

    public void setElectricCurrent(int electricCurrent)
    {
        this.electricCurrent = electricCurrent;
    }

    public int getElectricCurrent()
    {
        return electricCurrent;
    }

    public void working()
    {
        System.out.println("Др.. Др.. Др.. Др..");
    }

}
