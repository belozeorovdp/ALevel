package hw15.task2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Комментарий: задачи 2 и 3 перепутаны местами.

public class Main
{
    public static void main(String[] args)
    {
        String query = "SELECT employees.first_name, employees.last_name " +
                       "FROM employees " +
                       "WHERE employees.last_name LIKE ?;";

        System.out.println("Запрос:");
        System.out.println(query);
        System.out.println();

        List<String> lists = new ArrayList<String>();

        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "dima");
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "K%");
            ResultSet result = preparedStatement.executeQuery();

            while (result.next())
            {
                lists.add("First Name: " + result.getString("first_name") + "; " + "Last Name: " + result.getString("last_name"));
            }

            preparedStatement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        System.out.println("Ответ:");
        for (String list : lists)
        {
            System.out.println(list);
        }
    }
}
