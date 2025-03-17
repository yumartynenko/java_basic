package Lab.LR_4.controller;

import Lab.LR_4.model.*;

public class StudentCreator {
    public static Student createStudent(String firstName, String lastName, String middleName, Sex sex, String studentId) {
        return new Student(firstName, lastName, middleName, sex, studentId);
    }
}
