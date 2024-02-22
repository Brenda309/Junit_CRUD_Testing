package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import repository.DBConnection;

public class SaveStudent {
    Connection connection = null;

    public int connectionWithDatabase() {
        DBConnection db = new DBConnection();
        Connection con = db.getConnection();
        if (con != null)
            return 1;
        return 0;
    }

    public void saveStudent(int id, String names) {
        DBConnection dbConnection = new DBConnection();
        connection = dbConnection.getConnection(); // Initialize the connection

        String insertStudentQuery = "INSERT INTO student (id, names) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertStudentQuery)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, names);
            // Execute the insert statement
            preparedStatement.executeUpdate();

            System.out.println("Student information inserted successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the connection in the finally block to ensure it is always closed
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
