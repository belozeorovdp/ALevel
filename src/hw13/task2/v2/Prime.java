package hw13.task2.v2;

import java.util.ArrayList;
import java.util.List;

public class Prime extends Thread 
{
    private long begin;
    private long end;
    private List<Long> massif = new ArrayList<Long>();
    
    Prime(long begin, long end)
    {
        this.begin = begin;
        this.end   = end;
    }
    
    @Override
    public void run()
    {
        for (long i = begin; i <= end; i++)
        {
            boolean isPrime = true;
            for (long j = 2; j < i; j++)
            {
                if (i % j == 0)
                {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime)
            {
                massif.add(i);
            }
        }
    }

    public List<Long> getMassif()
    {
        return massif;
    }
}
