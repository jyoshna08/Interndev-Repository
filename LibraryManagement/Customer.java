package Inderndev_Assignments.Task_1.LibraryManagement;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String id;
    private List<Book> borrowedBooks;

    public Customer(String name, String id) {
        this.name = name;
        this.id = id;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }
}
