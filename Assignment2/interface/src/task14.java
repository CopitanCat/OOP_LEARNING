public class task14 {
    public static void main(String[] args) {
        System.out.println(Dream.HOBBY.toString()); // increments and prints INDEX
        System.out.println(new Hobby().INDEX);      // prints current INDEX
    }

    interface Desire {
    }

    interface Dream {
        Hobby HOBBY = new Hobby();
    }

    static class Hobby implements Desire, Dream {
        static int INDEX = 1;

        @Override
        public String toString() {
            INDEX++;
            return "" + INDEX;
        }
    }
}
