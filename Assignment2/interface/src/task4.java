public class task4 {
    public interface CanRun {
        void run();
    }

    public interface CanSwim {
        void swim();
    }

    public static abstract class Human implements CanRun, CanSwim {
    }
}
