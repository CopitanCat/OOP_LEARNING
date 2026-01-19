public class task6 {
    public static void main(String[] args) {
        Universe universe = Universe.getInstance();
        Universe anotherUniverse = Universe.getInstance();

        System.out.println(universe);
        System.out.println(anotherUniverse);
    }
}
