import java.util.Scanner;

public class task8 {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        long a = in.nextInt();
        System.out.println(cube(a));
    }
    public static long cube(long i)
    {
        return i*i*i;
    }
}
