import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        TaskManager taskManager = new TaskManager();

        taskManager.addTask(new Task("Database Design", "Explaining database internals", LocalDate.now()));
        taskManager.addTask(new Task("Operating Systems", "Explaining operating systems in depth", LocalDate.now()));
        taskManager.addTask(new Task("Design Patterns", "Design patterns from zero to hero", LocalDate.now()));
        taskManager.addTask(new Task("Spring Boot", "Spring Boot from scratch", LocalDate.now()));
        taskManager.addTask(new Task("Networking", "Networks scratch the surface", LocalDate.now()));

        taskManager.searchTasks("database", taskManager.getCompletedTasks());

    }
}
