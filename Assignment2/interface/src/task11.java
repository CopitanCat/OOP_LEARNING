public class task11 {
    public static void main(String[] args) {
    }
    //can move
    public interface Movable {
        void move();
    }
    //can be eaten
    public interface Edible {
        void beEaten();
    }
    // might eat someone
    public interface Eat {
        void eat();
    }
    class Cat implements Eat, Movable, Edible{
        @Override
        public void eat() {
        }
        @Override
        public void beEaten() {
        }
        @Override
        public void move() {
        }
    }
    class Mouse implements Edible, Movable{
        @Override
        public void beEaten() {
        }
        @Override
        public void move() {

        }
    }
    class Dog implements Eat, Movable{
        @Override
        public void move() {
        }
        @Override
        public void eat() {
        }
    }
}
