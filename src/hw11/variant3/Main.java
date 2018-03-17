package hw11.variant3;

// Так как используется не рекурсивный способ поиска, а метод .walkFileTree и SimpleFileVisitor
// отступов нет, и содержание текстового файла отличается от вариантов 1,2

// примечание: в даном варианте использывался образец найденный в интернете, большая часть
// комментарии от туда

// Время работы: 1570

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EnumSet;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        System.out.println("Введите путь к нужному каталогу:");

        Scanner scan = new Scanner(System.in);
        String strName = scan.nextLine();

        // создаем объект Path
        Path startingDir = Paths.get(strName);

        // создаем экземпляр нашего класса, реализующего FileVisit
        MyFileVisitor pf = new MyFileVisitor(strName);

        // создаем экземпляр EnumSet, необходимый нам как параметр, и указывающий,
        // что программа при  прохождении дерева файлов, следует по ссылкам
        EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);

        Integer maxDepth = Integer.MAX_VALUE; //максимальное число уровней каталога для просмотра

        long startTime = System.currentTimeMillis();
        // Запуск анализа дерева файлов. Используется один из методов класса Files
        Files.walkFileTree(startingDir, options, maxDepth, pf);
        long endTime = System.currentTimeMillis();
        System.out.println("Время работы: " + (endTime - startTime));
    }
}
