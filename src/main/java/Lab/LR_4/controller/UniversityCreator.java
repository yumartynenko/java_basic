package Lab.LR_4.controller;

import Lab.LR_4.model.*;
import Lab.LR_4.utils.JsonManager;
import com.github.javafaker.Faker;

import java.io.IOException;
import java.util.Random;

public class UniversityCreator {
    private static final Faker faker = new Faker();
    private static final Random random = new Random();

    public static University createUniversity() {

        Human universityHead = createRandomStudent();

        University university = new University("Tech University", universityHead); // Фіксована назва університету

        int facultyCount = 2;
        for (int i = 0; i < facultyCount; i++) {
            Faculty faculty = new Faculty(faker.educator().course(), createRandomStudent());
            university.addFaculty(faculty);

            int departmentCount = 2;
            for (int j = 0; j < departmentCount; j++) {
                Department department = new Department(faker.educator().campus(), createRandomStudent());
                faculty.addDepartment(department);

                int groupCount = 2;
                for (int k = 0; k < groupCount; k++) {
                    Group group = new Group(faker.numerify("###-##-#"), createRandomStudent());
                    department.addGroup(group);

                    int studentCount = 2;
                    for (int m = 0; m < studentCount; m++) {
                        group.addStudent(createRandomStudent());
                    }
                }
            }
        }
        return university;
    }

    private static Student createRandomStudent() {
        return new Student(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.name().lastName() + "ович",
                random.nextBoolean() ? Sex.MALE : Sex.FEMALE,
                faker.idNumber().valid()
        );
    }

    public static void saveUniversityToJson(University university, String fileName) throws IOException {
        JsonManager.writeToJsonFile(university, fileName);
    }

    public static University loadUniversityFromJson(String fileName) throws IOException {
        return JsonManager.readFromJsonFile(fileName);
    }

    public static void main(String[] args) {
        try {
            University university = createUniversity();
            String fileName = "university.json";

            saveUniversityToJson(university, fileName);

            University loadedUniversity = loadUniversityFromJson(fileName);
            System.out.println("Loaded University: \n" + loadedUniversity);

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
