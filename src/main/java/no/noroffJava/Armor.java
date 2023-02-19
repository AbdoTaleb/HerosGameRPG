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

    // Use this function in testing to check if to instance of Weapon are equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Armor that = (Armor) o;
        return this.getName() == that.getName() && this.armorType == that.armorType && this.getRequiredLevel() == that.getRequiredLevel() &&
                this.slot == that.slot && this.armorAttribute == that.armorAttribute;
    }
}
