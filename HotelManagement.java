import java.util.Scanner;

class Room {
    String name;
    int days;
    boolean isBooked;

    Room() {
        name = "";
        days = 0;
        isBooked = false;
    }
}

public class HotelManagement {
    static Room[] rooms = new Room[10]; // 10 rooms

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initialize rooms
        for (int i = 0; i < 10; i++) {
            rooms[i] = new Room();
        }

        int choice;
        do {
            System.out.println("\n===== Hotel Management System =====");
            System.out.println("1. Book Room");
            System.out.println("2. View Booked Rooms");
            System.out.println("3. Checkout Room");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    bookRoom(sc);
                    break;
                case 2:
                    viewBookedRooms();
                    break;
                case 3:
                    checkoutRoom(sc);
                    break;
                case 4:
                    System.out.println("Thank you for using the system!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);
        sc.close();
    }

    static void bookRoom(Scanner sc) {
        System.out.print("Enter room number to book (0-9): ");
        int roomNumber = sc.nextInt();
        if (roomNumber < 0 || roomNumber >= 10) {
            System.out.println("Invalid room number.");
            return;
        }
        if (rooms[roomNumber].isBooked) {
            System.out.println("Room already booked.");
        } else {
            sc.nextLine(); // consume newline
            System.out.print("Enter your name: ");
            rooms[roomNumber].name = sc.nextLine();
            System.out.print("Enter number of days: ");
            rooms[roomNumber].days = sc.nextInt();
            rooms[roomNumber].isBooked = true;
            System.out.println("Room booked successfully!");
        }
    }

    static void viewBookedRooms() {
        System.out.println("\nBooked Rooms:");
        for (int i = 0; i < 10; i++) {
            if (rooms[i].isBooked) {
                System.out.println("Room " + i + ": Booked by " + rooms[i].name + " for " + rooms[i].days + " days.");
            }
        }
    }

    static void checkoutRoom(Scanner sc) {
        System.out.print("Enter room number to checkout (0-9): ");
        int roomNumber = sc.nextInt();
        if (roomNumber < 0 || roomNumber >= 10) {
            System.out.println("Invalid room number.");
            return;
        }
        if (rooms[roomNumber].isBooked) {
            rooms[roomNumber] = new Room(); // Reset room
            System.out.println("Room " + roomNumber + " has been checked out.");
        } else {
            System.out.println("Room is not booked.");
        }
    }
}
