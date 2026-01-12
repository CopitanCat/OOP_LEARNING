public class task5 {
    public static void main(String[] args) throws Exception {
    }

    public interface Drinker {
        void askForMore(String message);
        void sayThankYou();
        boolean isReadyToGoHome();
    }

    public interface Alcoholic extends Drinker {
        boolean READY_TO_GO_HOME = false;
        void sleepOnTheFloor();
    }

    public static class BeerLover implements Alcoholic {
        public void askForMore(String message) {
            System.out.println(message);
        }
        public void sayThankYou() {
            System.out.println("Thank you!");
        }
        public boolean isReadyToGoHome() {
            return READY_TO_GO_HOME;
        }
        public void sleepOnTheFloor() {
            System.out.println("Sleeping on the floor...");
        }
    }
}

