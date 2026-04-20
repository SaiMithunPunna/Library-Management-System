import java.io.Serializable;

public class Book implements Serializable
{
    private String title;
    private int id ;
    private String author;
    private boolean isIssued;

    public Book(int id ,String  title , String author )
    {
        this.title=title;
        this.id=id;
        this.author=author;
        this.isIssued=false;
    }
    public int getId()
    {
        return this.id;
    }
    public String getTitle()
    {
        return this.title;
    }
    public String getAuthor()
    {
        return author;
    }
    public void setIssued(boolean issued)
    {
        this.isIssued=issued;
    }
    public boolean isIssued()
    {
        return isIssued;
    }
    public String viewBook()
    {
        return id + " | " + title + " | " + author + " | Issued: " + isIssued;
    }
}