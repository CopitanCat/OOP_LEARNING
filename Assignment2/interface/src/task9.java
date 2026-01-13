public class task9 {
    public interface CanMove {
        Double speed();
    }

    public interface CanFly extends CanMove {
        Double speed(CanFly canFly);
    }
    public static void main(String[] args) throws Exception {
    }
}
