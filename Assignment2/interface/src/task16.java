import java.awt.Color;

public class task16 {
    public static void main(String[] args) throws Exception {
        Fox fox = new Fox();
        System.out.println(fox.getName()+' '+ fox.getAge());
    }

    public interface Animal {
        Color getColor();
        Integer getAge();
    }

    public static class Fox implements Animal {
        public String getName() {
            return "Fox.";
        }

        @Override
        public Color getColor() {
            return null;
        }

        @Override
        public Integer getAge() {
            return 0;
        }
    }
}
