import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        // Infinite loop to keep the application running until user exits
        do {
            System.out.println("\n=== STUDENT MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student Details");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");
            
            // Input validation for menu choice
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number between 1 and 6: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline leftover

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    searchStudentById();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    System.out.println("Exiting application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please choose a valid option.");
            }
        } while (choice != 6);
        
        scanner.close();
    }

    // 1. ADD A STUDENT
    private static void addStudent() {
        System.out.print("Enter Unique Student ID: ");
        String id = scanner.nextLine().trim();

        // Check if ID already exists to prevent duplicate entries
        if (findStudentIndex(id) != -1) {
            System.out.println("Error: A student with ID " + id + " already exists!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter Age: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter a valid integer for Age: ");
            scanner.next();
        }
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Grade: ");
        String grade = scanner.nextLine().trim();

        // Create new object and append it to the ArrayList
        Student newStudent = new Student(id, name, age, grade);
        studentList.add(newStudent);
        System.out.println("Student added successfully!");
    }

    // 2. VIEW ALL STUDENTS
    private static void viewAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }
        System.out.println("\n----------------------- STUDENT RECORDS -----------------------");
        for (Student student : studentList) {
            student.displayStudent();
        }
        System.out.println("----------------------------------------------------------------");
    }

    // 3. SEARCH BY ID
    private static void searchStudentById() {
        System.out.print("Enter Student ID to search: ");
        String id = scanner.nextLine().trim();
        
        int index = findStudentIndex(id);
        if (index != -1) {
            System.out.println("\nStudent Found:");
            studentList.get(index).displayStudent();
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    // 4. UPDATE STUDENT DETAILS
    private static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        String id = scanner.nextLine().trim();

        int index = findStudentIndex(id);
        if (index == -1) {
            System.out.println("Student with ID " + id + " not found.");
            return;
        }

        Student student = studentList.get(index);
        System.out.println("\nCurrent details: ");
        student.displayStudent();

        System.out.print("Enter New Name (or press Enter to keep current): ");
        String name = scanner.nextLine().trim();
        if (!name.isEmpty()) {
            student.setName(name);
        }

        System.out.print("Enter New Age (or enter 0 to keep current): ");
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter a valid integer for Age: ");
            scanner.next();
        }
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        if (age > 0) {
            student.setAge(age);
        }

        System.out.print("Enter New Grade (or press Enter to keep current): ");
        String grade = scanner.nextLine().trim();
        if (!grade.isEmpty()) {
            student.setGrade(grade);
        }

        System.out.println("Student details updated successfully!");
    }

    // 5. DELETE A STUDENT
    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        String id = scanner.nextLine().trim();

        int index = findStudentIndex(id);
        if (index != -1) {
            studentList.remove(index); // Removes the item at the specific index position
            System.out.println("Student record deleted successfully!");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    // HELPER METHOD: Find index of a student by ID using linear search
    private static int findStudentIndex(String id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equalsIgnoreCase(id)) {
                return i; // Returns position index if found
            }
        }
        return -1; // Returns -1 if ID does not exist
    }
}
