package controller;

import module.Student;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import repository.DBConnection;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

class SaveStudentTestTest {

    // Initialize the connection
public static SaveStudent dao;

    @BeforeAll
public static void setUpBefore() throws SQLException {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();
        connection.setAutoCommit(false);
        dao = new SaveStudent();
    }
    @AfterAll
    public static void afterSetup() throws SQLException{
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();
        connection.setAutoCommit(true);
    }
    @Test
    public void testConnectionWithDatabase() {
        SaveStudent saveStudent = new SaveStudent();
        int connectionTest = saveStudent.connectionWithDatabase();
        assertEquals(1, connectionTest);
    }

    @Test
    public void testSaveStudents() throws SQLException {
        Student student = new Student();
        student.setId(24311);
        student.setNames("Brenda");
      dao.saveStudent(student);
    }
}