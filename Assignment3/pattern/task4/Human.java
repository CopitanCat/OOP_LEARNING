public class Human extends Creature{
    public Human(MoveLogic moveLogic, SoundLogic soundLogic){
        super(moveLogic, soundLogic);
    }

    @Override
    public String getName() {
        return "Human";
    }

    @Override
    public void howDolSound(String getName) {
        super.howDolSound(getName);
    }

    @Override
    public void howDolMove(String getName) {
        super.howDolMove(getName);
    }

    public void searchingMeaningOfLife(String getName){
        System.out.println(getName + " search meaning of life");
    }
}
