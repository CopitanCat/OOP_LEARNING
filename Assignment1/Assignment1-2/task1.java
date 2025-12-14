import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int temperature = in.nextInt();
        if(temperature>= 0 ){
            System.out.println("It's worm outside");
        }
        else if (temperature<0) {
            System.out.println("It's cold outside");
        }
        in.close();
    }
}