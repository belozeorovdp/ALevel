package hw11.variant2;

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

// Время работы:  11242


import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
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
        File statText = new File(nameFile);
        try(FileChannel fileChannel = new FileOutputStream(statText,  true).getChannel())
        {
            File dir = new File(dirFile);
            listAll(dir, fileChannel);
        }
        catch (IOException e)
        {
            System.err.println("Проблемы с сохранением файла \"test.txt\" в указаном месте.");
        }
    }

    private static void listAll(File dir, FileChannel fileChannel)throws IOException
    {
        listAll( dir, 0, fileChannel);
    }

    private static void listAll(File dir, int depth, FileChannel fileChannel)throws IOException
    {
        printName(dir.getName(),new Date(dir.lastModified()), depth, fileChannel);
        if( dir.isDirectory())
        {
            try
            {
                for (File child : dir.listFiles())
                {
                    listAll(child, depth + 1, fileChannel);
                }
            }
            catch (NullPointerException e)
            {
                printException(fileChannel);
            }
        }
    }

    private static void printName(String name, Date data, int depth, FileChannel fileChannel) throws IOException
    {
        for (int i = 0; i < depth; i++)
        {
            String str = "   ";
            ByteBuffer buff = ByteBuffer.wrap(str.getBytes());
            fileChannel.write(buff);
        }
        String str = name + " (" + data  + ")" + "\n";
        ByteBuffer buff = ByteBuffer.wrap(str.getBytes());
        fileChannel.write(buff);
    }

    private static void printException(FileChannel fileChannel) throws IOException
    {
        String str = "Exception: NullPointerException" + "\n";
        ByteBuffer buff = ByteBuffer.wrap(str.getBytes());
        fileChannel.write(buff);
    }
}

