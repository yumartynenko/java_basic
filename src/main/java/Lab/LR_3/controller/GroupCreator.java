package Lab.LR_3.controller;

import Lab.LR_3.model.*;

public class GroupCreator {
    public static Group createGroup(String name, Human head) {
        return new Group(name, head);
    }
}
