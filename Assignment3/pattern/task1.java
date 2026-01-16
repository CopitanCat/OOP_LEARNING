import java. util.HashSet;
import java. util.Set;

public class task1 {
    public static void main(String[] args) {
        HardWorker worker1 = new HardWorker("Bob", getNailsPack(), new Hammer());
        HardWorker worker2 = new HardWorker("Bob Jr.", getNailsPack(), new MicroscopeAdapter(new Microscope()));

        worker1.hammerAllNails();
        worker2.hammerAllNails();
    }

    public static Set<Nails> getNailsPack() {
        Set<Nails> nailPack = new HashSet<>();
        for (int i = 0; i < 200; i++) {
            nailPack.add(new Nails());
        }
        return nailPack;
    }
}






