package leson_task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
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

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        CreateBD createBD = new CreateBD(name);
        createBD.ParsingNameBD();
        createBD.PrintLastNameDir();
        createBD.CreateDataBase();

    }

}
