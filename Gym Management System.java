import java.util.*;


class Member {
    private int id;
    private String name;
    private int age;
    private String membershipType;

    public Member(int id, String name, int age, String membershipType) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.membershipType = membershipType;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getMembershipType() { return membershipType; }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Age: " + age + " | Membership: " + membershipType;
    }
}
class GymManagementSystem {
    private ArrayList<Member> members = new ArrayList<>();

    // Add new member
    public void addMember(int id, String name, int age, String type) {
        for (Member m : members) {
            if (m.getId() == id) {
                System.out.println(" Member with ID " + id + " already exists!");
                return;
            }
        }
        members.add(new Member(id, name, age, type));
        System.out.println(" Member added successfully!");
    }
    public void viewAllMembers() {
        if (members.isEmpty()) {
            System.out.println(" No members found!");
        } else {
            System.out.println("\n--- Member List ---");
            for (Member m : members) {
                System.out.println(m);
            }
        }
    }
    public void searchMember(int id) {
        boolean found = false;
        for (Member m : members) {
            if (m.getId() == id) {
                System.out.println(m);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println(" Member not found!");
        }
    }
    public void cancelMembership(int id) {
        Iterator<Member> it = members.iterator();
        boolean removed = false;
        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.remove();
                removed = true;
                break;
            }
        }
        if (removed) {
            System.out.println(" Membership cancelled!");
        } else {
            System.out.println(" Member not found!");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        GymManagementSystem gym = new GymManagementSystem();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Gym Management System ---");
            System.out.println("1. Add Member");
            System.out.println("2. View All Members");
            System.out.println("3. Search Member by ID");
            System.out.println("4. Cancel Membership");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice;
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(" Invalid input! Enter a number.");
                sc.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Membership Type (Regular/Premium): ");
                    String type = sc.nextLine();
                    gym.addMember(id, name, age, type);
                    break;

                case 2:
                    gym.viewAllMembers();
                    break;

                case 3:
                    System.out.print("Enter Member ID: ");
                    int searchId = sc.nextInt();
                    gym.searchMember(searchId);
                    break;

                case 4:
                    System.out.print("Enter Member ID to cancel: ");
                    int cancelId = sc.nextInt();
                    gym.cancelMembership(cancelId);
                    break;

                case 5:
                    System.out.println(" Exiting system. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println(" Invalid choice, try again!");
            }
        }
    }
}

