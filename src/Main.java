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



    }

}