package leson_task1;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;

import static leson_task1.FileManipulation.ReadFileLineByLine;
import static leson_task1.FileManipulation.findFiles;
import static leson_task1.ParsingFileTable.parsingString;

public class CreateTable
{
    public static void createTables(String Path, String nameBD)
    {
        String ext = ".csv";
        File[] files = findFiles(Path, ext);
        for(File fileFind:files)
        {
            ArrayList<String> arrayList = ReadFileLineByLine(fileFind);
            createTable(nameBD, fileFind, parsingString(arrayList.get(0))) ;
            insertTable(nameBD, fileFind, arrayList);
        }
    }

    public static void createTable(String nameBD, File file, String[] arrayString)
    {
        nameBD = FileManipulation.getLastNamePathDirectoryOrFile(nameBD);
        String nameTable = FileManipulation.getLastNamePathDirectoryOrFile(file.toString());
        nameTable = nameTable.substring(0, nameTable.lastIndexOf('.'));

        StringBuffer line = new StringBuffer();

        for (int i = 1; i < arrayString.length; i++)
        {
            line.append(arrayString[i]).append(" VARCHAR(255), ");
        }

        String query = "CREATE TABLE " +
                nameTable +
                " "  +
                "("  + arrayString[0] + " VARCHAR(255), " + line + " PRIMARY KEY (" + arrayString[0] + "));";
        System.out.println(query);

//        String query = "CREATE TABLE REGISTRATION " +
//                "(id INTEGER not NULL, " +
//                " first VARCHAR(255), " +
//                " last VARCHAR(255), " +
//                " age INTEGER, " +
//                " PRIMARY KEY ( id ))";

        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + nameBD, "root", "dima");
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);

            statement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void insertTable(String nameBD, File file, ArrayList<String> arrayLists)
    {
        nameBD = FileManipulation.getLastNamePathDirectoryOrFile(nameBD);
        String name = FileManipulation.getLastNamePathDirectoryOrFile(file.toString());
        name = name.substring(0, name.lastIndexOf('.'));
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + nameBD, "root", "dima");
            Statement statement = connection.createStatement();
            for(int i = 1; i< arrayLists.size(); i++)
            {
                statement.executeUpdate(insertQueryString(name,parsingString(arrayLists.get(i))));
            }
            statement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    private static String insertQueryString(String nameTable, String[] arrayString)
    {
        StringBuffer line = new StringBuffer();
        for (int i = 0; i < arrayString.length; i++)
        {
            if (i <= arrayString.length - 2)
            {
                line.append("'").append(arrayString[i]).append("', ");
            }
            else if (i == arrayString.length - 1)
            {
                line.append("'").append(arrayString[i]).append("'");
            }
        }
        System.out.println("INSERT INTO " + nameTable + " VALUES(" + line + ");");
        return "INSERT INTO " +
                        nameTable     +
                        " VALUES(" + line + ");";
    }
}
