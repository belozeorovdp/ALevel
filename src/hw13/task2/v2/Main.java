package hw13.task2.v2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main
{
    public static void main(String[] args)
    {
        Prime solve1 = new Prime(1,5000);
        Prime solve2 = new Prime(5001,10000);

        ExecutorService taskExecutor = Executors.newFixedThreadPool(2);

        taskExecutor.execute(solve1);
        taskExecutor.execute(solve2);

        taskExecutor.shutdown();
        try
        {
            taskExecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        }
        catch (InterruptedException e)
        {
            System.out.println(e);
        }

        List<Long> listResult = new ArrayList<Long>(solve1.getMassif());
        listResult.addAll(solve2.getMassif());

        for(int i = 0; i < listResult.size(); i++)
        {
            System.out.println(listResult.get(i));
        }
    }
}
