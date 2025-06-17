import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {

    static class Task {
        String description;
        boolean isDone;

        Task(String description) {
            this.description = description;
            this.isDone = false;
        }

        void markDone() {
            isDone = true;
        }

        @Override
        public String toString() {
            return (isDone ? "[Done] " : "[Todo] ") + description;
        }
    }

    private ArrayList<Task> tasks = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\nToDo List Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Done");
            System.out.println("4. Remove Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addTask();
                case 2 -> viewTasks();
                case 3 -> markTaskDone();
                case 4 -> removeTask();
                case 5 -> {
                    System.out.println("Exiting. Bye!");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void addTask() {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        tasks.add(new Task(description));
        System.out.println("Task added.");
    }

    private void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to show.");
            return;
        }
        System.out.println("Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, tasks.get(i));
        }
    }

    private void markTaskDone() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to mark done.");
            return;
        }
        viewTasks();
        System.out.print("Enter task number to mark as done: ");
        int taskNum = Integer.parseInt(scanner.nextLine());
        if (taskNum < 1 || taskNum > tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }
        tasks.get(taskNum - 1).markDone();
        System.out.println("Task marked as done.");
    }

    private void removeTask() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to remove.");
            return;
        }
        viewTasks();
        System.out.print("Enter task number to remove: ");
        int taskNum = Integer.parseInt(scanner.nextLine());
        if (taskNum < 1 || taskNum > tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }
        tasks.remove(taskNum - 1);
        System.out.println("Task removed.");
    }

    public static void main(String[] args) {
        new ToDoList().start();
    }
}
