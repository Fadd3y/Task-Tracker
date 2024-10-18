public enum TaskStatus {

    TODO,
    IN_PROGRESS,
    DONE;

    public static boolean contains(String status) {
        for (TaskStatus line : values()) {
            if (line.toString().equalsIgnoreCase(status)) {
                return true;
            }
        }
        return false;
    }
}
