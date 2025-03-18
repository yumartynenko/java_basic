package Lab.LR_5.model;

import java.time.LocalDate;

public class Student {
    private int id;
    private String lastName;
    private String firstName;
    private String patronymic;
    private LocalDate birthDate;
    private String recordBookNumber;

    // with student ID
    public Student(int id, String lastName, String firstName, String patronymic, LocalDate birthDate, String recordBookNumber) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.recordBookNumber = recordBookNumber;
    }

    // without ID
    public Student(String lastName, String firstName, String patronymic, LocalDate birthDate, String recordBookNumber) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.recordBookNumber = recordBookNumber;
    }

    // get
    public int getId() { return id; }
    public String getLastName() { return lastName; }
    public String getFirstName() { return firstName; }
    public String getPatronymic() { return patronymic; }
    public LocalDate getBirthDate() { return birthDate; }
    public String getRecordBookNumber() { return recordBookNumber; }

    // set
    public void setId(int id) { this.id = id; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setPatronymic(String patronymic) { this.patronymic = patronymic; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }
    public void setRecordBookNumber(String recordBookNumber) { this.recordBookNumber = recordBookNumber; }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthDate=" + birthDate +
                ", recordBookNumber='" + recordBookNumber + '\'' +
                '}';
    }
}
