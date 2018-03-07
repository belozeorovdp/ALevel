package hw10.shelf;

import hw10.position.Position;

public interface Shelf
{
    public void put(Position position);
    public Position get();
    public boolean checkAvalable();
}
