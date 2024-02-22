package controller;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class SaveStudentTestTest {
    @Test
    public void testConnectionWithDatabase() {
        SaveStudent saveStudent = new SaveStudent();
        int connectionTest = saveStudent.connectionWithDatabase();
        assertEquals(1, connectionTest);
    }

    @Test
    public void testSaveStudents() throws SQLException {
        SaveStudent saveStudents = new SaveStudent();

        // Assuming id is an integer, name is a string, and age is an integer
        int id = 5742;
        String names = "Djadimadje";
        // Replace with the appropriate age

        saveStudents.saveStudent(id, names);
    }
}