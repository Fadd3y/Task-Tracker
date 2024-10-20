public class Request {
    private final String action;
    private int id;
    private String description;
    private TaskStatus status;
    private String parameter;
    private boolean isCorrect;

    public Request(String request) {
        String[] args = request.split(" +", 2);
        action = args[0];
        switch (action) {
            case "add" -> handleAdd(request);
            case "delete" -> handleDelete(request);
            case "update" -> handleUpdate(request);
            case "exit", "help" -> isCorrect = true;
            case "list" -> handleList(request);
            default -> System.out.println(ErrorText.WRONG_ACTION_TYPE);
        }
    }

    private void handleAdd(String request) {
        String[] args = request.split(" +", 2);
        if (isValidAddRequest(args)) {
            description = args[1];
            status = TaskStatus.TODO;
            isCorrect = true;
        } else {
            System.out.println(ErrorText.EMPTY_DESCRIPTION);
            isCorrect = false;
        }
    }

    private boolean isValidAddRequest(String[] args) {
        return args.length == 2 && args[1].matches("\".+\"");
    }

    private void handleDelete(String request) {
        String[] args = request.split(" +", 2);
        if (isValidDeleteRequest(args)) {
            id = Integer.parseInt(args[1]);
            isCorrect = true;
        } else {
            System.out.println(ErrorText.WRONG_ID);
            isCorrect = false;
        }
    }

    private boolean isValidDeleteRequest(String[] args) {
        return args.length == 2 && args[1].matches("\\b\\d+\\b");
    }

    private void handleUpdate(String request) {
        String[] args = request.split(" +", 4);
        if (isValidUpdateRequest(args)) {
            id = Integer.parseInt(args[1]);
            parameter = args[2];
            switch (parameter) {
                case "-d" -> ValidDescriptionHandler(args[3]);
                case "-s" -> ValidStatusHandler(args[3]);
            }
        } else {
            System.out.println(ErrorText.WRONG_UPDATE_REQUEST);
            isCorrect = false;
        }
    }

    private boolean isValidUpdateRequest(String[] args) {
        return  args.length == 4 &&
                args[1].matches("\\b\\d+\\b") &&
                args[2].matches("-\\w");
    }

    private void ValidDescriptionHandler(String description) {
        if (isValidDescription(description)) {
            this.description = description;
            isCorrect = true;
        } else {
            System.out.println(ErrorText.EMPTY_DESCRIPTION);
            isCorrect = false;
        }
    }

    private boolean isValidDescription(String description) {
        return description.matches("\".+\"");
    }

    private void ValidStatusHandler(String status) {
        if (isValidStatus(status)) {
            this.status = TaskStatus.valueOf(status.toUpperCase());
            isCorrect = true;
        } else {
            System.out.println(ErrorText.STATUS_ERROR);
            isCorrect = false;
        }
    }

    private boolean isValidStatus(String status) {
        return TaskStatus.contains(status);
    }

    private void handleList(String request) {
        String[] args = request.trim().split(" +", 2);
        if (args.length == 1) {
            isCorrect = true;
            return;
        }
        if (isValidListRequest(args)) {
            status = TaskStatus.valueOf(args[1].toUpperCase());
            isCorrect = true;
        } else {
            System.out.println(ErrorText.STATUS_ERROR);
            isCorrect = false;
        }
    }

    private boolean isValidListRequest(String[] args) {
        return args.length == 2 && isValidStatus(args[1]);
    }

    public String getAction() {
        return action;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public String getDescription() {
        return description;
    }

    public void printInfo() {
        System.out.println("action: \t\t" + action);
        System.out.println("id: \t\t\t" + id);
        System.out.println("description: \t" + description);
        System.out.println("status: \t\t" + status);
        System.out.println("parameter: \t\t" + parameter);
        System.out.println("isCorrect: \t\t" + isCorrect);
    }

    public int getId() {
        return id;
    }

    public String getParameter() {
        return parameter;
    }

    public TaskStatus getStatus() {
        return status;
    }
}
