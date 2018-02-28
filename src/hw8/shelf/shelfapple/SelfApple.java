package hw8.shelf.shelfapple;

import hw8.position.Position;
import hw8.position.impl.Apple;
import hw8.shelf.Shelf;

public class SelfApple implements Shelf
{
    private int count;
    private Apple[] apples;

    public SelfApple()
    {
        apples = new Apple[100];
    }
    public SelfApple(int count)
    {
        apples = new Apple[count];
    }

    public SelfApple(Apple[] apples)
    {
        this.apples = apples;
    }

    @Override
    public void put(Position position)
    {
        this.apples[count] = (Apple) position;
        count++;
    }

    @Override
    public Position get()
    {
        if (count == 0)
        {
            return null;
        }
        else
        {
            Position  position = this.apples[count--];
            this.apples[count + 1] = null;
            return position;
        }
    }

    @Override
    public boolean checkAvalable()
    {
        return false;
    }
}
