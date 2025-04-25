import java.time.LocalDate;
import java.util.UUID;

public class Task {
    private final UUID id;
    private String title;
    private String description;
    private LocalDate date;
    private boolean isCompleted;

    public Task(String title, String description, LocalDate date) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.date = date;
        this.isCompleted =false;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
