package Lab.LR_3.controller;

import Lab.LR_3.model.*;

public class Run {
    public static void main(String[] args) {
        System.out.println("=== Creating University ===");

        // Створюємо об'єкт конкретного нащадка класу Human (Student)
        Human universityHead = new Student("Olena", "Zemtsova", "Olexandrivna", Sex.FEMALE);
        University university = new University("Tech University", universityHead);
        System.out.println("Created University: " + university);

        System.out.println("\n=== Creating Faculty ===");
        Human facultyHead = new Student("Oleh", "Martynenko", "Serhiyovych", Sex.MALE);
        Faculty faculty = new Faculty("Faculty of Computer Science", facultyHead);
        university.addFaculty(faculty);
        System.out.println("Added Faculty: " + faculty);

        System.out.println("\n=== Creating Department ===");
        Human departmentHead = new Student("Anna", "Koval", "Olexandrivna", Sex.FEMALE);
        Department department = new Department("Software Engineering", departmentHead);
        faculty.addDepartment(department);
        System.out.println("Added Department: " + department);

        System.out.println("\n=== Creating Group ===");
        Human groupHead = new Student("Dmytro", "Sydorenko", "Mykolaiovych", Sex.MALE);
        Group group = new Group("122-21-2", groupHead);
        department.addGroup(group);
        System.out.println("Added Group: " + group);

        System.out.println("\n=== Creating Student ===");
        Student student = new Student("Oksana", "Melnyk", "Volodymyrivna", Sex.FEMALE);
        group.addStudent(student);
        System.out.println("Added Student: " + student);

        System.out.println("\n=== Final University Structure ===");
        System.out.println(university);
    }
}
