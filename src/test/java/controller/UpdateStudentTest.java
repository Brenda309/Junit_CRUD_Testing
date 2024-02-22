package controller;

import org.junit.jupiter.api.Test;
import repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;



public class UpdateStudentTest {
    private static final int TEST_STUDENT_ID = 1;
    private static final String TEST_NEW_NAME = "John Updated";

    private UpdateStudent updateStudent;
    @Test
    public void testUpdateStudentName() {
        // Update the name of the test student
        updateStudent.updateStudentName(TEST_STUDENT_ID, TEST_NEW_NAME);

        // Check if the update was successful
        assertTrue(isStudentNameUpdated(TEST_STUDENT_ID, TEST_NEW_NAME));
    }

    private void restoreOriginalStudentName() {
        // Restore the original name of the test student
        try (Connection connection = new DBConnection().getConnection()) {
            String restoreQuery = "UPDATE students SET names = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(restoreQuery)) {
                preparedStatement.setString(1, "John"); // Replace with the original name
                preparedStatement.setInt(2, TEST_STUDENT_ID);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean isStudentNameUpdated(int studentId, String expectedName) {
        // Check if the student's name in the database matches the expected name
        try (Connection connection = new DBConnection().getConnection()) {
            String selectQuery = "SELECT names FROM students WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                preparedStatement.setInt(1, studentId);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        String actualName = resultSet.getString("names");
                        return expectedName.equals(actualName);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
