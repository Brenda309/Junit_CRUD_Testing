package controller;

import repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateStudent {
    Connection connection = null;

    public int connectionWithDatabase() {
        DBConnection db = new DBConnection();
        Connection con = db.getConnection();
        if (con != null)
            return 1;
        return 0;
    }
    public void updateStudentName(int studentId, String newName) {
        try (Connection connection = new DBConnection().getConnection()) {
            String updateQuery = "UPDATE students SET names = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setString(1, newName);
                preparedStatement.setInt(2, studentId);

                // Execute the update statement
                int rowsUpdated = preparedStatement.executeUpdate();

                if (rowsUpdated > 0) {
                    System.out.println("Student information updated successfully.");
                } else {
                    System.out.println("No student found with the given ID.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
