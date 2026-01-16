public class Hammer {
    public boolean hit(Nails nail) {
        if (nail.visiblePart > 0) {
            nail.visiblePart--;
        }
        return nail.visiblePart == 0;
    }
}