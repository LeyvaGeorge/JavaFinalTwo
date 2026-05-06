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
        library.addBook(1, "The Great Gatsby", "F. Scott Fitzgerald", 3273565, 180);
        library.addBook(2, "To Kill a Mockingbird", "Harper Lee", 978006093, 281);
        library.addBook(3, "1984", "George Orwell", 978045152, 328);
        library.addBook(4, "Pride and Prejudice", "Jane Austen", 978014143, 279);
        library.addBook(5, "The Catcher in the Rye", "J.D. Salinger", 978031676, 214);
        library.addBook(6, "The Hobbit", "J.R.R. Tolkien", 978054792, 310);
        library.addBook(7, "Harry Potter and the Philosopher's Stone", "J.K. Rowling", 97804397, 309);
        library.addBook(8, "The Lord of the Rings", "J.R.R. Tolkien", 978054400, 1178);
        library.addBook(9, "The Chronicles of Narnia", "C.S. Lewis", 978006623, 767);
        library.addBook(10,"Alice's Adventures in Wonderland", "Lewis Carroll", 978048627, 200);
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
            System.out.print("\nEnter your choice: ");
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
                    //Check if file is empty
                    if (library.inventoryIsEmpty()) {
                        System.out.println("No books available in inventory to borrow.");
                        break;
                    }
                    System.out.print("Enter the ID of the book you want to borrow: ");
                    int borrowID = scnr.nextInt();
                    scnr.nextLine(); // Consume the newline character
                    library.borrowBook(borrowID);
                    break;
                case 3:
                    //Check if file is empty
                    if (library.lendingIsEmpty()) {
                        System.out.println("No books currently borrowed to return.");
                        break;
                    }
                    System.out.print("Enter the ID of the book you want to return: ");
                    int returnID = scnr.nextInt();
                    library.returnBook(returnID);
                    break;
                case 4:
                    //Check if file is empty
                    if (library.inventoryIsEmpty()) {
                        System.out.println("No books available in inventory.");
                        break;
                    }
                    library.printAll();
                    break;
                case 5:
                    //Check if file is empty
                    if (library.inventoryIsEmpty()) {
                        System.out.println("No books available in inventory to search.");
                        break;
                    }
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
