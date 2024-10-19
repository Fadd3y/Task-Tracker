import java.util.Scanner;

public class Main {
    private static boolean isExit = false;
    private static Request request;
    private static TaskArchive taskArchive;

    static {
        taskArchive = TaskArchive.readFromFile();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (!isExit) {
            System.out.println("Enter request: ");
            request = new Request(scanner.nextLine());

            //request.printInfo();

            if (request.isCorrect()) {
                openActionsMenu(request.getAction());
            }

            taskArchive.saveToFile();
        }
    }

    private static void openActionsMenu(String action) {
        switch (action) {
            case "add" -> addTask();
            case "update" -> updateTask();
            case "delete" -> deleteTask();
            case "list" -> listTask();
            case "exit" -> isExit = true;
        }
    }

    private static void addTask() {
        String description = request.getDescription();
        taskArchive.addTask(description);
    }

    private static void updateTask() {
        String parameter = request.getParameter();
        String description = request.getDescription();
        int id = request.getId();

        switch (parameter) {
            case "-d" -> taskArchive.updateTask(id, description);
            case "-s" -> {
                var status = request.getStatus();
                taskArchive.updateTask(id, status);
            }
        }
    }

    private static void deleteTask() {
        int id = request.getId();
        taskArchive.deleteTask(id);
    }

    private static void listTask() {
        if (request.getStatus() == null) {
            taskArchive.listTasks();
        } else {
            var status = request.getStatus();
            taskArchive.listTasks(status);
        }
    }
}