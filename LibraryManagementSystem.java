import java.util.Scanner;

public class LibraryManagementSystem
{

    public static void main(String [] args)
    {
        Scanner sc= new Scanner( System.in);
        Library library= new Library();
        System.out.println("\n\n-----  Library Management System  -----");

        while(True)
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

            

        }
    }
}