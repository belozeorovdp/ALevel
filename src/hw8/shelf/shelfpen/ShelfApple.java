package hw8.shelf.shelfpen;

import hw8.position.Position;
import hw8.position.impl.Apple;
import hw8.shelf.Shelf;

public class ShelfApple implements Shelf
{
    private int count;
    private Apple[] apples;

    public ShelfApple()
    {
        apples = new Apple[100];
        count = apples.length;
    }

    public ShelfApple(int cout)
    {
        apples = new Apple[cout];
        count = apples.length;
    }

    public ShelfApple(Apple[] apples)
    {
        this.apples = apples;
        count = apples.length;
    }

    @Override
    public void put(Position position)
    {
        if(count < this.apples.length)
        {
            this.apples[count] = (Apple)position;
            count++;
        }
    }

    @Override
    public Position get()
    {
        return this.apples[--count];
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