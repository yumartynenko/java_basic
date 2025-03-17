package Lab.LR_4.utils;

import Lab.LR_4.model.Human;
import Lab.LR_4.model.Student;
import com.google.gson.*;
import java.lang.reflect.Type;

public class HumanAdapter implements JsonDeserializer<Human>, JsonSerializer<Human> {

    @Override
    public JsonElement serialize(Human src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();

        if (src instanceof Student) {
            jsonObject.addProperty("type", "Student");
            jsonObject.add("firstName", context.serialize(((Student) src).getFirstName()));
            jsonObject.add("lastName", context.serialize(((Student) src).getLastName()));
            jsonObject.add("patronymic", context.serialize(((Student) src).getPatronymic()));
            jsonObject.add("sex", context.serialize(((Student) src).getSex()));
        }

        return jsonObject;
    }

    @Override
    public Human deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        String type = jsonObject.get("type").getAsString();

        if ("Student".equals(type)) {
            return context.deserialize(json, Student.class);
        }

        return null;
    }
}
