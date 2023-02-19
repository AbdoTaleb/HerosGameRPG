package no.noroffJava;

public class Armor extends Item{


    HeroAttribute armorAttribute;
    ArmorType armorType;

    Item.Slot slot;
    public Armor(String name, int requiredLevel, String slot, String armorType, HeroAttribute armorAttribute){
        this.setName(name);
        this.setRequiredLevel(requiredLevel);
        this.slot = Slot.valueOf(slot);
        this.armorType = ArmorType.valueOf(armorType);
        this.armorAttribute = armorAttribute;
    }


    enum ArmorType{
        Cloth,
        Leather,
        Mail,
        Plate

    }
}
