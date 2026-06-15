import java.util.Random;

public class Book {
    private String title;
    private String author;
    private final long ISBN;
    private boolean isAvailable;

    public Book(String title, String author, boolean isAvailable){
        this.title = title;
        this.author = author;
        ISBN = new Random().nextLong(100000000000L, 999999999999L);
        this.isAvailable = isAvailable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public long getISBN() {
        return ISBN;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nAuthor: " + author +
                "\nISBN: " + ISBN + "\nAvailable: " + isAvailable;
    }
}
