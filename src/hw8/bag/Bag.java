package hw8.bag;


import hw8.position.Position;

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
    public void  discount();
}
