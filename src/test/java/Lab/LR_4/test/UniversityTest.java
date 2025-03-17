package Lab.LR_4.test;

import Lab.LR_4.controller.UniversityCreator;
import Lab.LR_4.model.*;
import Lab.LR_4.utils.JsonManager;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class UniversityTest {

    private static final String TEST_FILE_PATH =
            Paths.get("D:", "SAVE", "IdeaProjects", "Java_basic", "src", "test", "resources", "test_university.json")
                    .toString();

    @Test
    public void testCreateUniversity() {
        University university = UniversityCreator.createUniversity();
        assertNotNull(university, "University should not be null.");
        assertEquals("Tech University", university.getName(), "University name should be 'Tech University'.");
        assertFalse(university.getFaculties().isEmpty(), "University should have at least one faculty.");
    }

    @Test
    public void testSaveAndLoadUniversityToJson() throws IOException {
        University university = UniversityCreator.createUniversity();

        JsonManager.writeToJsonFile(university, TEST_FILE_PATH);
        University loadedUniversity = JsonManager.readFromJsonFile(TEST_FILE_PATH);

        assertNotNull(loadedUniversity, "Loaded university should not be null.");
        assertEquals(university.getName(), loadedUniversity.getName(), "University names should match.");
        assertEquals(university.getFaculties().size(), loadedUniversity.getFaculties().size(), "Number of faculties should match.");
    }

    @Test
    public void testEqualityOfUniversities() throws IOException {
        University university1 = UniversityCreator.createUniversity();

        JsonManager.writeToJsonFile(university1, TEST_FILE_PATH);
        University university2 = JsonManager.readFromJsonFile(TEST_FILE_PATH);

        assertEquals(university1, university2, "The universities should be equal.");
    }

    @Test
    public void testUniversityNotEqual() {
        University university1 = UniversityCreator.createUniversity();
        University university2 = new University("Different University",
                new Student("John", "Doe", "Ivanovych", Sex.MALE, "STU-005"));

        assertNotEquals(university1, university2, "The universities should not be equal.");
    }
}
