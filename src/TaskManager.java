

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }


    List<Task> getCompletedTasks() {
        return tasks.stream().filter(Task::isCompleted).collect(Collectors.toList());
    }

    Task updateTask(UUID id,Task task) throws CloneNotSupportedException {
       for (Task t : tasks) {
           if(t.getId().equals(id)) {
               t.setTitle(task.getTitle());
               t.setDescription(task.getDescription());
               t.setDate(task.getDate());
               t.setCompleted(task.isCompleted());

               return t;
           }
       }

       Task newTask = task.clone();
       return newTask;

    }

   
   
}
