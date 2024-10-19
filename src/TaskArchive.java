import java.nio.file.Path;
import java.util.HashMap;
import java.util.function.Supplier;

public class TaskArchive {

    private HashMap<Integer, Task> tasks = new HashMap<>();
    private static final String ARCHIVE_DIRECTORY = "saves\\";

    public void addTask(String description) {
        int id = genUniqueId();
        var task = new Task(description);
        tasks.put(id, task);
    }

    public void updateTask(int id, TaskStatus status) {
        var task = tasks.get(id);
        task.setStatus(status);
    }

    public void updateTask(int id, String description) {
        var task = tasks.get(id);
        task.setDescription(description);
    }

    public void deleteTask(int id) {
        tasks.remove(id);
    }

    public void listTasks() {
        for (var task : tasks.entrySet()) {
            System.out.printf("\n%s: %s\nID: %d\nCreated: %s\nUpdated: %s\n",
                    task.getValue().getStatus(),
                    task.getValue().getDescription(),
                    task.getKey(),
                    task.getValue().getFormattedTimeOfCreation(),
                    task.getValue().getFormattedTimeOfUpdate());
        }
    }

    public void listTasks(TaskStatus status) {
        for (var task : tasks.entrySet()) {
            if (task.getValue().getStatus() != status) continue;

            System.out.printf("\n%s: %s\nID: %d\nCreated: %s\nUpdated: %s\n",
                    task.getValue().getStatus(),
                    task.getValue().getDescription(),
                    task.getKey(),
                    task.getValue().getFormattedTimeOfCreation(),
                    task.getValue().getFormattedTimeOfUpdate());
        }
    }

    public void saveToFile() {
        var jsonHandler = new JsonHandler(Path.of(ARCHIVE_DIRECTORY));
        jsonHandler.writeTaskArchiveToFile(this);
    }

    public static TaskArchive readFromFile() {
        var jsonHandler = new JsonHandler(Path.of(ARCHIVE_DIRECTORY));
        return jsonHandler.readTaskArchiveFromFile();
    }

    private int genUniqueId() {
        Supplier<Integer> randomId = () -> (int) (Math.random() * 9999);

        int num = randomId.get();
        System.out.println(tasks.containsKey(num));
        while (tasks.containsKey(num)) {
            num = randomId.get();
        }
        return num;
    }
}
