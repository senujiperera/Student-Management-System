import java.util.ArrayList;
import java.util.Scanner;

// Student class represents individual student records
class Student {
    private int id ;
    private String name ;
    private String course;

    // Constructor to initialize a Student object
    public Student(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    // Getter method
    public int getId() { return id; }
    public String getName() { return name; }
    public String getCourse() { return course; }

    // print student details
    public void displayStudent() {
        System.out.println("ID: " + id + " | Name: " + name + " | Course: " + course);
    }
}

public class Main {
    public static void main(String[] args) {

        // Store multiple Student objects dynamically
        ArrayList<Student> studentList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display menu options
            System.out.println("\n--- STUDENT MANAGEMENT SYSTEM ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Exit");
            System.out.print("Enter option: ");

            int choice = scanner.nextInt();

            // Option 1:Add a new student record
            if (choice == 1) {
                System.out.print("Enter Student ID : ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Name : ");
                String name = scanner.nextLine();
                System.out.print("Enter Course : ");
                String course = scanner.nextLine();

                studentList.add(new Student(id, name, course));
                System.out.println(" Student added successfully !");

                // Option 2: View all stored students
            } else if (choice == 2) {
                System.out.println("\n--- Student List -----");
                if (studentList.isEmpty()) {
                    System.out.println("No students found. ");
                } else {
                    for (Student s : studentList) {
                        s.displayStudent();
                    }
                }

                // Option 3: Search for a specific student by ID
            } else if (choice == 3) {
                System.out.print("Enter Student ID to search: ");
                int searchId = scanner.nextInt();
                boolean found = false;

                for (Student s : studentList) {
                    if (s.getId() == searchId) {
                        System.out.println(" Student Found:");
                        s.displayStudent();
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println(" Student not found.");
                }

                // Option 4: Exit the application
            } else if (choice == 4) {
                System.out.println("Exiting System... Thank you !");
                break;
            } else {
                System.out.println("Invalid option ! Try again.");
            }
        }
        scanner.close();
    }
}