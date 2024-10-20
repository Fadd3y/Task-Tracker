public class ErrorText {

    static final String EMPTY_DESCRIPTION = ConsoleColors.YELLOW + "Description is empty or text not in the quotes." + ConsoleColors.RESET;
    static final String WRONG_ACTION_TYPE = ConsoleColors.YELLOW + "Wrong action type. Type \"help\" for available commands." + ConsoleColors.RESET;
    static final String WRONG_ID = ConsoleColors.YELLOW + "Wrong id type. Only digits." + ConsoleColors.RESET;
    static final String WRONG_UPDATE_REQUEST = ConsoleColors.YELLOW + "Something wrong with update request." + ConsoleColors.RESET;
    static final String STATUS_ERROR = ConsoleColors.YELLOW + "There is no such task status." + ConsoleColors.RESET;
    static final String TASK_NOT_FOUND = ConsoleColors.YELLOW + "Task not found." + ConsoleColors.RESET;

    static final String HELP_TEXT = """
            ----------------------Available commands:----------------------
            add "description"                   -> Adding new task.
            update id -s todo/in_progress/done  -> Update task status by id.
            update id -d "new description"      -> Update task description by id.
            delete id                           -> Delete task by id
            list                                -> List all tasks.
            list todo/in_progress/done          -> List task by their status.
            exit                                -> Exit from task tracker.
            """;

}
