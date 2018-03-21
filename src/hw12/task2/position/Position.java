package hw12.task2.position;

public interface Position extends Comparable<Position>
{
    public String getName();
    public double getPrice();
    public void setName(String name);
    public void setPrice(double price);
    @Override
    int compareTo(Position o);
}
