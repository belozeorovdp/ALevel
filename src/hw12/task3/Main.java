package hw12.task3;

// 1. Реализовать класс-оболочку для просмотра текстового файла. В конструктор класса должно передаваться имя файла.
// StringWraper implements Iterable<String>{
// BufferedReader reader;
// FileReader fileReader;
// }
// 2. Реализовать возможность построчного просмотра содержимого файла циклом for.

// Пояснения: Выполнения задания было показано на лекции, оставил то что было дано для того что бы не пропало.
// Комментарии сделал используя следующие материалы.
// https://paste.ofcode.org/qmBxUqRmUdeDNPTRXwJ65j
// https://fulcrum81.gitbooks.io/trial-book/kollektsii/sozdanie_obektov,_realizuyuschih_interfeis_iterable.html
// http://www.javenue.info/post/101
// https://refactoring.guru/ru/design-patterns/iterator

import java.io.FileNotFoundException;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            StringWrapper textWrapper = new StringWrapper("text.txt");

            for (String string : textWrapper)
            {
                System.out.println(string);
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

}
