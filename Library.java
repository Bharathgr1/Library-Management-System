package com.elevate;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void issueBook(int bookId, int userId) {
        Book bookToIssue = findBookById(bookId);
        User user = findUserById(userId);

        if (bookToIssue != null && user != null && bookToIssue.isAvailable()) {
            bookToIssue.setAvailable(false);
            user.borrowBook(bookToIssue);
            System.out.println("Book issued successfully to " + user.getName());
        } else {
            System.out.println("Book cannot be issued.");
        }
    }

    public void returnBook(int bookId, int userId) {
        Book bookToReturn = findBookById(bookId);
        User user = findUserById(userId);

        if (bookToReturn != null && user != null && user.getBorrowedBooks().contains(bookToReturn)) {
            bookToReturn.setAvailable(true);
            user.returnBook(bookToReturn);
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Return failed.");
        }
    }

    public void showBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    private Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) return book;
        }
        return null;
    }

    private User findUserById(int id) {
        for (User user : users) {
            if (user.getUserId() == id) return user;
        }
        return null;
    }
}
