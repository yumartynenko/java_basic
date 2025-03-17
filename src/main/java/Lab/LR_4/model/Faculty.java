package Lab.LR_4.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Faculty {
    private final String name;
    private final Human head;
    private final List<Department> departments;

    public Faculty(String name, Human head) {
        this.name = name;
        this.head = head;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public String getName() {
        return name;
    }

    public Human getHead() {
        return head;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Faculty: ").append(name).append(", Head: ").append(head.getFullName()).append(" (").append(head.getSex()).append("), Departments: ").append(departments.size());
        for (Department department : departments) {
            sb.append("\n      ").append(department.toString());
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(name, faculty.name) && Objects.equals(head, faculty.head) && Objects.equals(departments, faculty.departments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, head, departments);
    }
}
