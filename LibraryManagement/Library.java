package Inderndev_Assignments.Task_1.LibraryManagement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Customer> customers;

    public Library() {
        books = new ArrayList<>();
        customers = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Book searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void lendBook(String title, String customerId) {
        Book book = searchBookByTitle(title);
        if (book != null && book.isAvailable()) {
            for (Customer customer : customers) {
                if (customer.getId().equals(customerId)) {
                    book.setAvailable(false);
                    book.setDueDate(new Date(System.currentTimeMillis() + (7L * 24 * 60 * 60 * 1000))); // 1 week due date
                    customer.borrowBook(book);
                    System.out.println("Book borrowed successfully!");
                    return;
                }
            }
            System.out.println("Customer not found!");
        } else {
            System.out.println("Book is not available or not found!");
        }
    }

    public void returnBook(String title, String customerId) {
        for (Customer customer : customers) {
            if (customer.getId().equals(customerId)) {
                for (Book book : customer.getBorrowedBooks()) {
                    if (book.getTitle().equalsIgnoreCase(title)) {
                        book.setAvailable(true);
                        book.setDueDate(null);
                        customer.returnBook(book);
                        System.out.println("Book returned successfully!");
                        return;
                    }
                }
            }
        }
        System.out.println("Book or Customer not found!");
    }

    public void checkForFines() {
        for (Customer customer : customers) {
            for (Book book : customer.getBorrowedBooks()) {
                if (new Date().after(book.getDueDate())) {
                    System.out.println("Customer " + customer.getName() + " has a fine for book: " + book.getTitle());
                }
            }
        }
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void displayCustomers() {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}
