package Lab.LR_4.controller;

import Lab.LR_4.model.*;

public class FacultyCreator {
    public static Faculty createFaculty(String name, Human head) {
        return new Faculty(name, head);
    }
}
