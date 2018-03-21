package hw12.task2;

// Задание:
// 1. Сделать класс-обертку для листа Position.
// 2. Реализовать итератор так, чтобы он проходил только по товарам дешевле 5.

import hw12.task2.position.Position;
import hw12.task2.position.impl.Apple;
import hw12.task2.position.impl.Pen;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        List<Position> positions = new ArrayList<Position>();
        positions.add((Position) new Apple(2, "Яблоко красное"));
        positions.add((Position) new Apple(10, "Яблоко белое"));
        positions.add((Position) new Apple(5, "Яблоко оранжевое"));
        positions.add((Position) new Apple(10, "Яблоко желтое"));
        positions.add((Position) new Apple(0.5, "Яблоко простое"));
        positions.add((Position) new Pen(5.5, "Ручка простая красная"));
        positions.add((Position) new Pen(4.5, "Ручка простая синия"));
        positions.add((Position) new Pen(15, "Ручка чернильная"));
        positions.add((Position) new Pen(5, "Ручка деревяная"));
        positions.add((Position) new Pen(1000, "Паркер обыкновенный"));

        Wrapper wrapper = new Wrapper(positions);

        for(Position position: wrapper)
        {
            System.out.println(position.getName() + " " + position.getPrice());
        }
    }
}
