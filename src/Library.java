import java.util.ArrayList;
import java.util.List;

public class Library {
    private final String name;
    private final List<Book> books;

    public Library(String name){
        this.name = name;
        this.books = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        if (books.isEmpty()){
            return null;
        }
        return books;
    }

    private Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void addBook(Book book){
        Book existingBook = findBookByTitle(book.getTitle());
        if (existingBook != null) {
            System.out.println("Book already exists in library");
        } else {
            books.add(book);
            System.out.println("Book added successfully");
        }

    }

    public void showEachBook(){
        for (Book Book : books){
            System.out.println(Book.getTitle() + "\n" +
                    "Is available: " + Book.isAvailable());
        }
    }

    public void removeBookByTitle(String book_title){
        Book book = findBookByTitle(book_title);
        if (book != null) {
            books.remove(book);
            System.out.println("Book removed successfully");
        } else {
            System.out.println("Error: No book found with title '" + book_title + "'");
        }
    }

    public void showSingleBookInfo(String book_name){
        Book book = findBookByTitle(book_name);
        if (book != null){
            book.showInfo();
        } else {
            System.out.println("Book not found");
        }
    }

    public void changeBookTitle(String book_name, String newBookTitle){
        Book book = findBookByTitle(book_name);
        if (book != null){
            book.setTitle(newBookTitle);
            System.out.println("Title updated successfully");
        } else {
            System.out.println("Error: No book found with title '" + book_name + "'");
        }
    }

    public void changeBookAuthor(String book_name, String newBookAuthor){
        Book book = findBookByTitle(book_name);
        if (book != null){
            book.setAuthor(newBookAuthor);
            System.out.println("Author updated successfully");
        } else {
            System.out.println("Error: No book found with title '" + book_name + "'");
        }
    }

    public void changeBookAvailable(String book_name, Boolean newAvailable){
        Book book = findBookByTitle(book_name);
        if (book != null){
            book.setAvailable(newAvailable);
            System.out.println("Availability updated successfully");
        } else {
            System.out.println("Error: No book found with title '" + book_name + "'");
        }
    }

}
