package Lab.LR_3.controller;

import Lab.LR_3.model.*;

public class DepartmentCreator {
    public static Department createDepartment(String name, Human head) {
        return new Department(name, head);
    }
}
