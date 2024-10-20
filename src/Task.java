import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {

    private static int count = 0;
    private int id;
    private String description;
    private TaskStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Task(String description) {
        this.id = ++count;
        this.description = description;
        this.status = TaskStatus.TODO;
        this.createdAt = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setDescription(String description) {
        updatedAt = LocalDateTime.now();
        this.description = description;
    }

    public void setStatus(TaskStatus status) {
        updatedAt = LocalDateTime.now();
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public String getFormattedTimeOfCreation() {
        var dtf = DateTimeFormatter.ofPattern("d MMMM yyyy");
        var dtf2 = DateTimeFormatter.ofPattern("HH:mm");
        String date = dtf.format(createdAt);
        String time = dtf2.format(createdAt);
        return date + " at " + time;
    }

    public String getFormattedTimeOfUpdate() {
        if (updatedAt == null) {
            return "not updated";
        }
        var dtf = DateTimeFormatter.ofPattern("d MMMM yyyy");
        var dtf2 = DateTimeFormatter.ofPattern("HH:mm");
        String date = dtf.format(updatedAt);
        String time = dtf2.format(updatedAt);
        return date + " at " + time;
    }
}
