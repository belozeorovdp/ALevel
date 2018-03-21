package hw12.task2;

import hw12.task2.position.Position;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Wrapper implements Iterable<Position>
{
    private List<Position> positionsList = new ArrayList<Position>();
    private List<Position> positionsListSelection = new ArrayList<Position>();
    private int currentSize;

    public Wrapper(List<Position> positionsList)
    {
        this.positionsList = positionsList;
        for (int i = 0; i < positionsList.size(); i++)
        {
            if (positionsList.get(i).getPrice() <= 5.0)
            {
                positionsListSelection.add(positionsList.get(i));
            }
        }
        currentSize = positionsListSelection.size();
    }

    @Override
    public Iterator<Position> iterator()
    {
        return new Iterator<Position>(){
            private int currentIndex = 0;
            @Override
            public boolean hasNext()
            {
                return currentIndex < currentSize && positionsListSelection.get(currentIndex) != null;
            }

            @Override
            public Position next()
            {
                if (!hasNext())
                {
                    throw new NoSuchElementException();
                }
                return positionsListSelection.get(currentIndex++);
            }

            @Override
            public void remove()
            {
                throw new UnsupportedOperationException();
            }
        };
    }
}
