/*
 * In this exercise, we define a Book and an Author class and define
 * a bi-directional association between them: a book has one author and
 * an author can have many books
 */

/*
 * Book class
 */
class Book {
    private String title;
    private int numPages;
    private double price;
    private Author author;

    public Book(String title, int numPages, double price) {
        this.title = title;
        this.numPages = numPages;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}

/*
 * Author class
 */
class Author {
    private String name;
    private int yearBirth;
    private Book[] books;

    public Author(String name, int yearBirth, Book[] books) {
        this.name = name;
        this.yearBirth = yearBirth;
        this.books = books;

        for (int i = 0; i < books.length; i++) {
            books[i].setAuthor(this);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearBirth() {
        return yearBirth;
    }

    public void setYearBirth(int yearBirth) {
        this.yearBirth = yearBirth;
    }

    public Book[] getBooks() {
        return books;
    }
}

/*
 * Main class
 */
public class BookAssociation {
    public static void main(String[] args) {
        Book[] books = new Book[3];
        books[0] = new Book("The Lord of The Rings", 876, 19.95);
        books[1] = new Book("The Hobbit", 316, 11.15);
        books[2] = new Book("The Silmarillion", 521, 10.95);

        Author author = new Author("J.R.R. Tolkien", 1892, books);

        System.out.println(books[0].getTitle());
        System.out.println(books[1].getAuthor().getName());
    }
}


