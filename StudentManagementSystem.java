import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Student {
    private String name;
    private String course;
    private double marks;

    public Student(String name, String course, double marks) {
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public void displayStudent() {
        System.out.println("Name   : " + name);
        System.out.println("Course : " + course);
        System.out.println("Marks  : " + marks);
        System.out.println("-------------------------");
    }
}

public class StudentManagementSystem {
    private static Map<Integer, Student> studentMap = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n=== Student Management Menu ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Student by ID");
            System.out.println("3. View All Students");
            System.out.println("4. Update Student Marks");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Choose an option (1-6): ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudentById();
                    break;
                case 3:
                    viewAllStudents();
                    break;
                case 4:
                    updateStudentMarks();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter Student ID (integer): ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (studentMap.containsKey(id)) {
            System.out.println("Student ID already exists!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Course: ");
        String course = scanner.nextLine();

        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();

        Student student = new Student(name, course, marks);
        studentMap.put(id, student);

        System.out.println("Student added successfully!");
    }

    private static void viewStudentById() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();

        if (studentMap.containsKey(id)) {
            System.out.println("\n--- Student Details ---");
            studentMap.get(id).displayStudent();
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void viewAllStudents() {
        if (studentMap.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        System.out.println("\n--- All Students ---");
        for (Map.Entry<Integer, Student> entry : studentMap.entrySet()) {
            System.out.println("ID     : " + entry.getKey());
            entry.getValue().displayStudent();
        }
    }

    private static void updateStudentMarks() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();

        if (studentMap.containsKey(id)) {
            System.out.print("Enter New Marks: ");
            double newMarks = scanner.nextDouble();
            studentMap.get(id).setMarks(newMarks);
            System.out.println("Marks updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = scanner.nextInt();

        if (studentMap.remove(id) != null) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }
}
