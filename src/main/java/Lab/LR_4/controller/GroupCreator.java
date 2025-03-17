package Lab.LR_4.controller;

import Lab.LR_4.model.*;

public class GroupCreator {
    public static Group createGroup(String name, Human head) {
        return new Group(name, head);
    }
}
