package mini_project;

import java.util.*;

public class onlineJobPortal {

    static Scanner sc = new Scanner(System.in);

    // Login
    static String username = "";
    static String password = "";

    // User Details
    static String name;
    static String phone;
    static String email;
    static String qualification;
    static String skill;
    static String experience;
    static String jobType;

    // Applied Jobs
    static ArrayList<String> appliedJobs = new ArrayList<>();

    // Job Data
    static int jobId[] = {101,102,103,104,105,106,107,108,109,110};

    static String role[] = {"Java Developer","Python Developer","Web Developer","Software Tester", "Data Analyst","HR Executive","Accountant","UI UX Designer","Network Engineer","Technical Support"};

    static String company[] = {"TCS","Infosys","Wipro","Zoho","HCL","Accenture","Capgemini","Tech Mahindra","IBM","Cognizant"};

    static String location[] = {"Chennai","Bangalore","Hyderabad","Coimbatore","Pune","Chennai","Bangalore","Hyderabad","Pune","Chennai"};

    static int salary[] = {300000,450000,350000,400000,500000,280000,320000,380000,420000,360000};

    static String exp[] = {"Fresher","1 Year","2 Years","Fresher","3 Years", "Fresher","1 Year","2 Years","3 Years","Fresher"};

    static String skills[] = { "Java","Python","HTML","Testing","SQL","Communication","Accounting","Figma","Networking","Support" };

    static String type[] = {"IT","IT","IT","IT","IT","NON-IT","NON-IT","IT","IT","IT" };

    static String app[] = {"Naukri","LinkedIn","Indeed","Apna","Foundit","Naukri","LinkedIn","Indeed","Apna","Foundit"};

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== ONLINE JOB PORTAL =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Forgot Password");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1: register(); break;
                case 2: if (login()) userMenu(); break;
                case 3: forgotPassword(); break;
                case 4:
                    System.out.println("Thank You");
                    System.exit(0);
            }
        }
    }

    // REGISTER
    static void register() {

        sc.nextLine();

        System.out.println("\nREGISTER");

        System.out.print("Username: ");
        username = sc.nextLine();

        System.out.print("Password: ");
        password = sc.nextLine();

        System.out.print("Name: ");
        name = sc.nextLine();

        System.out.print("Phone: ");
        phone = sc.nextLine();

        System.out.print("Email: ");
        email = sc.nextLine();

        System.out.print("Qualification: ");
        qualification = sc.nextLine();

        System.out.print("Skill: ");
        skill = sc.nextLine();

        System.out.print("Experience: ");
        experience = sc.nextLine();

        System.out.print("Job Type: ");
        jobType = sc.nextLine();

        System.out.println("Registered Successfully");
    }

    // LOGIN
    static boolean login() {

        sc.nextLine();

        System.out.print("Username: ");
        String u = sc.nextLine();

        System.out.print("Password: ");
        String p = sc.nextLine();

        if (username.equals(u) && password.equals(p)) {
            System.out.println("Login Success");
            return true;
        }

        System.out.println("Invalid Login");
        return false;
    }

    // FORGOT PASSWORD
    static void forgotPassword() {

        sc.nextLine();

        System.out.print("Enter Phone: ");
        String ph = sc.nextLine();

        if (phone != null && phone.equals(ph)) {
            System.out.println("Password: " + password);
        } else {
            System.out.println("Not Found");
        }
    }

    // MENU
    static void userMenu() {

        while (true) {

            System.out.println("\n1.View Profile");
            System.out.println("2.View Jobs");
            System.out.println("3.Search");
            System.out.println("4.Filter");
            System.out.println("5.Apply Job");
            System.out.println("6.View Applied");
            System.out.println("7.Cancel Job");
            System.out.println("8.Logout");

            int ch = sc.nextInt();

            switch (ch) {

                case 1: viewProfile(); break;
                case 2: viewJobs(); break;
                case 3: searchJob(); break;
                case 4: filterJobs(); break;
                case 5: applyJob(); break;
                case 6: viewAppliedJobs(); break;
                case 7: cancelJob(); break;
                case 8: return;
            }
        }
    }

    // PROFILE
    static void viewProfile() {

        System.out.println(name);
        System.out.println(phone);
        System.out.println(email);
        System.out.println(skill);
        System.out.println(experience);
    }

    // VIEW JOBS
    static void viewJobs() {

        for (int i = 0; i < jobId.length; i++) {
            System.out.println(jobId[i] + " " + role[i] + " " + company[i]);
        }
    }

    // SEARCH
    static void searchJob() {

        sc.nextLine();

        System.out.print("Enter skill: ");
        String s = sc.nextLine();

        for (int i = 0; i < skills.length; i++) {

            if (skills[i].equalsIgnoreCase(s)) {
                System.out.println(role[i] + " " + company[i]);
            }
        }
    }

    // FILTER
    static void filterJobs() {

        System.out.print("Min salary: ");
        int s = sc.nextInt();

        for (int i = 0; i < salary.length; i++) {

            if (salary[i] >= s) {
                System.out.println(role[i] + " " + salary[i]);
            }
        }
    }

    // APPLY
 // APPLY JOB
    static void applyJob() {

        System.out.print("Enter Job ID: ");
        int id = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < jobId.length; i++) {

            if (jobId[i] == id) {

                found = true;

                if (!appliedJobs.contains(role[i])) {

                    appliedJobs.add(role[i]);

                    System.out.println("\nApplication Submitted Successfully");

                    System.out.println("-----------------------------");
                    System.out.println("Role       : " + role[i]);
                    System.out.println("Company    : " + company[i]);
                    System.out.println("Location   : " + location[i]);
                    System.out.println("Salary     : " + salary[i]);
                    System.out.println("Apply From : " + app[i]);

                    System.out.println("\nOpen " + app[i] + " website/app");
                    System.out.println("Search " + role[i] + " in " + company[i]);

                } else {

                    System.out.println("Already Applied");
                }

                break;
            }
        }

        if(!found) {
            System.out.println("Invalid Job ID");
        }
    }

    // VIEW APPLIED
    static void viewAppliedJobs() {

        System.out.println("\nAPPLIED JOBS:");

        for (String j : appliedJobs) {
            System.out.println(j);
        }
    }

    // CANCEL
    static void cancelJob() {

        sc.nextLine();

        System.out.print("Enter role to cancel: ");
        String r = sc.nextLine();

        if (appliedJobs.remove(r)) {
            System.out.println("Cancelled");
        } else {
            System.out.println("Not found");
        }
    }
}