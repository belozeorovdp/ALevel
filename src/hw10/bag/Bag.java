package hw10.bag;


import hw10.position.Position;

import java.util.List;

public interface Bag
{
    int getNotUsedSize();
    void add(Position position);
    boolean haveNext();
    Position next();
    void initIterator();
    public int getAmountOfMerchandise();
    public void setAmountOfMerchandise(int amountOfMerchandise);
    public void sort();
    public void sortName();
    public void  discount();
    public List<Position> getListBag();
    public int getRealIndex();
}
