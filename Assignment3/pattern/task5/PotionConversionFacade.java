public class PotionConversionFacade {
    public String covertPotion(String PotionName, String convertTo){
        System.out.println("Facade Code: conversion started.");
        Potion potion = new Potion(PotionName);
        Type type = Type.valueOf(convertTo.toUpperCase());
        Essence sourceEssence = EssenceFactory.extract(potion);
        Essence destinationEssence;
        if (type == Type.MANA) {
            destinationEssence = new ManaEssenceConverter();
        } else if (type == Type.STAMINA) {
            destinationEssence = new StaminaEssenceConverter();
        } else {
            destinationEssence = new HealingEssenceConverter();
        }
        Potion portion = Extractor.extractPortion(potion, sourceEssence);
        Potion intermediateResult = Extractor.convert(portion, destinationEssence);
        Potion result = new Finalizator().fix(intermediateResult);
        System.out.println("Facade Code: conversion completed.");
        return result.getName();
    }
}
