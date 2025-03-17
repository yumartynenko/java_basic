package Lab.LR_4.controller;

import Lab.LR_4.model.*;
import Lab.LR_4.utils.JsonManager;
import com.github.javafaker.Faker;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Random;

public class Run {
    private static final String FILE_PATH = Paths.get(
            "D:", "SAVE", "IdeaProjects", "Java_basic", "src", "test", "resources", "university.json").toString();

    public static void main(String[] args) throws IOException {
        Faker faker = new Faker();
        Random random = new Random();

        System.out.println("=== Creating University ===");

        Human universityHead = createRandomStudent(faker, random);
        University university = new University("Tech University", universityHead);
        System.out.println("Created University: " + university);

        Faculty faculty1 = new Faculty("Faculty of Information Technology", createRandomStudent(faker, random));
        Faculty faculty2 = new Faculty("Faculty of Engineering", createRandomStudent(faker, random));
        university.addFaculty(faculty1);
        university.addFaculty(faculty2);

        Department department1 = new Department("Software Engineering", createRandomStudent(faker, random));
        Department department2 = new Department("Cybersecurity", createRandomStudent(faker, random));
        faculty1.addDepartment(department1);
        faculty1.addDepartment(department2);

        Department department3 = new Department("Electrical Engineering", createRandomStudent(faker, random));
        Department department4 = new Department("Mechanical Engineering", createRandomStudent(faker, random));
        faculty2.addDepartment(department3);
        faculty2.addDepartment(department4);

        Group group1 = new Group("122-21-2", createRandomStudent(faker, random));
        Group group2 = new Group("122-22-1", createRandomStudent(faker, random));
        department1.addGroup(group1);
        department1.addGroup(group2);

        Group group3 = new Group("121-21-1", createRandomStudent(faker, random));
        Group group4 = new Group("121-22-1", createRandomStudent(faker, random));
        department2.addGroup(group3);
        department2.addGroup(group4);

        for (Group group : new Group[]{group1, group2, group3, group4}) {
            group.addStudent(createRandomStudent(faker, random));
            group.addStudent(createRandomStudent(faker, random));
        }

        System.out.println("\n=== Saving University to JSON ===");
        JsonManager.writeToJsonFile(university, FILE_PATH);

        System.out.println("\n=== Reading University from JSON ===");
        University newUniversity = JsonManager.readFromJsonFile(FILE_PATH);

        System.out.println("Loaded University: " + newUniversity);

        if (university.equals(newUniversity)) {
            System.out.println("The universities are equal.");
        } else {
            System.out.println("The universities are not equal.");
        }
    }

    private static Student createRandomStudent(Faker faker, Random random) {
        return new Student(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.name().firstName(), // По батькові (імітуємо)
                random.nextBoolean() ? Sex.MALE : Sex.FEMALE,
                "STU-" + (100 + random.nextInt(900))
        );
    }
}
