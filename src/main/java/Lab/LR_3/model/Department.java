package Lab.LR_3.model;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private final String name;
    private final Human head;
    private final List<Group> groups;

    public Department(String name, Human head) {
        this.name = name;
        this.head = head;
        this.groups = new ArrayList<>();
    }

    public void addGroup(Group group) {
        groups.add(group);
        System.out.println("✅ Group added: " + group.getName() + " | Total groups: " + groups.size());
    }

    public String getName() {
        return name;
    }

    public Human getHead() {
        return head;
    }

    public List<Group> getGroups() {
        return groups;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Department: ").append(name).append(", Head: ").append(head.getFullName()).append(" (").append(head.getSex()).append("), Groups: ").append(groups.size());
        if (!groups.isEmpty()) {
            sb.append("\n      ");
            for (Group group : groups) {
                sb.append(group.toString()).append("\n");
            }
        }
        return sb.toString();
    }

}
