public class Hedgehog {
    public void eat(Apple apple) {
        System.out.println("The apple has been eaten!");
    }
    public static void main(String[] args) {
        Hedgehog hedgehog = new Hedgehog();
        Apple apple = new Apple();
        hedgehog.eat(apple);
    }
    public static class Apple {

    }
}
