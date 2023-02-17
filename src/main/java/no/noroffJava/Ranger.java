package no.noroffJava;

public class Ranger extends Hero{

    public Ranger(String name) {

        this.name = name;
        this.level = 1;
        this.LevelAttribtues.setStrength(2);
        this.LevelAttribtues.setDexterity(6);
        this.LevelAttribtues.setIntelligence(1);

        this.setValidWeapons(Weapon.WeaponType.Bows);
        this.setValidArmor(Armor.ArmorType.Mail);
        this.setValidArmor(Armor.ArmorType.Leather);

        this.Equipment.put(Item.Slot.Weapon, null);
        this.Equipment.put(Item.Slot.Head, null);
        this.Equipment.put(Item.Slot.Body, null);
        this.Equipment.put(Item.Slot.Legs, null);

    }
    @Override
    void LevelUp() {
        this.level++;
        HeroAttribute RangerAttribute = new HeroAttribute(1, 5, 1);
        this.LevelAttribtues =  this.LevelAttribtues.addLevelAttribtues(this.LevelAttribtues, RangerAttribute);

    }

    @Override
    void equip(Weapon weapon) {

    }

    @Override
    void equip(Armor armor) {

    }
}
