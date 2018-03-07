package hw10.position;

public interface Position extends Comparable<Position>
{
    public String getName();
    public double getPrice();
    public void setPrice(double price);
    @Override
    int compareTo(Position o);
}
