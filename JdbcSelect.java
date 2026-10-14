import java.sql.*;

public class JdbcSelect {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        String sqlQuery = "SELECT * FROM users";

        try (
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery)
        ) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String email = resultSet.getString("email");
                System.out.println("User ID: " + id + ", Username: " + username + ", Email: " + email);
            }
        } catch (SQLException e) {
            System.err.println("Database error occurred!");
            e.printStackTrace();
        }
    }
}
