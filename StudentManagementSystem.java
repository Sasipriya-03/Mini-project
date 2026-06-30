package mini_project;
import java.util.Scanner;

class Student {
    int id;
    String name;
    double mark;

    Student(int id, String name, double mark) {
        this.id = id;
        this.name = name;
        this.mark = mark;
    }

    String getGrade() {
        if (mark >= 90)
            return "A";
        else if (mark >= 75)
            return "B";
        else if (mark >= 60)
            return "C";
        else if (mark >= 50)
            return "D";
        else
            return "F";
    }

    void display() {
        System.out.println("------------------------");
        System.out.println("ID      : " + id);
        System.out.println("Name    : " + name);
        System.out.println("Mark    : " + mark);
        System.out.println("Grade   : " + getGrade());

        if (mark >= 50)
            System.out.println("Result  : PASS");
        else
            System.out.println("Result  : FAIL");
    }
}

public class StudentManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Student[] students = new Student[100];
        int count = 0;
        int choice;

        do {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Average Mark");
            System.out.println("7. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Student Mark: ");
                    double mark = sc.nextDouble();

                    students[count] = new Student(id, name, mark);
                    count++;

                    System.out.println("Student Added Successfully!");
                    break;

                case 2:

                    if (count == 0) {
                        System.out.println("No Records Found!");
                    } else {
                        for (int i = 0; i < count; i++) {
                            students[i].display();
                        }
                    }
                    break;

                case 3:

                    System.out.print("Enter Student ID to Search: ");
                    int searchId = sc.nextInt();

                    boolean found = false;

                    for (int i = 0; i < count; i++) {
                        if (students[i].id == searchId) {
                            students[i].display();
                            found = true;
                            break;
                        }
                    }

                    if (!found)
                        System.out.println("Student Not Found!");

                    break;

                case 4:

                    System.out.print("Enter Student ID to Update: ");
                    int updateId = sc.nextInt();

                    found = false;

                    for (int i = 0; i < count; i++) {

                        if (students[i].id == updateId) {

                            sc.nextLine();

                            System.out.print("Enter New Name: ");
                            students[i].name = sc.nextLine();

                            System.out.print("Enter New Mark: ");
                            students[i].mark = sc.nextDouble();

                            System.out.println("Student Updated Successfully!");
                            found = true;
                            break;
                        }
                    }

                    if (!found)
                        System.out.println("Student Not Found!");

                    break;

                case 5:

                    System.out.print("Enter Student ID to Delete: ");
                    int deleteId = sc.nextInt();

                    found = false;

                    for (int i = 0; i < count; i++) {

                        if (students[i].id == deleteId) {

                            for (int j = i; j < count - 1; j++) {
                                students[j] = students[j + 1];
                            }

                            students[count - 1] = null;
                            count--;

                            found = true;
                            System.out.println("Student Deleted Successfully!");
                            break;
                        }
                    }

                    if (!found)
                        System.out.println("Student Not Found!");

                    break;

                case 6:

                    if (count == 0) {
                        System.out.println("No Students Available!");
                    } else {

                        double total = 0;

                        for (int i = 0; i < count; i++) {
                            total += students[i].mark;
                        }

                        double average = total / count;

                        System.out.println("Average Mark = " + average);
                    }

                    break;

                case 7:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 7);

        sc.close();
    }
}


