package view;

import controller.SaveStudent;
import module.Student;
import java.util.Scanner;

public class StudentView {
    public static void main(String[] args) {
        boolean condition = true;
        int Id;
        String name;
        Student student = new Student();
        SaveStudent dao = new SaveStudent();

        while (condition) {
            System.out.println("STUDENT MANAGEMENT SYSTEM");
            System.out.println("___________________________");
            System.out.println("1. Save student ");
            System.out.println("2. Update student ");
            System.out.println("3. Delete student ");
            System.out.println("4. Retrieve all students");
            System.out.println("5. Search student by ID");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    do {
                        System.out.print("What is the Student id Number? ");
                        Id = input.nextInt(); // Corrected typo "perseInt()" to "nextInt()"

                        if (String.valueOf(Id).length() == 5) {
                            break;
                        } else {
                            System.out.println("Please enter an ID of 5 digits only.");
                        }
                    } while (true); // Removed unnecessary while loop here

                    System.out.print("What is the Student name? ");
                    input.nextLine(); // Consume the newline character left by nextInt()
                    name = input.nextLine(); // Corrected to use nextLine() for reading names

                    student.setId(Id);
                    student.setNames(name);
                    String feedback = dao.saveStudent(student);
                    System.out.println(feedback);
                    break; // Moved break outside of the while loop
            }
        }
    }
}