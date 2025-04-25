import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Database Design", "Explaining database internals", LocalDate.now()) );
        tasks.add(new Task("Operating Systems",
                "Explaining operating systems in depth", LocalDate.now()));
        tasks.add(new Task("Design Patterns",
                "design patterns from zero to hero", LocalDate.now()));
        tasks.add(new Task("Spring boot", "spring boot from scratch", LocalDate.now()));
        tasks.add(new Task("Networking", "networks scratch the surface", LocalDate.now()));


        searchTasks("design", tasks);

    }

    private static void searchTasks(String keyword, List<Task> tasks) {

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