public class Book {
    private int ID;
    private String title;
    private String author;
    private int  ISBN;
    private int numberOfPages;

    // Constructors
    public Book(int ID, String title, String author, int ISBN, int numberOfPages) {
        this.ID = ID;
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.numberOfPages = numberOfPages;
    }
    public Book() {
        this.ID = 0;
        this.title = null;
        this.author = null;
        this.ISBN = 0;
        this.numberOfPages = 0;
    }

    // Getters and Setters
    public int getID() {return ID;}
    public void setID(int ID) {this.ID = ID;}

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public String getAuthor() {return author;}
    public void setAuthor(String author) {this.author = author;}

    public int getISBN() {return ISBN;}
    public void setISBN(int ISBN) {this.ISBN = ISBN;}

    public int getNumberOfPages() {return numberOfPages;}
    public void setNumberOfPages(int numberOfPages) {this.numberOfPages = numberOfPages;}

    // Prints the book information
    public void PrintBookInfo() {
        System.out.println("ID: " + ID);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + ISBN);
        System.out.println("Number of Pages: " + numberOfPages);
    }
}