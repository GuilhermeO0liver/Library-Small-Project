import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        for (Book book : books){
            System.out.println(book.getTitle() + "\n" +
                    "Is available: " + book.isAvailable());
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

    public void showSingleBookInfo(String book_name, Scanner scanner){
        Book book = findBookByTitle(book_name);
        if (book != null){
            book.showInfo();
            System.out.println("Do you want to change the book info?: Y/N");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("Y")) {
                System.out.println("What Information do you want to change?");
                changeBookInfo(book_name, scanner);
            }
        } else {
            System.out.println("Book not found");
        }
    }

    public void changeBookTitle(String bookName, String newBookTitle){
        Book book = findBookByTitle(bookName);
        if (book != null){
            book.setTitle(newBookTitle);
            System.out.println("Title updated successfully");
        } else {
            System.out.println("Error: No book found with title '" + bookName + "'");
        }
    }

    public void changeBookAuthor(String bookName, String newBookAuthor){
        Book book = findBookByTitle(bookName);
        if (book != null){
            book.setAuthor(newBookAuthor);
            System.out.println("Author updated successfully");
        } else {
            System.out.println("Error: No book found with title '" + bookName + "'");
        }
    }

    public void changeBookAvailable(String bookName, Boolean newAvailable){
        Book book = findBookByTitle(bookName);
        if (book != null){
            book.setAvailable(newAvailable);
            System.out.println("Availability updated successfully");
        } else {
            System.out.println("Error: No book found with title '" + bookName + "'");
        }
    }

    public void changeBookInfo(String bookName, Scanner scanner){
        String response;
        boolean validAnswer;
        do {

            System.out.println("Press T to change the Title");
            System.out.println("Press A to change the Author");
            System.out.println("Press I to change the Availability");
            response = scanner.nextLine().trim();

            if (response.equalsIgnoreCase("T") ||
                    response.equalsIgnoreCase("A") ||
                    response.equalsIgnoreCase("I")){
                validAnswer = true;
            } else {
                System.out.println("ERROR : Input invalid");
                validAnswer = false;
            }

        } while(!validAnswer);

        if (response.equalsIgnoreCase("T")){
            System.out.println("Input the new name: ");
            String newBookTitle = scanner.nextLine();
            changeBookTitle(bookName, newBookTitle);
        }
        else if (response.equalsIgnoreCase("A")){
            System.out.println("Input the new Author: ");
            String newBookAuthor = scanner.nextLine();
            changeBookAuthor(bookName, newBookAuthor);
        }
        else if (response.equalsIgnoreCase("I")){

            boolean newBookAvailability = false;
            validAnswer = false;
            do {
                System.out.println("Input the Availability:  true/false");
                String availableInput = scanner.nextLine();
                if (availableInput.equalsIgnoreCase("true") ||
                        availableInput.equalsIgnoreCase("false")){
                    newBookAvailability = availableInput.equalsIgnoreCase("true");
                    validAnswer = true;
                } else {
                    System.out.println("ERROR : Input invalid. Please enter 'true' or 'false'");

                }
            }
            while (!validAnswer);
            changeBookAvailable(bookName, newBookAvailability);
        }
    }

}
