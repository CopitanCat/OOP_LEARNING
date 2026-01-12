public class Skyscraper_t2 {
    public static final String SKYSCRAPER_WAS_BUILD = "Skyscraper is built.";
    public static final String SKYSCRAPER_WAS_BUILD_FLOORS_COUNT = "Skyscraper is built. The number of floors - ";
    public static final String SKYSCRAPER_WAS_BUILD_DEVELOPER = "Skyscraper is built. Developer - ";
    public Skyscraper_t2(){
            System.out.println(SKYSCRAPER_WAS_BUILD);
        }
    public Skyscraper_t2(int count) {
        System.out.println(SKYSCRAPER_WAS_BUILD_FLOORS_COUNT + count);
    }
    public Skyscraper_t2(String dev) {
        System.out.println(SKYSCRAPER_WAS_BUILD_DEVELOPER + dev);
    }

    public static void main(String[] args) {
            Skyscraper_t2 skyscraper = new Skyscraper_t2();
            Skyscraper_t2 skyscraperTower = new Skyscraper_t2(50);
            Skyscraper_t2 skyscraperSkyline = new Skyscraper_t2("JavaRushDevelopment");
        }
    }
