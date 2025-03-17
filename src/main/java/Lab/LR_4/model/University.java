package Lab.LR_4.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        for (Faculty faculty : faculties) {
            sb.append("\n    ").append(faculty.toString());
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(head, that.head) &&
                Objects.equals(faculties, that.faculties);
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, head, faculties);
    }
}
