package hw12.task1.hierarchy;

import java.io.Serializable;

public class Iron extends HouseholdAppliances implements Serializable
{
    private String name;
    private String ironingSurface;

    public Iron()
    {
        super();
        name = "Простой утюг";
        ironingSurface = "Стальная гладящая поверхность";
    }
    public Iron(float power_consumption, float weight, int electricCurrent, String name, String ironingSurface)
    {
        super(power_consumption, weight, electricCurrent);
        this.name = name ;
        this.ironingSurface = ironingSurface;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setIroningSurface(String ironingSurface)
    {
        this.ironingSurface = ironingSurface;
    }

    public String getName()
    {
        return name;
    }

    public String getIroningSurface()
    {
        return ironingSurface;
    }

    @Override
    public void working()
    {
        super.working();
        System.out.println("Пшии....");
    }
}
