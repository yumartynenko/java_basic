package Lab.LR_3.model;

public abstract class Human {
    protected String firstName;
    protected String lastName;
    protected String patronymic;
    protected Sex sex;

    public Human(String firstName, String lastName, String patronymic, Sex sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.sex = sex;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public Sex getSex() {
        return sex;
    }

    // Метод для отримання повного імені
    public String getFullName() {
        return firstName + " " + patronymic + " " + lastName;
    }
}

