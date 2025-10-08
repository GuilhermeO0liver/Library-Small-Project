import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library("Rowan");

        System.out.println("Welcome to the " + library.getName() + " Library");
        Thread.sleep(1000);
        System.out.println("What do you want to do?");
        Thread.sleep(1000);

        SearchForInput(library, scanner);
    }

    public static void SearchForInput(Library library, Scanner scanner) throws InterruptedException {

        boolean AnswerValid = false;
        String Response;

        do{

            System.out.println("Press B for browse through all books present in the Library");
            System.out.println("Press A to add a book");
            System.out.println("Press D to delete a book");
            System.out.println("Press S to search a singular book");

            Response = scanner.nextLine();

            if (Response.equalsIgnoreCase("B") ||
                    Response.equalsIgnoreCase("A") ||
                    Response.equalsIgnoreCase("D") ||
                    Response.equalsIgnoreCase("S")){
                AnswerValid = true;
            } else {
                System.out.println("ERROR: invalid Input. Please try again.");
            }
        } while (!AnswerValid);

        if (Response.equalsIgnoreCase("B")){
            if (library.getBooks() == null){
                System.out.println("There is no books currently in the library");
            }
            else {
                System.out.println("Those are the current books presents in the Library:" );
                library.showEachBook();

                Thread.sleep(1000);
            }

        }

        else if (Response.equalsIgnoreCase("A")) {
            System.out.println("What book do you want to add: ");
            String book_name = scanner.nextLine();
            System.out.println("Who is the author of the book that you want to add: ");
            String book_author = scanner.nextLine();
            Book book_add = new Book(book_name, book_author, true);
            library.addBook(book_add);

            Thread.sleep(1000);

        }

        else if (Response.equalsIgnoreCase("D")) {
            System.out.println("What is the title of the book you want to remove: ");
            library.showEachBook();
            String book_title = scanner.nextLine();
            library.removeBookByTitle(book_title);

            Thread.sleep(1000);



        }
        // make that you can change the book title, author and if is available
        else if (Response.equalsIgnoreCase("S")) {
            System.out.println("Type the name of the book: ");
            String book_name = scanner.nextLine();
            library.showSingleBookInfo(book_name);


            boolean answerValid = false;
            do {
                System.out.println("Do you want to change the book info?: Y/N");
                String response = scanner.nextLine();
                if (response.equalsIgnoreCase("Y")){
                    System.out.println("What Information do you want to change?");
                    changeBookInfo(library, book_name, scanner);

                    answerValid = true;
                } else if (response.equalsIgnoreCase("N")) {
                    answerValid = true;
                } else {
                    System.out.println("ERROR: Input not supported");
                }

            } while(!answerValid);




            Thread.sleep(1000);

        }
        boolean answerValid = false;
        do {
            System.out.println("Do you want to continue to search in the Library?: Y/N");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("Y")){
                SearchForInput(library, scanner);

                answerValid = true;
            } else if (response.equalsIgnoreCase("N")) {
                System.out.println("Leaving the Library...");
                System.exit(0);

                answerValid = true;
            } else {
                System.out.println("ERROR: Input not supported");
            }

            Thread.sleep(1000);
        } while(!answerValid);
    }

    public static void changeBookInfo(Library library, String book_name, Scanner scanner){
        String response;
        boolean validAnswer = false;
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
            }

        } while(!validAnswer);

        if (response.equalsIgnoreCase("T")){
            System.out.println("Input the new name: ");
            String newBookTitle = scanner.nextLine();
            library.changeBookTitle(book_name, newBookTitle);
        }
        else if (response.equalsIgnoreCase("A")){
            System.out.println("Input the new Author: ");
            String newBookAuthor = scanner.nextLine();
            library.changeBookAuthor(book_name, newBookAuthor);
        }
        else if (response.equalsIgnoreCase("I")){

            boolean newBookAvailability = false;
            boolean ValidAnswer = false;
            do {
                System.out.println("Input the Availability:  true/false");
                String availableInput = scanner.nextLine();
                if (availableInput.equalsIgnoreCase("true") ||
                        availableInput.equalsIgnoreCase("false")){
                    newBookAvailability = availableInput.equalsIgnoreCase("true");
                    ValidAnswer = true;
                } else {
                    System.out.println("ERROR : Input invalid. Please enter 'true' or 'false'");
                }
            }
            while (!ValidAnswer);
            library.changeBookAvailable(book_name, newBookAvailability);
        }
    }

}
