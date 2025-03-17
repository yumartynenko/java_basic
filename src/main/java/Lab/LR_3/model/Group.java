package Lab.LR_3.model;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private final String name;
    private final Human head;
    private final List<Student> students;

    public Group(String name, Human head) {
        this.name = name;
        this.head = head;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("✅ Student added: " + student.getFirstName() + " " + student.getLastName() + " | Total students: " + students.size());
    }

    public String getName() {
        return name;
    }

    public Human getHead() {
        return head;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Group: ").append(name).append(", Head: ").append(head.getFullName()).append(" (").append(head.getSex()).append("), Students: ").append(students.size());
        if (!students.isEmpty()) {
            sb.append("\n        ");
            for (Student student : students) {
                sb.append(student.getFullName()).append(" (").append(student.getSex()).append(")\n");
            }
        }
        return sb.toString();
    }

}
