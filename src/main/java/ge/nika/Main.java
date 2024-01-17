package ge.nika;

import ge.nika.DAO.StudentDAO;
import ge.nika.DAO.StudentDAOImpl;
import ge.nika.studentDTO.StudentDTO;

import java.sql.Date;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        StudentDAO studentDAO = new StudentDAOImpl();
        try {

            StudentDTO student = studentDAO.getStudent(1);
            System.out.println("Get Student with id: " + student);

            StudentDTO newStudent = new StudentDTO(5, "Reacher", "Toddler", new Date(System.currentTimeMillis()), "Reacher@gmail.com", 36);
            if (studentDAO.saveStudent(newStudent) == 1) {
                System.out.println("Successfully added new student");
            } else {
                System.out.println("Failed adding new student");
            }

            System.out.println("All Students: " + studentDAO.getAllStudents() + "\n");

            StudentDTO updateStudent = new StudentDTO(1, "Michael", "Jackson", new Date(System.currentTimeMillis()), "Michael@gmail.com", 40);
            if (studentDAO.updateStudent(updateStudent) == 1) {
                System.out.println("Updated Student with id 1: " + studentDAO.getAllStudents() + "\n");
            } else {
                System.out.println("Update failed");
            }

            if (studentDAO.deleteStudent(2) == 1) {
                System.out.println("Deleted Student with id 2: " + studentDAO.getAllStudents());
            } else {
                System.out.println("Delete operation failed");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}