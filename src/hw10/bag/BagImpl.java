package hw10.bag;

import hw10.position.Position;
import hw10.position.impl.Apple;
import hw10.position.impl.Pen;
import hw10.position.impl.PlaceZero;

import java.util.*;

public class BagImpl implements Bag
{
    private static final int SIZE = 100;
    private List<Position> positions = new ArrayList<Position>();

    private int realIndex = 0;
    private int iteratorIndex = 0;
    private int amountOfMerchandise = 0;
    private int freeMerchandise = 0;

    public int getRealIndex()
    {
        return realIndex;
    }

    // заполняем массив товара не null, а "пустым местом" с стоимостью 0, что позволяет сортировать массив
    // без ошибки
    public BagImpl()
    {
        for(int i = 0; i < SIZE; i++)
        {
            positions.add(new PlaceZero(0, " "));
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
        positions.add(position);
        realIndex++;
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
        return positions.get(iteratorIndex++);
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
        Collections.sort(positions,new Comparator<Position>()
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
       // Вариант когда сортировка производилпсь при помощи Comparable
       // Collections.sort(positions);
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
         int iterator = realIndex;
        int p1 = iterator - freeMerchandise;
        for (int i = p1; i < realIndex; i++)
        {
            String name = positions.get(i).getName();
            if (name.equals("Ручка простая"))
            {
                positions.set(i,new Pen(0, name));
            }
            else if (name.equals("Ручка сложная"))
            {
                positions.set(i,new Pen(0, name));
            }
            else if (name.equals("Ручка Паркер"))
            {
                positions.set(i,new Pen(0, name));
            }
            else if (name.equals("Яблоко красное"))
            {
                positions.set(i,new Apple(0, name));
            }
            else if (name.equals("Яблоко белый налив"))
            {
                positions.set(i,new Apple(0, name));
            }
            else
            {
                positions.set(i,new PlaceZero(0, name));
            }
        }
    }

    @Override
    public void sortName()
    {
        Collections.sort(positions);
    }

    @Override
    public List<Position> getListBag()
    {
        return positions;
    }
}
