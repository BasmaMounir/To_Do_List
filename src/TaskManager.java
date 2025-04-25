
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskManager {
    List<Task> tasks = new ArrayList<>();

    List<Task> getCompletedTasks() {
       return tasks.stream().filter(Task::isCompleted).collect(Collectors.toList());
    }
}
