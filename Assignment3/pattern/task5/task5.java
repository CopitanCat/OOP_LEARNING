public class task5 {
    public static String potionName = "Minor Healing Potion";
    public static String type = "stamina";

    public static void main(String[] args) {
        PotionConversionFacade HealingPotionConvert = new PotionConversionFacade();
        System.out.println(HealingPotionConvert.covertPotion(potionName, type));
    }
}
