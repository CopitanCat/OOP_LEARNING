public class LazyInitializer implements Entity{
    private int id;
    private VeryHeavyEntity entity;

    LazyInitializer(int id){
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String find(String query) {
        if (this.entity == null){
            this.entity = new VeryHeavyEntity(this.id);
        }
        return entity.find(query);
    }
}
