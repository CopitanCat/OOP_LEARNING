package task1;

public class MicroscopeAdapter extends Hammer {
    private Microscope microscope;

    public MicroscopeAdapter(Microscope microscope){
        this.microscope = microscope;
    }

    @Override
    public boolean hit(Nails nail) {
        microscope.bang();
        return false;
    }
}
