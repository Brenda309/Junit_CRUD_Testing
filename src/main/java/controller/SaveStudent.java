package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;

import module.Student;
import repository.DBConnection;

public class SaveStudent{
    Connection connection = null;

    public int connectionWithDatabase() {
        DBConnection db = new DBConnection();
        Connection con = db.getConnection();
        if (con != null)
            return 1;
        return 0;
    }
    public SaveStudent(){

    }

    public String saveStudent(Student studentObj) {
        DBConnection dbConnection = new DBConnection();
        connection = dbConnection.getConnection(); // Initialize the connection

        String insertStudentQuery = "INSERT INTO student (id, names) VALUES (?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertStudentQuery);
            preparedStatement.setInt(1,studentObj.getId());
            preparedStatement.setString(2, studentObj.getNames());
           int rowsAffected= preparedStatement.executeUpdate();
connection.close();
if(rowsAffected >= 1){
    return "student saved";
}else {
    return "student not saved";
}
            } catch (Exception e) {
                e.printStackTrace();
            }
        return "ERROR";
    }
    }


