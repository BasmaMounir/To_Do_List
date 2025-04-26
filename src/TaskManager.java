

import java.util.*;
import java.util.stream.Collectors;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public List<Task> getCompletedTasks() {
        return tasks.stream().filter(Task::isCompleted).collect(Collectors.toList());
    }

    public Task updateTask(UUID id,Task task) throws CloneNotSupportedException {
       for (Task t : tasks) {
           if(t.getId().equals(id)) {
               t.setTitle(task.getTitle());
               t.setDescription(task.getDescription());
               t.setDate(task.getDate());
               t.setCompleted(task.isCompleted());

               return t;
           }
       }

        return task.clone();

    }

    public void searchTasks(String keyword, List<Task> tasks) {

        Set<String> stopWords = new HashSet<>(Set.of("on", "in", "at", "the", "is", "are", "we", "they", "i",
                "he", "she", "them", "their", "her", "his", "it", "from", "to"));

        Map<String, List<Task>> tasksByKeywords = new HashMap<>();

        for(Task task : tasks){

            Set<String> keywords = Arrays.stream(task.getDescription().toLowerCase().split(" ")).collect(Collectors.toSet());
            keywords.addAll( Arrays.stream(task.getTitle().toLowerCase().split(" ")).collect(Collectors.toSet()));

            keywords.removeAll(stopWords);

            for(String s : keywords){
                List<Task> t = tasksByKeywords.getOrDefault(s.toLowerCase(), new ArrayList<>());
                t.add(task);
                tasksByKeywords.put(s.toLowerCase(), t);
            }
        }

//        tasksByKeywords.forEach((k,v) -> {
//            System.out.println(k +": " + v);
//        });

        if(tasksByKeywords.containsKey(keyword)) System.out.println(tasksByKeywords.get(keyword));
        else System.out.println("Keyword is not found");
    }
   
}
