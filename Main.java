import java.util.Scanner;
/*
 * This app is a simple library inventory system that allows users to add books, borrow books, return books, 
 * and search for books by title. The Inventory class manages the collection of books and the lending process, 
 * while the Book class represents individual book objects with their attributes and methods. 
 */
public class Main {

    public static int askID(Scanner scnr) {
        int ID;
        while (true) {
            System.out.print("Enter book ID: ");
            try {
                ID = scnr.nextInt();
                scnr.nextLine(); // Consume the newline character
                if (ID < 0) {
                    throw new IllegalArgumentException("Book ID cannot be negative.");
                }
                break;
            // Catch specific exceptions for invalid input
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            // Catch any other exceptions that may occur
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid integer for the book ID.");
                scnr.nextLine(); // Consume the invalid input
            }
        }
        return ID;
    }
    public static String askTitle(Scanner scnr) {
        while (true) {
            System.out.print("Enter book title: ");
            String title = scnr.nextLine();
            if (title.trim().isEmpty()) {
                System.out.println("Book title cannot be empty. Please enter a valid title.");
            } else {
                return title;
            }
        }
    }
    public static String askAuthor(Scanner scnr) {
        while (true) {
            System.out.print("Enter book author: ");
            String author = scnr.nextLine();
            if (author.trim().isEmpty()) {
                System.out.println("Book author cannot be empty. Please enter a valid author.");
            } else {
                return author;
            }
        }
    }
    public static int askISBN(Scanner scnr) {
        int ISBN;
        while (true) {
            System.out.print("Enter book ISBN: ");
            try {
                ISBN = scnr.nextInt();
                scnr.nextLine();
                if (ISBN < 0) {
                    throw new IllegalArgumentException("ISBN cannot be negative.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid integer for the ISBN.");
                scnr.nextLine(); // Consume the invalid input
            }
        }
        return ISBN; 
    }
    public static int askNumberOfPages(Scanner scnr) {
        int numberOfPages;
        while (true) {
            System.out.print("Enter number of pages: ");
            try {
                numberOfPages = scnr.nextInt();
                scnr.nextLine(); // Consume the newline character
                if (numberOfPages < 0) {
                    throw new IllegalArgumentException("Number of pages cannot be negative.");
                }
                break;
            // Catch specific exceptions for invalid input
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            // Catch any other exceptions that may occur
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid integer for the number of pages.");
                scnr.nextLine(); // Consume the invalid input
            }
        }
        return numberOfPages;
    }
    
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Inventory library = new Inventory();
        System.out.println("Welcome to the Library Inventory System!");
        int choice = 0;
        while (choice != 6) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Add a book");
            System.out.println("2. Borrow a book");
            System.out.println("3. Return a book");
            System.out.println("4. Print all books in inventory");
            System.out.println("5. Search for a book by title");
            System.out.println("6. Exit");
            choice = scnr.nextInt();
            scnr.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    int ID = askID(scnr);
                    String title = askTitle(scnr);
                    String author = askAuthor(scnr);
                    int ISBN = askISBN(scnr);
                    int numberOfPages = askNumberOfPages(scnr);
                    library.addBook(ID, title, author, ISBN, numberOfPages);
                    break;
                case 2:
                    System.out.print("Enter the ID of the book you want to borrow: ");
                    int borrowID = scnr.nextInt();
                    scnr.nextLine(); // Consume the newline character
                    library.borrowBook(borrowID);
                    break;
                case 3:
                    System.out.print("Enter the ID of the book you want to return: ");
                    int returnID = scnr.nextInt();
                    library.returnBook(returnID);
                    break;
                case 4:
                    library.printAll();
                    break;
                case 5:
                    System.out.print("Enter the title to search for: ");
                    String searchTitle = scnr.nextLine();
                    library.searchByTitle(searchTitle);
                    break;
                case 6:
                    System.out.println("Exiting the Library Inventory System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scnr.close();
    }
}
