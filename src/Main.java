import java.util.Scanner;

public class Main {
    private static boolean isExit = false;
    private static Request request;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (!isExit) {
            System.out.println("Enter request: ");
            request = new Request(scanner.nextLine());

            request.printInfo();

            if (request.isCorrect()) {
                openActionsMenu(request.getAction());
            }
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
    }

    private static void updateTask() {

    }

    private static void deleteTask() {

    }

    private static void listTask() {

    }

}