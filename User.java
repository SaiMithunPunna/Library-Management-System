public class User {
    private String name;
    private int id;
    private String contact;

    public User(int id , String name , String contact)
    {
        this.id=id;
        this.name=name;
        this.contact=contact;

    }
    public int getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public String getContact()
    {
        return contact;
    }
    
}
