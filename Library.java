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
    public void viewBooks()
    {
        for(Book b : books )
        {
            b.viewBook();
        }
    }


    //add new user
    public void addUser(User user)
    {
        users.add(user);
        System.out.println("Registered new user.");

    }


    private Book findBook(int id)
    {
        for (Book b : books)
        {
            if(b.getId() == id)
            {
                return b;
            }

        }
        return null;
    }

    private User findUser(int id)
    {
        for(User u : users)
        {
            if (u.getId()==id)
            {
                return u;
            }
        }
        return null;
    }


    //giving book (issue)

    public void issueBook(int bookId , int userId , LocalDate issueDate)
    {
        Book b = findBook(bookId);
        User u = findUser(userId);

        if (b==null || u==null)
        {
            System.out.println("Invalid user or book.");
            return;

        }

        if(b.isIssued())
        {
            System.out.println("Book is already issued.");
            return;
        }

        b.setIssued(true);

        //add into the transactions record
        transactions.add(new Transaction(b , u , issueDate));
        System.out.println("Book issued.");

    }

    

    

}
