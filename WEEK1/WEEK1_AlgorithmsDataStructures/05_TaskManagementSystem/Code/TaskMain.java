import java.util.*;

public class TaskMain {
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();
        taskList.addTask(new Task(1, "Design UI", "In Progress"));
        taskList.addTask(new Task(2, "Develop Backend", "Not Started"));
        taskList.addTask(new Task(3, "Write Tests", "Not Started"));
        taskList.addTask(new Task(4, "Deploy Application", "Completed"));
        System.out.println("All tasks:");
        taskList.traverseTasks();
        System.out.println("\nSearching for task with ID 3:");
        Task task = taskList.searchTaskById(3);
        if (task != null) {
            System.out.println("Found: " + task);
        } else {
            System.out.println("Task not found.");
        }
        System.out.println("\nDeleting task with ID 2:");
        boolean isDeleted = taskList.deleteTaskById(2);
        System.out.println("Deleted: " + isDeleted);
        System.out.println("\nAll tasks after deletion:");
        taskList.traverseTasks();
    }
} 