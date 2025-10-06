import java.util.ArrayList;
import java.util.List;

public class Library {
    private final String name;
    private final List<Book> Books;

    public Library(String name){
        this.name = name;
        this.Books = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        if (Books.isEmpty()){
            return null;
        }
        return Books;
    }

    public void addBook(Book book){
        Books.add(book);
    }

    public void showEachBook(){
        for (Book Book : Books){
            System.out.println(Book.getTitle() + "\n" +
                    "Is available: " + Book.isAvailable());
        }
    }

    public void removeBookByTitle(String book_title){
        boolean removed = Books.removeIf(book -> book.getTitle().equalsIgnoreCase(book_title));
        if (removed) {
            System.out.println("Book removed successfully");
        } else {
            System.out.println("Error: No book found with title '" + book_title + "'");
        }
    }

    public void showSingleBookInfo(String book_name){
        for (Book Book : Books){
            if (Book.getTitle().equalsIgnoreCase(book_name)){
                Book.showInfo();
            } else {
                System.out.println("Book not found");
            }
        }
    }

    public void changeBookTitle(String book_name, String newBookTitle){
        for (Book Book : Books){
            if (Book.getTitle().equalsIgnoreCase(book_name)){
                Book.setTitle(newBookTitle);
            }
        }
    }

    public void changeBookAuthor(String book_name, String newBookAuthor){
        for (Book Book : Books){
            if (Book.getTitle().equalsIgnoreCase(book_name)){
                Book.setAuthor(newBookAuthor);
            }
        }
    }

    public void changeBookAvailable(String book_name, Boolean newAvailable){
        for (Book Book : Books){
            if (Book.getTitle().equalsIgnoreCase(book_name)){
                Book.setAvailable(newAvailable);
            }
        }
    }

}
