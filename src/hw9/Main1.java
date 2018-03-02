package hw9;


// 0. Создать текстовый файл в корне диска С с именем test.txt, напечатать внутри несколько строк текста.
// Скопировать код и убедиться, что он правильно работает.
// 1. Спровоцировать возникновение FileNotFoundEcxeption
// 2. Удалить throws IOException и заменить его на try/catch/finally. Закоммитить.
// 3. Отрефакторить код с использование try-with-recourses. Еще раз закоммитить.

// пояснения: закомментированный код //, /**/ - этапы выполнения работы

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Main1
{
    public static String read(String path) // throws IOException
    {
/*

        //открываем файл по пути
        StringBuilder stringBuilder = null;
        BufferedReader reader = null;
        try
        {
            reader = new BufferedReader(new FileReader(path));
            stringBuilder = new StringBuilder();

            String currentString;
            //построчно считываем файл
            while ((currentString = reader.readLine()) != null)
            {
                stringBuilder.append(currentString);
                stringBuilder.append("\n");
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Ошибка! файл не найден.");
            return null;
        }
        catch (IOException e)
        {
            System.out.println("Ошибка! Проблемы c InputOutout.");
            return null;
        }
        finally
        {
            //закрываем файл
            try
            {
                reader.close();
            }
            catch (IOException e)
            {
                System.out.println("Ошибка! Проблемы c закрытием потока метод close()");
                return null;
            }
            catch (NullPointerException e)
            {
                System.out.println("Ошибка! reader == null.");
                return null;
            }
        }

*/
        //открываем файл по пути
        StringBuilder stringBuilder = null;
        try(BufferedReader reader = new BufferedReader(new FileReader(path)))
        {
            stringBuilder = new StringBuilder();

            String currentString;
            //построчно считываем файл
            while ((currentString = reader.readLine()) != null)
            {
                stringBuilder.append(currentString);
                stringBuilder.append("\n");
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Ошибка! файл не найден.");
            return null;
        }
        catch (IOException e)
        {
             System.out.println("Ошибка! Проблемы c InputOutout.");
             return null;
        }
        //возвращаем вычитанный текст в строке
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws IOException
    {
        String str = read("c:\\Users\\User\\");
        if (str == null)
        {
            System.out.println("Файл не прочитан.");
        }
        else
        {
            System.out.println(read("c:\\Users\\User\\"));
        }

    }
}




