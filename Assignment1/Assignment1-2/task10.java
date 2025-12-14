import java.util.Scanner;

public class task10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int start = in.nextInt();
        int end = in.nextInt();
        int multiple = in.nextInt();
        int sum = 0;

        for(;start<end; start++)
        {
            if (start%multiple!=0) {
                continue;
            }
            sum += start;
        }
        System.out.println(sum);
        in.close();
    }
}
