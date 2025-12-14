import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int age  = in.nextInt();
        if (age >60 || age < 20)
        {
            System.out.println("you don’t have to work.");
        }
        in.close();
    }
}
