package Lab.LR_3.controller;

import Lab.LR_3.model.*;

public class FacultyCreator {
    public static Faculty createFaculty(String name, Human head) {
        return new Faculty(name, head);
    }
}
