package leson_task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateBD
{
    private String stringNamePath     = null;
    private String stringNameBD       = null;
    private String [] stringNamesPath = null;

    public CreateBD(String stringNamePath)
    {
        this.stringNamePath = stringNamePath;
    }

    public String[] ParsingNameBD()
    {
        String[] subStr;
        String delimeter = "\\\\";
        if (this.stringNamePath != null)
        {
            subStr = stringNamePath.split(delimeter);
            // проверка
            for(int i = 0; i < subStr.length; i++)
            {
                System.out.println(subStr[i]);
            }
            stringNameBD = stringNamesPath[stringNamesPath.length - 1];
            stringNamesPath = subStr;

            return subStr;
        }
        return null;
    }

    public void PrintLastNameDir()
    {
        if (stringNamesPath != null)
        {
            System.out.println(stringNamesPath[stringNamesPath.length - 1]);
        }
        else
        {
            System.out.println("stringNamesPath == null");
        }
    }

    public void CreateDataBase()
    {
        if (stringNamePath != null && stringNamesPath != null)
        {
            Connection connection = null;
            try
            {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "dima");
                Statement stmt = null;
                stmt = connection.createStatement();
                int Result = stmt.executeUpdate("CREATE DATABASE " + stringNamesPath[stringNamesPath.length - 1]);

                stmt.close();
                connection.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            System.out.println("stringNamesPath == null || stringNamesPath == null");
        }
    }

    public String getStringNameBD()
    {
        return stringNameBD;
    }
}
