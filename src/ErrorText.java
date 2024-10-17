public class ErrorText {

    static final String EMPTY_DESCRIPTION = ConsoleColors.YELLOW + "Description is empty or text not in the quotes." + ConsoleColors.RESET;
    static final String WRONG_ACTION_TYPE = ConsoleColors.YELLOW + "Wrong action type. Choose from: \"add\", \"update\", \"delete\", \"list\" and \"exit\"." + ConsoleColors.RESET;
    static final String WRONG_ID = ConsoleColors.YELLOW + "Wrong id type. Only digits." + ConsoleColors.RESET;
    static final String WRONG_UPDATE_REQUEST = ConsoleColors.YELLOW + "Something wrong with update request." + ConsoleColors.RESET;
    static final String STATUS_ERROR = ConsoleColors.YELLOW + "There is no such task status" + ConsoleColors.RESET;
}
