import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int BodyTemp = in.nextInt();
        final int isHigh = 38;
        final int isLow= 34;
        if (BodyTemp<isHigh && BodyTemp>isLow)
        {
            System.out.println("temperature is normal");
        }
        else if (BodyTemp>=isHigh) {
            System.out.println("temperature is high");
        }
        else
        {
            System.out.println("temperature is low");
        }
        in.close();
    }
}
