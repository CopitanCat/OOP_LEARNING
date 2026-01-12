public class Solution_t14 {
    public static void showWeather(City_t14 city) {
        System.out.println("in the city: " + city.getName() + " temperature in the city: " + city.getTemperature() );
    }
    public static void main(String[]
                                    args) {
        City_t14 city = new City_t14("Dubai", 40);
        showWeather(city);
    }
}
