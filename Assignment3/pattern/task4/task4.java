public class task4 {
    public static void main(String[] args) {
        Cow FlyingBarkingcow = new Cow(new Fly() , new Bark());

        FlyingBarkingcow.howDolMove(FlyingBarkingcow.getName());
        FlyingBarkingcow.howDolSound(FlyingBarkingcow.getName());
        FlyingBarkingcow.getMilk(FlyingBarkingcow.getName());
        //-----------------//
        Cat CrawlingMeowingCat= new Cat(new Crawl(), new Meow());

        CrawlingMeowingCat.howDolMove(CrawlingMeowingCat.getName());
        CrawlingMeowingCat.howDolSound(CrawlingMeowingCat.getName());
        CrawlingMeowingCat.catchMice(CrawlingMeowingCat.getName());
        //----------------------------------------------------------------//
        Human SwimmingSpeakingHuman = new Human(new Swimming(), new Speak());

        SwimmingSpeakingHuman.howDolMove(SwimmingSpeakingHuman.getName());
        SwimmingSpeakingHuman.howDolSound(SwimmingSpeakingHuman.getName());
        SwimmingSpeakingHuman.searchingMeaningOfLife(SwimmingSpeakingHuman.getName());
        //-------------------------------------------------------------------------//
    }
}
