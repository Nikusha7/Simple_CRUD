package ge.nika.DAO;

import ge.nika.DataBase.Database;
import ge.nika.studentDTO.StudentDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public StudentDTO getStudent(int id) throws SQLException {
        try (Connection connection = Database.getConnection()) {
            StudentDTO student = null;

            String sql = "Select id, first_name, last_name, birth_date, email, age FROM students where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int studentId = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                Date birthDate = rs.getDate("birth_date");
                String email = rs.getString("email");
                int age = rs.getInt("age");

                student = new StudentDTO(studentId, firstName, lastName, birthDate, email, age);
            }
            return student;
        } catch (SQLException e) {
            throw new SQLException(e);
        }

    }

    @Override
    public List<StudentDTO> getAllStudents() throws SQLException {
        try (Connection connection = Database.getConnection()) {
            List<StudentDTO> students = new ArrayList<>();

            String sql = "Select * FROM students";
            Statement statement = connection.createStatement();


            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                StudentDTO student;

                int studentId = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                Date birthDate = rs.getDate("birth_date");
                String email = rs.getString("email");
                int age = rs.getInt("age");

                student = new StudentDTO(studentId, firstName, lastName, birthDate, email, age);

                students.add(student);
            }
            return students;
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public int saveStudent(StudentDTO studentDTO) throws SQLException {
        try (Connection connection = Database.getConnection()) {
            String sql = "INSERT INTO students(id, first_name, last_name, birth_date, email, age) VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, studentDTO.getId());
            ps.setString(2, studentDTO.getFirstName());
            ps.setString(3, studentDTO.getLastName());
            ps.setDate(4, studentDTO.getBirthDate());
            ps.setString(5, studentDTO.getEmail());
            ps.setInt(6, studentDTO.getAge());

            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public int updateStudent(StudentDTO studentDTO) throws SQLException {
        try (Connection connection = Database.getConnection()) {
            String sql = "UPDATE students SET first_name = ?, last_name = ?, birth_date = ?, email = ?, age = ? where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, studentDTO.getFirstName());
            ps.setString(2, studentDTO.getLastName());
            ps.setDate(3, studentDTO.getBirthDate());
            ps.setString(4, studentDTO.getEmail());
            ps.setInt(5, studentDTO.getAge());
            ps.setInt(6, studentDTO.getId());

            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public int deleteStudent(int studentId) throws SQLException {
        try (Connection connection = Database.getConnection()) {
            String sql = "DELETE From students where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, studentId);

            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
}