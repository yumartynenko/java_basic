package Lab.LR_4.utils;

import Lab.LR_4.model.Human;
import Lab.LR_4.model.University;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class JsonManager {

    private static final String DEFAULT_FILE_PATH =
            Paths.get("D:", "SAVE", "IdeaProjects", "Java_basic", "src", "test", "resources", "university.json")
                    .toString();

    public static void writeToJsonFile(University university, String fileName) throws IOException {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Human.class, new HumanAdapter())
                .create();
        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(university, writer);
        }
    }

    public static University readFromJsonFile(String fileName) throws IOException {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Human.class, new HumanAdapter())
                .create();
        try (FileReader reader = new FileReader(fileName)) {
            return gson.fromJson(reader, University.class);
        }
    }

    // Метод для запису за замовчуванням
    public static void saveDefault(University university) throws IOException {
        writeToJsonFile(university, DEFAULT_FILE_PATH);
    }

    // Метод для читання за замовчуванням
    public static University loadDefault() throws IOException {
        return readFromJsonFile(DEFAULT_FILE_PATH);
    }
}
