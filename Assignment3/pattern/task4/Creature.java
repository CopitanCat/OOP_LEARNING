public abstract class Creature {
    protected MoveLogic moveLogic;
    protected SoundLogic soundLogic;

    public Creature(MoveLogic moveLogic, SoundLogic soundLogic){
        this.moveLogic = moveLogic;
        this.soundLogic = soundLogic;
    }

    public abstract  String getName();
    public void howDolMove(String getName){
        moveLogic.move(getName);
    }
    public void howDolSound(String getName){
        soundLogic.sound(getName);
    }

}
