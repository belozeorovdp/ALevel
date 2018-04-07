package leson_task1;

import java.io.File;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        // примечание:
        // в проекте ALevel\src\leson_task1\data находятся файлы таблиц, ключей, запроса с которыми
        // работал. С ними работает, достаточно перенести эти файлы в c:\Users\Dima\Documents\TableBD\ или в
        // любой другой, но при этом следует так же изменить переменные dir, fileSql в программе.

        // Соответственно, в папке должны находиться, корректные данные
        String dir = "c:\\Users\\Dima\\Documents\\TableBD\\";

        // 1. Создание БД (пункт не обязательный)
        CreateBD createBD = new CreateBD(dir);
        createBD.ParsingNameBD();
        createBD.CreateDataBase();
        // 2. Создание и заполнение таблиц
        CreateTable.createTables(dir, dir);
        // 3. Внешие ключи
        AlterTable.queryAlter(dir, dir);
        // 4. Запросы SELECT (консоль / файл) - вывод результата в консоль
        System.out.println("Выберите запрос из файла(1) или с консоли(2)");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        switch (index)
        {
            case 1:
                // Можно и через scanner, но так не надо набивать путь и файл
                String fileSql = "c:\\Users\\Dima\\Documents\\TableBD\\query.sql";
                // примечание - в файле один запрос
                SelectQuery.sendingQuery(dir, SelectQuery.readUsingBufferedReader(new File(fileSql)));
                break;
            case 2:
                System.out.println("Введите запрос  SELECT ... в одной строке, после нажмите ENTER");
                String query = scanner.nextLine();
                SelectQuery.sendingQuery(dir, query);
                break;
            default:
                System.out.println("Вы ничего не выбрали");
        }



        // проверки в ходе работы оставил, как примечания для себя

//        Connection connection = null;
//        try {
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "dima");
//            Statement stmt = null;
//            stmt = connection.createStatement();
//            int Result = stmt.executeUpdate("CREATE DATABASE databasename2");
//        }
//        catch (SQLException e)
//        {
//            e.printStackTrace();
//        }

//        Statement stmt = null;
//        stmt = connection.createStatement();
//        int Result= stmt.executeUpdate("CREATE DATABASE databasename");

//        Scanner scanner = new Scanner(System.in);
//        String name = scanner.nextLine();

//        CreateBD createBD = new CreateBD(name);
//        createBD.ParsingNameBD();

/*
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        CreateBD createBD = new CreateBD(name);
        createBD.ParsingNameBD();
        createBD.PrintLastNameDir();
        createBD.CreateDataBase();
*/

/*
        File file = new File("d:/test/test.java");
        File parentDir = file.getParentFile(); // to get the parent dir
        String parentDirName = file.getParent(); // to get the parent dir name
*/

/*
        Path path = Paths.get("d:/test/test.java");
        Path parent = path.getParent();
*/
        //getFileName() returns file name for
        //files and dir name for directories

/*
        File file = new File("d:/test/test.java");
        //File parentDir = file.getParentFile(); // to get the parent dir
        // String parentDirName = file.getParent(); // to get the parent dir name
        Path path = Paths.get("d:/test/test.java");
        Path parent = path.getParent();

        //String parentDirName = path.getFileName().toString();

        File parentDir = file.getAbsoluteFile().getParentFile();
        String parentDirName = file.getAbsoluteFile().getParent();

        // String name = new File("/mnt/sdcard/Videos/Videoname").getName();

        // System.out.println(name);


        // 1)
        System.out.println(FileManipulation.getLastNamePathDirectoryOrFile("d:/test1/test2/"));

        //2)
        String dir = "c:\\Users\\Dima\\Downloads\\";
        // в этой папке будем искать файлы с расширением .xml
        String ext = ".txt";
        // вызываем метод поиска файлов с расширением .txt в папке dir
        File[] files = findFiles(dir, ext);
        for(File fileFind:files)
        {
            System.out.println(fileFind);
        }

        String str = files[0].toString();
        System.out.println(str);
        //3)
        File fileRead = new File("c:\\Users\\Dima\\Downloads\\File.txt");
        ArrayList <String> arrayList = ReadFileLineByLine(fileRead);
        for(String string: arrayList)
        {
            System.out.println(string);
        }
*/

//        String str = "first_table one-to-many second_table(first_id):";
//        String[] strArray = ParsingFileTxt.parsingString(str);
//        for(String string:strArray)
//        {
//            System.out.println(string);
//        }
    }
}
