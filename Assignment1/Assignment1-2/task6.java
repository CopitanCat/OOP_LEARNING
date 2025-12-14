import java.util.Scanner;

public class task6 {
   public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String stopword = " ";
    int sum = 0;
    while(true) 
    {
        if (in.hasNextInt())
        {
            sum += in.nextInt();
        }   
        else
        {
            stopword = in.next();
            if (stopword.equalsIgnoreCase("ENTER"))
            {
                break;
            }
        }
    }
    System.out.println(sum);
    in.close();
   } 
}
