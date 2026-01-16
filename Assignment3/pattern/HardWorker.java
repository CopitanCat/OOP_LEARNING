import java.util.Set;

public class HardWorker {
    private final String name;
    private Set<Nails> nails;
    private Hammer hammer;

    public HardWorker(String name, Set<Nails> nails, Hammer hammer) {
        this.name = name;
        this.nails = nails;
        this.hammer = hammer;
    }

    public void hammerAllNails() {
        for (Nails nail : nails) {
            boolean hammered = false;
            while (!hammered) {
                hammered = hammer.hit(nail);
            }
        }
        System.out.println(name + " done!");
    }
}