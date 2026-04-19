import java.time.LocalDate;
import java.util.Scanner;

public class LibraryManagementSystem
{

    public static void main(String [] args)
    {
        Scanner sc= new Scanner( System.in);
        Library library= new Library();
        System.out.println("\n\n-----  Library Management System  -----");

        while(true)
        {
            System.out.println("\n\t\tLibrary Menu");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Register new User");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Search Book");
            System.out.println("7. Exit");
            System.out.print("Choose any option : ");
            int choice=sc.nextInt();

            switch(choice)
            {
                case 1:
                    System.out.print("\nEnter book id : ");
                    int bid=sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter title of book : ");
                    String title=sc.nextLine();
                    System.out.print("Enter author of book : ");
                    String author=sc.nextLine();

                    library.addBook(new Book(bid , title , author));
                    break;


                case 2:
                    library.viewBooks();
                    break;

                case 3:
                    System.out.print("Enter user id : ");
                    int uid=sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter contact of user : ");
                    String contact=sc.nextLine();
                    library.addUser(new User(uid, name , contact));
                    break;
                
                case 4:
                    System.out.print("Enter Book ID: ");
                    int bId = sc.nextInt();
                    System.out.print("Enter User ID: ");
                    int uId = sc.nextInt();
                    System.out.println("Enter the issue date for book(yyyy-mm-dd) : ");
                    String dateString=sc.nextLine();
                    LocalDate idate=  LocalDate.parse(dateString);
                    library.issueBook(bId, uId , idate);
                    break;
                

                case 5:
                    System.out.print("Enter book id : ");
                    int rId = sc.nextInt();
                    library.returnBook(rId);
                    break;
                
                case 6:
                    sc.nextLine();
                    System.out.print("Enter keyword(title or author): ");
                    String keyword = sc.nextLine();
                    library.searchBook(keyword);
                    break;

                case 7:
                    System.out.println("Exiting ...");
                    return;

                default:
                    System.out.println("Please enter valid choice.");
            }


        }
    }
}