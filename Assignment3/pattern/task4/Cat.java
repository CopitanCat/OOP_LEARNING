public class Cat extends Creature{
    public Cat(MoveLogic moveLogic, SoundLogic soundLogic){
        super(moveLogic, soundLogic);
    }

    @Override
    public String getName() {
        return "Cat";
    }

    @Override
    public void howDolSound(String getName) {
        super.howDolSound(getName);
    }

    @Override
    public void howDolMove(String getName) {
        super.howDolMove(getName);
    }

    public void catchMice(String getName){
        System.out.println(getName + " catching mice");
    }
}
