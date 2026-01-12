
public class Market {
    private static boolean hasEggs = true;


    public static void main(String[] args) {
        boolean hasEggs = false;
        makePurchases(hasEggs);
    }
    public static void makePurchases(boolean hasEggs) {
        if (Market.hasEggs) {
            System.out.println("Bought 10 batons");
        } else {
            System.out.println("Bought 1 loaf");
        }
    }
}