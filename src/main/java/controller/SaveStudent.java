package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
    public String UpdateStudent(Student studentObj) {
        DBConnection dbConnection = new DBConnection();
        connection = dbConnection.getConnection(); // Initialize the connection

        String updateStudentQuery = "UPDATE student SET name=? WHERE id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateStudentQuery);
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

    public String deleteStudent(Student studentObj) {
        DBConnection dbConnection = new DBConnection();
        connection = dbConnection.getConnection(); // Initialize the connection

        String deleteStudentQuery = "DELETE FROM student WHERE id=?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteStudentQuery);
            preparedStatement.setInt(1,studentObj.getId());
            int rowsAffected= preparedStatement.executeUpdate();
            connection.close();
            if(rowsAffected >= 1){
                return "student deleted";
            }else {
                return "student not found";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ERROR";
    }

    public Student retrieveStudent(Student studentObj){
        Student student = null;
        try {
            DBConnection dbConnection = new DBConnection();
            connection = dbConnection.getConnection(); // Initialize the connection
            String retrieveStudentQuery = "SELECT * FROM student WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(retrieveStudentQuery);
            preparedStatement.setInt(1,studentObj.getId());
            ResultSet rs = preparedStatement.executeQuery();
            int count = 0;
            while (rs.next()){
                count++;
                student.setId(Integer.parseInt(rs.getString(1)));
                student.setNames(rs.getString(2));
            }
            if(count == 0){
                System.out.println("not found.");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return  student;
        }

    }


