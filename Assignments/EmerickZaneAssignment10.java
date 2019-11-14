/**
 * Name: Zane Emerick 
 * Class: CS1150 
 * Assignment #10 
 * Due: November 13, 2019
 * 
 * Description: Create a program creates an array of Book objects which are printed and the longest and shortest books are displayed.
 *              The program then creates a Library of those same books and prints / displays the longest and shortest books. 
 */

public class EmerickZaneAssignment10 {
    
    public static void main(String[] args) {
        //create books array
        Book[] bookArray = {
            new Book("Data Structures and Algorithms",  "Michael Goodrich",  720  ),
            new Book("The C++ Programming Language",    "Bjarne Stroustrup", 1376 ),
            new Book("Don't Make Me Think",             "Steve Krug",        216  ),
            new Book("The Elements of Java Style",      "Jim Shur",          144  ),
            new Book("The Design of Everyday Things",   "Don Norman",        368  )
        };

        System.out.println("+------------------------------------------------------------------+");
        System.out.println("|                          Books in Array                          |");
        System.out.println("+------------------------------------------------------------------+");
        System.out.printf("| %-32s| %-19s| %-10s|%n", "Title", "Author", "Page Count");
        System.out.println("+---------------------------------+--------------------+-----------+");
        for(Book book : bookArray) {
            System.out.printf("| %-32s| %-19s| %-10d|%n", book.getTitle(), book.getAuthor(), book.getPageCount());
        }
        System.out.println("+------------------------------------------------------------------+");

        //loop to find shortest pages and longest title
        int leastPages = 0;
        int longestTitle = 0;
        for(int i = 0; i < bookArray.length - 1; i++) {
            if(bookArray[i].getPageCount() < bookArray[leastPages].getPageCount()) {
                leastPages = i;
            }

            if(bookArray[i].getTitle().length() > bookArray[longestTitle].getTitle().length()) {
                longestTitle = i;
            }
        }

        //display shortest pages and longest title
        System.out.println("\nThe book with the least pages is:");
        System.out.println(bookArray[leastPages].getTitle() + " by " + bookArray[leastPages].getAuthor());

        System.out.println("\nThe book with the longest title is:");
        System.out.println(bookArray[longestTitle].getTitle() + " by " + bookArray[longestTitle].getAuthor());


        //start library section of problem
        Library library = new Library(50);

        //transfer books from bookArray into a Library
        for(Book book : bookArray){
            library.addBook(book);
        }

        System.out.println("");
        System.out.println("+------------------------------------------------------------------+");
        System.out.println("|                        Books in Library                          |");
        System.out.println("+------------------------------------------------------------------+");
        System.out.printf("| %-32s| %-19s| %-10s|%n", "Title", "Author", "Page Count");
        System.out.println("+---------------------------------+--------------------+-----------+");
        for(int i = 0; i < library.getNumBooks(); i++) {
            System.out.printf("| %-32s| %-19s| %-10d|%n", library.getBookAtIndex(i).getTitle(), library.getBookAtIndex(i).getAuthor(), library.getBookAtIndex(i).getPageCount());
        }
        System.out.println("+------------------------------------------------------------------+");

        //loop to find shortest pages and longest title
        leastPages = 0;
        longestTitle = 0;
        for(int i = 0; i < library.getNumBooks() - 1; i++) {
            if(library.getBookAtIndex(i).getPageCount() < library.getBookAtIndex(leastPages).getPageCount()) {
                leastPages = i;
            }

            if(library.getBookAtIndex(i).getTitle().length() > library.getBookAtIndex(longestTitle).getTitle().length()) {
                longestTitle = i;
            }
        }

        //display shortest pages and longest title
        System.out.println("\nThe book with the least pages is:");
        System.out.println(library.getBookAtIndex(leastPages).getTitle() + " by " + library.getBookAtIndex(leastPages).getAuthor());

        System.out.println("\nThe book with the longest title is:");
        System.out.println(library.getBookAtIndex(longestTitle).getTitle() + " by " + library.getBookAtIndex(longestTitle).getAuthor());

    }
}


class Book {
    private String title;
    private String author;
    private int pageCount;


    public Book(String title, String author, int pageCount) {
        this.title = title;
        this.author = author;
        this.pageCount = pageCount;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPageCount() {
        return pageCount;
    }

}   

class Library {
    private Book[] books;
    private int numBooks;

    public Library(int maxNumBooks) {
        this.books = new Book[maxNumBooks];
        numBooks = 0;
    }

    public int getNumBooks() {
        return numBooks;
    }

    public Book getBookAtIndex(int index) {
        return this.books[index];
    }

    //add a book to the library and increment the bumber of books counter
    public void addBook(Book bookToAdd) {
        books[numBooks] = bookToAdd;
        numBooks++;
    }
}