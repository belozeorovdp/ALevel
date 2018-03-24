package hw13.task1;

// название класса выбрано произвольно по смыслу
public class Car extends Thread
{
    private int distance = 0;

    @Override
    public void run()
    {
        int fromM   = 30;
        int beforeM = 51;
        int deltaM = beforeM - fromM;
        int numberM = 0;

        int fromS   = 300;
        int beforeS = 401;
        int deltaS = beforeS - fromS;
        int numberS = 0;

        while(true)
        {
            if(!Thread.interrupted())	// Проверка прерывания
            {
                numberM = fromM + (int)(Math.random() * deltaM);
                distance += numberM;
                if (distance >= 1000)
                {
                    return;
                }
            }
            else
            {
                return;    // Завершение потока
            }
            try
            {
                numberS = fromS + (int) (Math.random() * deltaS);
                Thread.sleep(numberS);
            }
            catch(InterruptedException e)
            {
                return;	  // Завершение потока после прерывания
            }
        }
    }

    public int getDistance()
    {
        return distance;
    }
}
