package hw8.bag;


import hw8.position.Position;
import hw8.position.impl.PlaceZero;

import java.util.Arrays;
import java.util.Comparator;

public class BagImpl implements Bag
{
    private static final int SIZE = 100;
    private Position[] positions =  new Position[SIZE];
    private int realIndex = 0;
    private int iteratorIndex = 0;
    private int amountOfMerchandise = 0;
    private int freeMerchandise = 0;

    // заполняем массив товара не null, а "пустым местом" с стоимостью 0, что позволяет сортировать массив
    // без ошибки
    public BagImpl()
    {
        for(int i = 0; i < positions.length; i++)
        {
            positions[i] = new PlaceZero(0, " ");
        }
    }

    @Override
    public int getNotUsedSize()
    {
        return SIZE - realIndex;
    }

    @Override
    public void add(Position position)
    {
        positions[realIndex++] = position;
        amountOfMerchandise++;
    }

    @Override
    public boolean haveNext()
    {
        return iteratorIndex < realIndex;
    }

    @Override
    public Position next()
    {
        return positions[iteratorIndex++];
    }

    @Override
    public void initIterator()
    {
        iteratorIndex = 0;
    }

    // по условию берем три товара третий бесплатный
    @Override
    public void sort()
    {
       Arrays.sort(positions,new Comparator<Position>()
       {
           @Override
           public int compare(Position o1, Position o2)
           {
               if (o1.getPrice() < o2.getPrice())
               {
                   return 1;
               }
               else if (o1.getPrice() > o2.getPrice())
               {
                   return -1;
               }
               else
               {
                   return 0;
               }
           }
       });
    }

    @Override
    public int getAmountOfMerchandise()
    {
        return amountOfMerchandise;
    }

    @Override
    public void setAmountOfMerchandise(int amountOfMerchandise)
    {
        this.amountOfMerchandise = amountOfMerchandise;
    }

    @Override
    public void  discount()
    {
        freeMerchandise = amountOfMerchandise/3;
        int n = positions.length;
        int iterator = realIndex;
        int p1 = iterator - freeMerchandise;
        for (int i = p1; i < realIndex; i++)
        {
            positions[i].setPrice(0);
        }
    }
}
