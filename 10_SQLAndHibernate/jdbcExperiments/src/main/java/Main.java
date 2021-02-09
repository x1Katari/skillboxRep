import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/skillbox?useUnicode=true&serverTimezone=UTC";
        String user = "root";
        String pass = "testtest";

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             Statement statement = connection.createStatement())
        {
            ResultSet resultSet = statement.executeQuery("SELECT course_name AS name, COUNT(*) / (MAX(MONTH(subscription_date)) - MIN(MONTH(subscription_date)) + 1) AS avg_subs FROM Purchaselist WHERE YEAR(subscription_date) = 2018 GROUP BY course_name;");
            while (resultSet.next()) {
                String coureName = resultSet.getString("name");
                String avgSubs = resultSet.getString("avg_subs");
                System.out.println(coureName + "-------" + avgSubs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
