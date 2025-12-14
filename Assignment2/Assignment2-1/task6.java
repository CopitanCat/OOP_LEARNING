public class task6 {
    public static void main(String[] args) {
        universalMethod();
        universalMethod(1);
        universalMethod(1.1);
        universalMethod(1.11);
        universalMethod(1);
        universalMethod(1,2);
        universalMethod(1,"2");
        universalMethod("its", "concatenation");
        universalMethod(1,2,3);

    }
    public static void universalMethod()
    {
        System.out.println("this is universal method");
    }
    public static void universalMethod(int i)
    {
        System.out.println(i);
    }
    public static void universalMethod(int i , int j)
    {
        System.out.println(i+j);
    }
    public static void universalMethod(int i , String j)
    {
        System.out.println(j+i);
    }
    public static void universalMethod(String a, String b){
        System.out.println(a+b);
    }
    public static void universalMethod(Float a)
    {
        System.out.println(a);
    }
    public static void universalMethod(double b)
    {
        System.out.println(b);
    }
    public static void universalMethod(boolean a){
        if (a)
        {
            System.out.println("True");
        }
        else {
            System.out.println("False");
        }
    }
    public static void universalMethod(int a, int b , int c)
    {
        if(a>b && a>c) System.out.println(a);
        else if (b>a && b>c) System.out.println(b);
        else System.out.println(c);
    }
}
