package Lab.LR_3.model;

import java.util.ArrayList;
import java.util.List;

public class University {
    private final String name;
    private final Human head;
    private final List<Faculty> faculties;

    public University(String name, Human head) {
        this.name = name;
        this.head = head;
        this.faculties = new ArrayList<>();
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
        System.out.println("✅ Faculty added: " + faculty.getName() + " | Total faculties: " + faculties.size());
    }

    public String getName() {
        return name;
    }

    public Human getHead() {
        return head;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("University: ").append(name).append(", Head: ").append(head.getFullName()).append(" (").append(head.getSex()).append("), Faculties: ").append(faculties.size());
        if (!faculties.isEmpty()) {
            sb.append("\n  ");
            for (Faculty faculty : faculties) {
                sb.append(faculty.toString()).append("\n");
            }
        }
        return sb.toString();
    }

}
