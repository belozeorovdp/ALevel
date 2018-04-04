package hw15.task3;

import hw15.task1.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        String query = "SELECT em.first_name, em.last_name, sal.salary " +
                       "FROM employees em " +
                       "INNER JOIN salaries sal ON (em.emp_no = sal.emp_no) " +
                       "WHERE sal.to_date like ?;";
        System.out.println("Запрос:");
        System.out.println(query);
        System.out.println();

        ArrayList<Employee> listsEmployee = new ArrayList<Employee>();

        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "dima");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "2000%");
            ResultSet result = preparedStatement.executeQuery();
            while (result.next())
            {
                Employee employee = new Employee();
                employee.setFirst_name(result.getString("first_name"));
                employee.setLast_name(result.getString("last_name"));
                employee.setSalary(result.getInt("salary"));
                listsEmployee.add(employee);
            }
            preparedStatement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        System.out.println("Ответ:");
        for (int i = 0; i < listsEmployee.size(); i++)
        {
            System.out.println(listsEmployee.get(i).toString());
        }
        System.out.println("listsEmployee.size():" + listsEmployee.size());
    }
}
