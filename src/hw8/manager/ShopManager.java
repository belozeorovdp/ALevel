package hw8.manager;

import hw8.bag.Bag;

public class ShopManager
{
    public int sum(Bag bag) throws InterruptedException
    {
        int sum = 0;
        bag.initIterator();
        while (bag.haveNext())
        {
            System.out.println("PICK!!");
            sum += bag.next().getPrice();
            Thread.sleep(100);
        }
        System.out.println("Ваша сумма составляет: " + sum);
        return sum;
    }
}
