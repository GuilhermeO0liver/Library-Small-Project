import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library("Guilherme's");

        System.out.println("Welcome to the " + library.getName() + " Library");
        System.out.println("What do you want to do?");

        SearchForInput(library, scanner);
    }

    public static void SearchForInput(Library library, Scanner scanner) throws InterruptedException {

        boolean answerValid;
        String response;

        do{

            System.out.println("Press B for browse through all books present in the Library");
            System.out.println("Press A to add a book");
            System.out.println("Press D to delete a book");
            System.out.println("Press S to search a singular book");

            response = scanner.nextLine();

            if (response.equalsIgnoreCase("B") ||
                    response.equalsIgnoreCase("A") ||
                    response.equalsIgnoreCase("D") ||
                    response.equalsIgnoreCase("S")){
                answerValid = true;
            } else {
                System.out.println("ERROR: invalid Input. Please try again.");
                answerValid = false;
            }
        } while (!answerValid);

        if (response.equalsIgnoreCase("B")){
            if (library.getBooks() == null){
                System.out.println("There is no books currently in the library");
            }
            else {
                System.out.println("Those are the current books presents in the Library:" );
                library.showEachBook();

                Thread.sleep(1000);
            }

        }

        else if (response.equalsIgnoreCase("A")) {
            System.out.println("What book do you want to add: ");
            String bookName = scanner.nextLine();
            System.out.println("Who is the author of the book that you want to add: ");
            String bookAuthor = scanner.nextLine();
            Book bookAdd = new Book(bookName, bookAuthor, true);
            library.addBook(bookAdd);

            Thread.sleep(1000);

        }

        else if (response.equalsIgnoreCase("D")) {
            System.out.println("What is the title of the book you want to remove: ");
            library.showEachBook();
            String bookTitle = scanner.nextLine();
            library.removeBookByTitle(bookTitle);

            Thread.sleep(1000);



        }

        // make that you can change the book title, author and if is available
        else if (response.equalsIgnoreCase("S")) {
            System.out.println("Type the name of the book: ");
            String bookName = scanner.nextLine();
            library.showSingleBookInfo(bookName, scanner);

            Thread.sleep(1000);

        }
        answerValid = false;

        do {
            System.out.println("Do you want to continue to search in the Library?: Y/N");
            response = scanner.nextLine();
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



}
