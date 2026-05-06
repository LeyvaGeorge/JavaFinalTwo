import java.util.ArrayList;

public class Inventory {
    // Attributes
    private ArrayList<Book> inventory;
    private ArrayList<Book> lending;

    // Constructor
    public Inventory() {
        inventory = new ArrayList<Book>();
        lending = new ArrayList<Book>();
    }

    //Methods
    //This will create a new Book object and add it to the library
    public void addBook(int ID, String title, String author, int ISBN, int numberOfPages) {
        Book book = new Book(ID, title, author, ISBN, numberOfPages);
        inventory.add(book);
    }

    // This will remove from inventory and add to lending
    public void borrowBook(int bookID) {
        // cycles through the inventory to find the book with the matching ID, if found it will add to lending and remove from inventory
        for (Book textBook : inventory) { 
            if (textBook.getID() == bookID) {
                lending.add(textBook);
                inventory.remove(textBook);
                System.out.println("Book: " + textBook.getTitle() + " - Successfully borrowed.");
                return; // Exit the method after borrowing the book
            }
        }
        System.out.println("Book with ID " + bookID + " not found in inventory.");
        return; // Exit the method if the book is not found
    }

    // this will move from lending back to inventory
    public void returnBook(int bookID) {
        // cycles through the lending list to find the book with the matching ID, if found it will remove from lending and add to inventory
        for (Book textBook : lending) {
            if (textBook.getID() == bookID) {
                inventory.add(textBook);
                lending.remove(textBook);
                System.out.println("Book: " + textBook.getTitle() + " - Successfully returned.");
                return; // Exit the method after returning the book
            }
        }
        System.out.println("Book with ID " + bookID + " not found in lending.");
        return; // Exit the method if the book is not found
    }

    // This will print all the books in the inventory
    public void printAll() {
        for (Book textBook : inventory) {
            System.out.println();
            textBook.printBookInfo();
        }
    }
    
    // this will iterate through the inventory and return all books that partial match the title
    public void searchByTitle(String title) {
        title = title.toLowerCase(); // Convert search title to lowercase for case-insensitive comparison
        boolean found = false;  // Flag to check if any book is found
        for (Book textBook : inventory) {
            // Get the book title, convert it to lowercase, and check if it contains the search title
            if (textBook.getTitle().toLowerCase().contains(title)) {
                textBook.printBookInfo();
                found = true;  // Set flag to true if a book is found
            }
        }
        if (!found) {
            System.out.println("No books found with the title containing: " + title);
        }
        return; // Exit the method after searching for the book
    }

    public boolean inventoryIsEmpty() {
        return inventory.isEmpty();
    }
    public boolean lendingIsEmpty() {
        return lending.isEmpty();
    }
}
