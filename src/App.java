import java.util.*;
import Assignment.Student;
import DataStructure.Algorithm.MergeSortStudent;
import Helper.readCSV;

public class App {
    public static void main(String[] args) throws Exception {
        // Read data from CSV file
        List<Student> students = readCSV.csvToArray("student.csv");

        // Display menu for the user
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. View student list");
            System.out.println("2. Add new student");
            System.out.println("3. Search for a student");
            System.out.println("4. Sort student list by marks");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (choice) {
                case 1:
                    // Display student list
                    System.out.println("Student list:");
                    for (Student student : students) {
                        student.print();
                    }
                    break;

                case 2:
                    // Add a new student
                    System.out.print("Enter student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student marks: ");
                    double mark = scanner.nextDouble();
                    students.add(new Student(id, name, mark));
                    System.out.println("Student has been added!");
                    break;

                case 3:
                    // Search for a student by ID
                    System.out.print("Enter student ID to search: ");
                    String searchId = scanner.nextLine();
                    boolean found = false;
                    for (Student student : students) {
                        if (student.getId().equals(searchId)) {
                            student.print();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student with ID " + searchId + " not found.");
                    }
                    break;

                case 4:
                    // Sort student list by marks using Merge Sort from MergeSortStudent class
                    MergeSortStudent.mergeSort(students, 0, students.size() - 1);
                    System.out.println("Student list has been sorted by marks!");
                    break;

                case 5:
                    // Exit the program
                    running = false;
                    System.out.println("Thank you for using the application!");
                    break;

                default:
                    System.out.println("Invalid choice, please try again!");
            }
        }

        scanner.close();
    }
}
