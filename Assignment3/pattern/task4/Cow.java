public class Cow extends Creature{
    public Cow(MoveLogic moveLogic, SoundLogic soundLogic) {
        super(moveLogic, soundLogic);
    }

    @Override
    public String getName() {
        return "Cow";
    }

    @Override
    public void howDolSound(String getName) {
        super.howDolSound(getName);
    }

    @Override
    public void howDolMove(String getName) {
        super.howDolMove(getName);
    }

    public void getMilk(String getName){
        System.out.println(getName + " giving milk");
    }
}
