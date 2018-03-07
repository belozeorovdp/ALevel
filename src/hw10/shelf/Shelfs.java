package hw10.shelf;

import hw10.position.Position;

import java.util.List;

public class Shelfs <T> implements Shelf
{
    private List<T> array;
    private int count;
    public Shelfs(List<T>array)
    {
        this.array = array;
        count = this.array.size();
    }

    @Override
    public void put(Position position)
    {
        if(count < this.array.size())
        {
            this.array.add((T)position);
            count++;
        }
    }

    @Override
    public Position get()
    {
        int i= --count;
        return (Position)this.array.get(i);
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
