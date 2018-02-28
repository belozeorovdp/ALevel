package hw8.shelf.shelfpen;

import hw8.position.Position;
import hw8.position.impl.Pen;
import hw8.shelf.Shelf;

public class ShelfPen implements Shelf
{
    private int count;
    private Pen[] pens;

    public ShelfPen()
    {
        pens = new Pen[100];
        count = pens.length;
    }

    public ShelfPen(int cout)
    {
        pens = new Pen[cout];
        count = pens.length;
    }

    public ShelfPen (Pen [] pens) // можно заменить на Position
    {
        this.pens = pens;
        count = pens.length;
    }

    @Override
    public void put(Position position)
    {
        if(count < this.pens.length)
        {
            this.pens[count] = (Pen) position;
            count++;
        }
    }

    @Override
    public Position get()
    {
        return this.pens[--count];
    }

    @Override
    public boolean checkAvalable()
    {
        if (count != 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
