package no.noroffJava;

public class Warrior extends Hero{

    public Warrior(String name) {

        this.name = name;
        this.level = 1;
        this.LevelAttribtues.setStrength(5);
        this.LevelAttribtues.setDexterity(2);
        this.LevelAttribtues.setIntelligence(1);

        this.setValidWeapons(Weapon.WeaponType.Axes);
        this.setValidWeapons(Weapon.WeaponType.Hammers);
        this.setValidWeapons(Weapon.WeaponType.Swords);
        this.setValidArmor(Armor.ArmorType.Mail);
        this.setValidArmor(Armor.ArmorType.Plate);

        this.Equipment.put(Item.Slot.Weapon, null);
        this.Equipment.put(Item.Slot.Head, null);
        this.Equipment.put(Item.Slot.Body, null);
        this.Equipment.put(Item.Slot.Legs, null);

    }

    @Override
    void LevelUp() {
        this.level++;
        HeroAttribute WarriorAttribute = new HeroAttribute(3, 2, 1);
        this.LevelAttribtues = this.LevelAttribtues.addLevelAttribtues(this.LevelAttribtues, WarriorAttribute);
    }

    @Override
    void equip(Weapon weapon) {

    }

    @Override
    void equip(Armor armor) {

    }
}
