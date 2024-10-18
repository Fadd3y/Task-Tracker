import java.util.HashMap;

public class TaskArchive {

    private static int idCount = 0;
    private static HashMap<Integer, Task> tasks = new HashMap<>();

    public static void addTask(String description) {
        int id = ++idCount;
        var task = new Task(description);
        tasks.put(id, task);
    }

    public static void updateTask(int id, TaskStatus status) {
        var task = tasks.get(id);
        task.setStatus(status);
    }

    public static void updateTask(int id, String description) {
        var task = tasks.get(id);
        task.setDescription(description);
    }

    public static void deleteTask(int id) {
        tasks.remove(id);
    }

    public static void listTasks() {
        for (var task : tasks.entrySet()) {
            System.out.printf("\n%s: %s\nID: %d\nCreated: %s\nUpdated: %s\n",
                    task.getValue().getStatus(),
                    task.getValue().getDescription(),
                    task.getKey(),
                    task.getValue().getTimeOfCreation(),
                    task.getValue().getTimeOfUpdate());
        }
    }

    public static void listTasks(TaskStatus status) {
        for (var task : tasks.entrySet()) {
            if (task.getValue().getStatus() != status) continue;

            System.out.printf("\n%s: %s\nID: %d\nCreated: %s\nUpdated: %s\n",
                    task.getValue().getStatus(),
                    task.getValue().getDescription(),
                    task.getKey(),
                    task.getValue().getTimeOfCreation(),
                    task.getValue().getTimeOfUpdate());
        }
    }
}
