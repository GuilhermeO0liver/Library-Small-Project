import java.util.Random;

public class Book {
    private String title;
    private String author;
    private final long ISBN;
    private boolean isAvailable;

    Random random = new Random();

    public Book(String title, String author, boolean isAvailable){
        this.title = title;
        this.author = author;
        ISBN = random.nextLong(100000000000L, 999999999999L);
        this.isAvailable = isAvailable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public void showInfo(){
        System.out.println("Title: "+ this.title);
        System.out.println("Author: "+ this.author);
        System.out.println("ISBN: "+ this.ISBN);
        System.out.println("Available: "+ this.isAvailable);
    }
}
