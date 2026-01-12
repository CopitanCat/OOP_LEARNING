public class Skyscraper_t3 {
    private int flourCount;
    private String Devloper;

    public Skyscraper_t3(){
        this.flourCount = 5;
        this.Devloper = "JavaRushDevloper";
    }
    public Skyscraper_t3(int flourCount, String Devloper){
        this.flourCount = flourCount;
        this.Devloper = Devloper;
    }

    public static void main(String[] args) {
        Skyscraper_t3 skyscraper = new Skyscraper_t3();
        Skyscraper_t3 skyscraperUnknown = new Skyscraper_t3(50, "Unknown");
    }

}