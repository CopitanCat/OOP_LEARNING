import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Bowling {

    private final Queue<Track> tracks;
    private final Queue<PairOfShoes> shoesShelf;

    public Bowling(int tracksNumber) {
        tracks = new ArrayDeque<>();
        shoesShelf = new ArrayDeque<>();

        // заполняем дорожки
        for (int i = 1; i <= tracksNumber; i++) {
            tracks.add(new Track(i));
        }

        // заполняем обувь (50 пар, размеры 38–45)
        for (int i = 0; i < 50; i++) {
            int size = 38 + (i % 8);
            shoesShelf.add(new PairOfShoes(size));
        }
    }

    public synchronized Track acquireTrack() {
        if (tracks.isEmpty()) {
            return null;
        }

        Track track = tracks.poll();
        track.setPrice(100 - tracks.size() * 10);
        return track;
    }

    public synchronized void releaseTrack(Track track) {
        System.out.printf("C дорожки №%d сняли бронь\n", track.getNumber());
        tracks.offer(track);
    }

    public synchronized Set<PairOfShoes> acquireShoes(int number) {
        if (shoesShelf.size() < number) {
            return null;
        }

        Set<PairOfShoes> shoes = new HashSet<>();
        for (int i = 0; i < number; i++) {
            shoes.add(shoesShelf.poll());
        }
        return shoes;
    }

    public synchronized void releaseShoes(Set<PairOfShoes> shoes) {
        System.out.printf("В гардероб вернули %d пар обуви\n", shoes.size());
        shoesShelf.addAll(shoes);
    }
}
