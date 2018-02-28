package hw8.shelf;

import hw8.position.Position;

public interface Shelf
{
    public void put(Position position);
    public Position get();
    // public void get(Position position, int count);
    public boolean checkAvalable();

}
