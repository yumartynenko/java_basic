package Lab.LR_5.service;

import Lab.LR_5.db.DatabaseManager;
import Lab.LR_5.model.Student;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    public void addStudent(Student student) {
        String sql = "INSERT INTO students (last_name, first_name, patronymic, birth_date, record_book_number) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseManager.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, student.getLastName());
            stmt.setString(2, student.getFirstName());
            stmt.setString(3, student.getPatronymic());
            stmt.setString(4, student.getBirthDate().toString());
            stmt.setString(5, student.getRecordBookNumber());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getStudentsByMonth(int month) {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students WHERE strftime('%m', birth_date) = ?";

        try (Connection conn = DatabaseManager.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, String.format("%02d", month));
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("id"),
                        rs.getString("last_name"),
                        rs.getString("first_name"),
                        rs.getString("patronymic"),
                        LocalDate.parse(rs.getString("birth_date")),
                        rs.getString("record_book_number")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
