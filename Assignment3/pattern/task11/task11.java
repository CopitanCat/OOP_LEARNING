public class task11 {
    public static void main(String[] args) {
        Entity entity = new LazyInitializer(10001);
        System.out.println(entity.getId());
        System.out.println(entity.find("John"));
    }
}
