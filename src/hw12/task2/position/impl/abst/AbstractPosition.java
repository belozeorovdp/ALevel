package hw12.task2.position.impl.abst;

import hw12.task2.position.Position;

public abstract class AbstractPosition implements Position
{
    public double price;
    public String name;

    public AbstractPosition(double price, String name)
    {
        this.price = price;
        this.name = name;
    }

    @Override
    public double getPrice()
    {
        return price;
    }

    @Override
    public void setPrice(double price)
    {
        this.price = price;
    }

    @Override
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    abstract public int compareTo(Position o);

}
