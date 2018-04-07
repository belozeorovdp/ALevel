package leson_task1;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static leson_task1.FileManipulation.ReadFileLineByLine;
import static leson_task1.FileManipulation.findFiles;

public class AlterTable
{
    public static void queryAlter(String Path, String nameBD)
    {
        String ext = ".txt";
        File[] files = findFiles(Path, ext);

        for(File fileFind:files)
        {
            ArrayList<String> arrayList = ReadFileLineByLine(fileFind);
            for(int i = 0; i < arrayList.size(); i++)
            {
                String[] arrayString = ParsingFileTxt.parsingString(arrayList.get(i));
                alter(nameBD,stringQueryAlter(Path, fileFind, arrayString));
            }
        }
    }
    private static String stringQueryAlter(String Path, File file, String[] arrayString)
    {
        String nameTable1 = arrayString[0];
        String nameTable2 = arrayString[2];
        String nameForeignKeyTable1 = arrayString[3];
        File fileTable = new File(Path, arrayString[0] + ".csv");
        String line = null;
        try
        {
            FileReader fr = new FileReader(fileTable);
            BufferedReader reader = new BufferedReader(fr);
            line = reader.readLine();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        String[] lineNameRow = ParsingFileTable.parsingString(line);
        String nameForeignKeyTable2 = lineNameRow[0];
        System.out.println("ALTER TABLE " + nameTable2 + " ADD FOREIGN KEY (" + nameForeignKeyTable1 + ") REFERENCES " + nameTable1 + "(" + nameForeignKeyTable2 + ");");

        return "ALTER TABLE " + nameTable2 +
               " ADD FOREIGN KEY (" + nameForeignKeyTable1 +
               ") REFERENCES " + nameTable1 + "(" + nameForeignKeyTable2 + ");";
    }
    private static void alter(String nameBD, String query)
    {
        nameBD = FileManipulation.getLastNamePathDirectoryOrFile(nameBD);
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + nameBD, "root", "dima");
            Statement statement = connection.createStatement();
            statement.executeUpdate("SET foreign_key_checks = 0;");
            statement.executeUpdate(query);
            statement.executeUpdate("SET foreign_key_checks = 1;");
            statement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
