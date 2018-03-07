package hw10.position.impl;

import hw10.position.Position;
import hw10.position.impl.abst.AbstractPosition;

public class Pen extends AbstractPosition
{
    public Pen(double price, String name)
    {
        super(price, name);
    }

    // 1 вариант сортировка по цене
    /*
    @Override
    public int compareTo(Position o)
    {
        if (this.getPrice() < o.getPrice())
        {
            return 1;
        }
        else if (this.getPrice() > o.getPrice())
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }
    */
    // 2 вариант сортировка по имени
    @Override
    public int compareTo(Position o)
    {

        String str1 = this.getName();
        String str2 = o.getName();
        return - str1.compareTo(str2);
    }


}
