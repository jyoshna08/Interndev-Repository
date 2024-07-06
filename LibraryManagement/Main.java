package Inderndev_Assignments.Task_1.LibraryManagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Sample data
        library.addBook(new Book("Java Programming", "James Gosling", "1111"));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "2222"));
        library.addCustomer(new Customer("Alice", "C001"));
        library.addCustomer(new Customer("Bob", "C002"));

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Add Customer");
            System.out.println("3. Search Book by Title");
            System.out.println("4. Lend Book");
            System.out.println("5. Return Book");
            System.out.println("6. Check for Fines");
            System.out.println("7. Display Books");
            System.out.println("8. Display Customers");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book ISBN: ");
                    String isbn = scanner.nextLine();
                    library.addBook(new Book(title, author, isbn));
                    break;
                case 2:
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter customer ID: ");
                    String id = scanner.nextLine();
                    library.addCustomer(new Customer(name, id));
                    break;
                case 3:
                    System.out.print("Enter book title to search: ");
                    title = scanner.nextLine();
                    Book book = library.searchBookByTitle(title);
                    if (book != null) {
                        System.out.println(book);
                    } else {
                        System.out.println("Book not found!");
                    }
                    break;
                case 4:
                    System.out.print("Enter book title to lend: ");
                    title = scanner.nextLine();
                    System.out.print("Enter customer ID: ");
                    id = scanner.nextLine();
                    library.lendBook(title, id);
                    break;
                case 5:
                    System.out.print("Enter book title to return: ");
                    title = scanner.nextLine();
                    System.out.print("Enter customer ID: ");
                    id = scanner.nextLine();
                    library.returnBook(title, id);
                    break;
                case 6:
                    library.checkForFines();
                    break;
                case 7:
                    library.displayBooks();
                    break;
                case 8:
                    library.displayCustomers();
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option! Try again.");
                    break;
            }
        }
    }
}
