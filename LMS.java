import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    String author;
    boolean isCheckedOut;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isCheckedOut = false;
    }
}

class Library {
    ArrayList<Book> books = new ArrayList<>();

    public void addBook(String title, String author) {
        books.add(new Book(title, author));
    }

    public void listBooks() {
        System.out.println("Library Catalog:");
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            String status = book.isCheckedOut ? "Checked Out" : "Available";
            System.out.println((i + 1) + ". " + book.title + " by " + book.author + " (" + status + ")");
        }
    }

    public void checkoutBook(int bookIndex) {
        if (bookIndex >= 0 && bookIndex < books.size()) {
            Book book = books.get(bookIndex);
            if (!book.isCheckedOut) {
                book.isCheckedOut = true;
                System.out.println("You've checked out: " + book.title);
            } else {
                System.out.println("This book is already checked out.");
            }
        } else {
            System.out.println("Invalid book selection.");
        }
    }

    public void returnBook(int bookIndex) {
        if (bookIndex >= 0 && bookIndex < books.size()) {
            Book book = books.get(bookIndex);
            if (book.isCheckedOut) {
                book.isCheckedOut = false;
                System.out.println("You've returned: " + book.title);
            } else {
                System.out.println("This book is not checked out.");
            }
        } else {
            System.out.println("Invalid book selection.");
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. List Books");
            System.out.println("3. Check Out Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    library.addBook(title, author);
                    System.out.println("Book added to the library.");
                    break;
                case 2:
                    library.listBooks();
                    break;
                case 3:
                    System.out.print("Enter the book number to check out: ");
                    int checkoutIndex = scanner.nextInt() - 1;
                    library.checkoutBook(checkoutIndex);
                    break;
                case 4:
                    System.out.print("Enter the book number to return: ");
                    int returnIndex = scanner.nextInt() - 1;
                    library.returnBook(returnIndex);
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
