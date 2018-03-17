package hw11.variant3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.FileVisitResult.CONTINUE;

// Используем класс SimpleFileVisitor, который реализовывает методы интерфейса FileVisitor
public  class MyFileVisitor extends SimpleFileVisitor<Path>
{
    private FileChannel mfileChannel = null;
    MyFileVisitor(String dirFile)
    {
        String nameFile = dirFile + "text.txt";
        File statText = new File(nameFile);
        try
        {
            FileChannel fileChannel = new FileOutputStream(statText, true).getChannel();
            mfileChannel = fileChannel;
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    // Выводим информацию о обрабатываемом в данный момент файле.
    // метод Files.probeContentType выводит информацию о типе контента
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attr) throws IOException
    {
        if (attr.isSymbolicLink())
        {
            //String str = String.format("Symbolic link: %s ", file);
            String str = "Symbolic link: " + file + " " + attr.lastModifiedTime();
            ByteBuffer buff = ByteBuffer.wrap(str.getBytes());
            mfileChannel.write(buff);
            // System.out.format("Symbolic link: %s ", file);
        } else if (attr.isRegularFile())
        {
            // String str = String.format("Regular file: %s Content is %s%n ", file, Files.probeContentType(file)/*,attr.lastModifiedTime()*/);
            String str = "Regular file: " + file + " " + Files.probeContentType(file) + " " + attr.lastModifiedTime();
            ByteBuffer buff = ByteBuffer.wrap(str.getBytes());
            mfileChannel.write(buff);
            // System.out.format("Regular file: %s Content is %s%n ", file, Files.probeContentType(file));
        }
        else
        {
            // String str = String.format("Other: %s ", file);
            String str = "Other: " + file + " " + attr.lastModifiedTime();
            ByteBuffer buff = ByteBuffer.wrap(str.getBytes());
            mfileChannel.write(buff);
            System.out.format("Other: %s ", file);
        }
        String str = " (" + attr.size() + "bytes)" + "\n";
        ByteBuffer buff = ByteBuffer.wrap(str.getBytes());
        mfileChannel.write(buff);
        // System.out.println("(" + attr.size() + "bytes)");
        return CONTINUE;
    }

    //Выводим информацию о посещенном каталоге
    @Override
    /*
       Перечисление FileVisitResult имеет следующие варианты
       CONTINUE продолжить проход.
       SKIP_SIBLINGS продолжить проход без осмотра дочерних папок.
       SKIP_SUBTREE продолжить без просмотра объектов данной папки.
       TERMINATE заверщить.
    */
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException
    {
        String str = String.format("Directory: %s%n", dir);
        ByteBuffer buff = ByteBuffer.wrap(str.getBytes());
        mfileChannel.write(buff);
        // System.out.format("Directory: %s%n", dir);
        return CONTINUE;
    }

    //в случае ошибки доступа к файлу выбрасывается исключение IOException
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc)
    {
        System.err.println(exc);
        return CONTINUE;
    }
}