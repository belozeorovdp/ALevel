package hw15.task1;

import java.sql.*;




public class Main
{
    public static void main(String[] args)
    {
        String query1 = "SELECT count(*) FROM employees;";
        String query2 = "SELECT em.first_name, em.last_name, sal.salary " +
                        "FROM employees em " +
                        "INNER JOIN salaries sal ON (em.emp_no = sal.emp_no) " +
                        "WHERE sal.to_date like '2000%' LIMIT 100;";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "dima");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query1)
            )
        {
            int count = 0;
            while (resultSet.next())
            {
                count = resultSet.getInt(1);
            }
            System.out.println("Запрос:");
            System.out.println(query1);
            System.out.println();
            System.out.println("Ответ:");
            System.out.println(count);
            System.out.println();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "dima"); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query2))
        {
            System.out.println("Запрос:");
            System.out.println(query2);
            System.out.println();
            System.out.println("Ответ:");
            Employee employee = new Employee();
            while (resultSet.next())
            {
                employee.setFirst_name(resultSet.getString("first_name"));
                employee.setLast_name(resultSet.getString("last_name"));
                employee.setSalary(resultSet.getInt("salary"));
                System.out.println(employee.toString());
            }
            System.out.println();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }









         // connection = null;
//        try {
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "dima");
//            PreparedStatement preparedStatement = null;
//            preparedStatement = connection.prepareStatement
//                    (
//                            "select employees.first_name " +
//                            "from employees " +
//                            "where employees.last_name like ?;"
//                    );
//            preparedStatement.setString(1, "K%");
//            ResultSet result2 = preparedStatement.executeQuery();
//            Employee employee = new Employee();
//
//            while (result2.next()) {
//                System.out.println(result2.getString("first_name"));
//
//            }
//            preparedStatement.close();

//            connection.close();
//
//        }
//        catch (SQLException e)
//        {
//            e.printStackTrace();
//        }

//        connection = null;
//        try {
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "dima");
//            PreparedStatement preparedStatement = null;
//            preparedStatement = connection.prepareStatement
//                    (
//                            "select em.first_name, em.last_name, sal.salary " +
//                                    "from employees em " +
//                                    " inner join salaries sal on (em.emp_no=sal.emp_no)" +
//                                    " where sal.to_date like ?;"
//                    );
//            preparedStatement.setString(1, "2000%");
//            ResultSet result2 = preparedStatement.executeQuery();
//            Employee employee = new Employee();
//            while (result2.next())
//            {
//                employee.setFirst_name(result2.getString("first_name"));
//                employee.setLast_name(result2.getString("last_name"));
//                employee.setSalary(result2.getInt("salary"));
//                System.out.println(employee.toString());
//            }
//            preparedStatement.close();
//            connection.close();
//        }
//        catch (SQLException e)
//        {
//            e.printStackTrace();
//        }
    }
}
