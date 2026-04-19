import java.time.LocalDate;
import java.util.*;

public class Library {
    
    private List<Book> books=new ArrayList<> ();
    private List<User> users= new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();


    //adding new book
    public void addBook(Book book)
    {
        books.add(book);
        System.out.println("Book added.");


    }

    

}
