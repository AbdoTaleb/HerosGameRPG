package no.noroffJava;

public class Warrior extends Hero{

    public Warrior(String name) {

        this.name = name;
        this.level = 1;
        this.levelAttributes.setStrength(5);
        this.levelAttributes.setDexterity(2);
        this.levelAttributes.setIntelligence(1);

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
    void levelUp() {
        this.level++;
        HeroAttribute WarriorAttribute = new HeroAttribute(3, 2, 1);
        this.levelAttributes = this.levelAttributes.addLevelAttributes(this.levelAttributes, WarriorAttribute);
    }

    @Override
    double heroDamage() {
        double heroDamage;
        if(this.Equipment.get(Item.Slot.valueOf("Weapon")) == null){
            heroDamage = (1 + this.totalAttributes.getIntelligence() / 100);
        }else {
            heroDamage = this.getHeroWeapon().getWeaponDamage() * (1 + ((double)this.totalAttributes.getStrength() / 100));

        }
        return heroDamage;
    }


}
