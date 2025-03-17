package Lab.LR_3.model;

import java.util.ArrayList;
import java.util.List;

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
        System.out.println("✅ Department added: " + department.getName() + " | Total departments: " + departments.size());
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
        if (!departments.isEmpty()) {
            sb.append("\n    ");
            for (Department department : departments) {
                sb.append(department.toString()).append("\n");
            }
        }
        return sb.toString();
    }

}
