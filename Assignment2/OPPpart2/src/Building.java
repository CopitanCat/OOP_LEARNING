public class Building {
    private String type;

    public Building(String type){
        this.type = type;
    }
    public void initialize(String type){
        this.type = type;
    }

    public static void main(){
        Building building = new Building("Restaurant");
        building.initialize("Barbershop");
    }
}
