package com.elevate;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding sample books
        library.addBook(new Book(1, "Java Basics", "James Gosling"));
        library.addBook(new Book(2, "OOP Concepts", "Bjarne Stroustrup"));

        // Adding sample users
        library.addUser(new User(101, "Alice"));
        library.addUser(new User(102, "Bob"));

        // Show books
        library.showBooks();

        // Issue book
        library.issueBook(1, 101);
        library.showBooks();

        // Return book
        library.returnBook(1, 101);
        library.showBooks();
    }
}
