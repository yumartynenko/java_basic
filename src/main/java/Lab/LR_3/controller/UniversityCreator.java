package Lab.LR_3.controller;

import Lab.LR_3.model.*;

public class UniversityCreator {
    public static University createUniversity(String name, Human head) {
        return new University(name, head);
    }
}
