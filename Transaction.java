import java.time.LocalDate;
import java.io.Serializable;


public class Transaction implements Serializable{
    private Book book;
    private User user;
    private LocalDate issueDate;
    private LocalDate dueDate;

    public Transaction(Book book , User user , LocalDate issueDate)
    {
        this.book=book;
        this.user=user;
        this.issueDate=issueDate;
        this.dueDate=issueDate.plusDays(7);

    }

    public Book getBook()
    {
        return book;
    }

    public User getUser()
    {
        return user;
    }

    public LocalDate getIssueDate()
    {
        return issueDate;
    }

    public LocalDate getDueDate()
    {
        return dueDate;
    }

    
}
