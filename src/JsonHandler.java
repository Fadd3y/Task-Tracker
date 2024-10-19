import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;

public class JsonHandler {

    private Path path;
    private String name = "tasks.json";

    public JsonHandler(Path path) {
        this.path = path;
    }

    public void writeTaskArchiveToFile(TaskArchive archive) {
        Path save = path.resolve(name);

        createSaveFile(save);

        Gson builder = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .setPrettyPrinting()
                .create();

        try(FileWriter writer = new FileWriter(save.toString())) {
            builder.toJson(archive, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TaskArchive readTaskArchiveFromFile() {
        Path save = path.resolve(name);

        Gson builder = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .setPrettyPrinting()
                .create();

        TaskArchive archive = null;

        if (!Files.exists(save)) return new TaskArchive();

        try (FileReader reader = new FileReader(save.toString())) {
            archive = builder.fromJson(reader, TaskArchive.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return archive;
    }

    private void createSaveFile(Path save) {
        try {
            if (Files.notExists(save.getParent())) {
                Files.createDirectories(save.getParent());
            }
            if (!Files.exists(save)) {
                Files.createFile(save);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
