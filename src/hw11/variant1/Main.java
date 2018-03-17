package hw11.variant1;

//        Программно создать текстовый файл и записать в него список файлов из каталога.
//        Путь к каталогу вводит пользователь.
//        Данные о файле “имя : дата изменения”
//
//        Сделать обход вложенных папок. Отображать вложенные папки с отступами.
//        имя : дата изменения”
//           имя : дата изменения”
//           имя : дата изменения”
//        имя : дата изменения”
//        имя : дата изменения”
//        имя : дата изменения”

// Время работы:  8791

import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class Main
{
    public static void  main(String [] args)
    {
        System.out.println("Введите путь к нужному каталогу:");
        Scanner scan = new Scanner(System.in);
        String strName = scan.nextLine();
        long startTime = System.currentTimeMillis();
        writingFile(strName);
        long endTime = System.currentTimeMillis();
        System.out.println("Время работы:  " + (endTime - startTime));
    }
    private static  void writingFile(String dirFile)
    {
        String nameFile = dirFile + "text.txt";
        try
        {
            File statText = new File(nameFile);
            FileOutputStream is = new FileOutputStream(statText);
            OutputStreamWriter osw = new OutputStreamWriter(is);
            Writer w = new BufferedWriter(osw);
            File dir = new File(dirFile);
            listAll(dir, w);
            w.close();
        }
        catch (IOException e)
        {
            System.err.println("Проблемы с сохранением файла \"test.txt\" в указаном месте.");
        }
    }

    private static void listAll(File dir, Writer writer)throws IOException
    {
        listAll( dir, 0,writer);
    }

    private static void listAll(File dir, int depth, Writer writer)throws IOException
    {
        printName(dir.getName(),new Date(dir.lastModified()) , depth, writer);
        if( dir.isDirectory())
        {
            try
            {
                for (File child : dir.listFiles())
                {
                    listAll(child, depth + 1, writer);
                }
            }
            catch (NullPointerException e)
            {
                printException(writer);
            }
        }
    }

    private static void printName(String name, Date data, int depth, Writer writer) throws IOException
    {
        for (int i = 0; i < depth; i++)
        {
            writer.write("   ");
        }
        writer.write(name + " (" + data  + ")" + "\n");
    }


    private static void printException(Writer writer) throws IOException
    {
        writer.write( "Exception: NullPointerException" + "\n");
    }
}

