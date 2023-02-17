package no.noroffJava;

public class Rogue extends Hero{

    public Rogue(String name) {

        this.name = name;
        this.level = 1;
        this.LevelAttribtues.setStrength(1);
        this.LevelAttribtues.setDexterity(7);
        this.LevelAttribtues.setIntelligence(1);

        this.setValidWeapons(Weapon.WeaponType.Daggers);
        this.setValidWeapons(Weapon.WeaponType.Swords);
        this.setValidArmor(Armor.ArmorType.Leather);
        this.setValidArmor(Armor.ArmorType.Mail);

        this.Equipment.put(Item.Slot.Weapon, null);
        this.Equipment.put(Item.Slot.Head, null);
        this.Equipment.put(Item.Slot.Body, null);
        this.Equipment.put(Item.Slot.Legs, null);

    }

    @Override
    void LevelUp() {
        this.level++;
        HeroAttribute RogueAttribute = new HeroAttribute(1, 4, 1);
        this.LevelAttribtues = this.LevelAttribtues.addLevelAttribtues(this.LevelAttribtues, RogueAttribute);
    }

    @Override
    void equip(Weapon weapon) {

    }

    @Override
    void equip(Armor armor) {

    }
}
