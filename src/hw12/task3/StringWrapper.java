package hw12.task3;

import java.io.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *   Этот класс предоставляет построчную итерацию по текстовому файлу.
 *   Метод итератора remove() генерирует UnsupportedOperatorException.
 */

public class StringWrapper implements Iterable<String>
{
    private FileInputStream stream;
    private BufferedReader reader;

    public StringWrapper(String fileName) throws FileNotFoundException
    {
        stream = new FileInputStream(fileName);
    }

    // Это единственный переопределенный метод интерфейса Iterable
    @Override
    public Iterator<String> iterator()
    {
        reader = new BufferedReader(new InputStreamReader(stream));
        return new Iterator<String>() // Этот анонимный класс является реализацией итератора
        {
            private String line;
            boolean calledHasNext = false;

            // hasNext() - Возвращает буелове значение в зависимости от того, есть ли еще элементы в коллекции.
            @Override
            public boolean hasNext() {
                if (!calledHasNext) {
                    try {
                        line = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    calledHasNext = true;
                }

                return (line != null);
            }

            // next() - Возвращает следующий элемент в коллекции. В соответствии с API метод должен бросать
            // NoSuchElementException, если все элементы уже пройдены.
            @Override
            public String next()
            {
                if (!hasNext())
                {
                    throw new NoSuchElementException();
                }

                calledHasNext = false;
                return line;
            }

            // remove() - Удаляет элемент, который был возвращен последним вызовом next.
            // Файл только для чтения, не разрешаем удаление строк.
            @Override
            public void remove()
            {
                throw new UnsupportedOperationException();
            }
        };
    }
}