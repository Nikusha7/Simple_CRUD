package ge.nika.DAO;

import java.sql.SQLException;
import java.util.List;

// Generic Data Access Object Interface
public interface DAO<T> {
    // Retrieve a specific entity by ID
    T getStudent(int id) throws SQLException;

    // Retrieve all entities
    List<T> getAllStudents() throws SQLException;

    // Save a new entity to the database
    int saveStudent(T t) throws SQLException;

    // Update an existing entity in the database
    int updateStudent(T t) throws SQLException;

    // Delete an entity from the database
    int deleteStudent(int id) throws SQLException;
}