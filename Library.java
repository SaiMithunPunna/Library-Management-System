import java.time.LocalDate;
import java.util.*;
import java.io.*;

public class Library implements Serializable{
    
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
            System.out.println(b.viewBook());
        }
    }2


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

    //returnin book

    public void returnBook(int bookId)
    {
        for(Transaction t : transactions)
        {
            if(t.getBook().getId()==bookId)
            {
                Book b=t.getBook();
                b.setIssued(false);

                LocalDate today=LocalDate.now();
                if(today.isAfter(t.getDueDate()))
                {
                    long noDaysLate = today.toEpochDay() - t.getDueDate().toEpochDay();
                    double fine= noDaysLate*10;
                    //10 rs for each day  as fine for late return

                    System.out.println("Due to late return , ₹"+fine+" fee applied.");
                }
                else
                {
                    System.out.println("Returned book on time.");

                }
                transactions.remove(t);
                return ;
            }
        }
        System.out.println("Transaction record of this book is not found.");
        return;
    }


    //searching book
    public void searchBook(String keyword) {
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                b.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(b.viewBook());
            }
        }
    }

    //save the data of users and books , transactions

    public void saveLibraryData()
    {
        try(ObjectOutputStream out= new ObjectOutputStream(new FileOutputStream(("library_data.ser"))))
        {
            out.writeObject(books); //coberting books obj into binary(serialization)
            out.writeObject(users);
            out.writeObject(transactions);

            System.out.println("Library data saved.");

        }
        catch(IOException e)
        {
            System.out.println("IO exception occured");
        }

    }
    
    //load the existing library data

    @SuppressWarnings("unchecked") //type casting errors

    public void loadLibraryData()
    {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("library_data.ser")))
        {
            books=(List<Book>) in.readObject();  //converting back to Book objects
            users=(List<User>) in.readObject();
            transactions=(List<Transaction>) in.readObject();

            System.out.println("Library data loaded.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }


}
