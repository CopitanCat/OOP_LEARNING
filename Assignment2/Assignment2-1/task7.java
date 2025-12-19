import java.util.Scanner;

public class task7 {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String username = in.next();
        signIn(username);

    }
    public static void signIn(String user)
    {
        if (user.equals("user"))
        {
            return;
        }
        else
        {
            System.out.println("Welcome " + user);
            System.out.println("Missed you very much, " + user);
        }
    }
}
