package localSkillExchangeSystem;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== SKILL EXCHANGE SYSTEM ===");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Password: ");
                    String password = sc.nextLine();
                    UserDAO.registerUser(name, email, password);
                }

                case 2 -> {
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Password: ");
                    String password = sc.nextLine();

                    int userId = UserDAO.login(email, password);
                    if (userId != -1) {
                        userMenu(sc, userId);
                    } else {
                        System.out.println("Invalid credentials!");
                    }
                }
            }
        } while (choice != 3);
        System.out.println("Thank you.Have a nice day.\nGoodBye");

        sc.close();
    }

    private static void userMenu(Scanner sc, int userId) {
        int choice;
        do {
            System.out.println("\n--- USER MENU ---");
            System.out.println("1. Add Skill");
            System.out.println("2. Browse Skills");
            System.out.println("3. Book Skill");
            System.out.println("4. View My Bookings");
            System.out.println("5. Logout");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Skill Name: ");
                    String name = sc.nextLine();
                    System.out.print("Description: ");
                    String desc = sc.nextLine();
                    System.out.print("Price per hour: ");
                    double price = sc.nextDouble();
                    SkillDAO.addSkill(userId, name, desc, price);
                }

                case 2 -> SkillDAO.viewAllSkills();

                case 3 -> {
                    System.out.print("Enter Skill ID to book: ");
                    int skillId = sc.nextInt();
                    BookingDAO.bookSkill(skillId, userId);
                }

                case 4 -> BookingDAO.viewMyBookings(userId);
            }
        } while (choice != 5);
    }

	}

