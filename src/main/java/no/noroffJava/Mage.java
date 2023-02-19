package no.noroffJava;

public class Mage extends Hero{

    public Mage(String name) {

        this.name = name;
        this.level = 1;
        this.levelAttributes.setStrength(1);
        this.levelAttributes.setDexterity(1);
        this.levelAttributes.setIntelligence(8);

        this.setValidWeapons(Weapon.WeaponType.Staffs);
        this.setValidWeapons(Weapon.WeaponType.Wands);
        this.setValidArmor(Armor.ArmorType.Cloth);

        this.Equipment.put(Item.Slot.Weapon, null);
        this.Equipment.put(Item.Slot.Head, null);
        this.Equipment.put(Item.Slot.Body, null);
        this.Equipment.put(Item.Slot.Legs, null);
        this.totalAttributes = this.levelAttributes;

    }
    @Override
    void levelUp() {
        this.level++;
        HeroAttribute MageAttribute = new HeroAttribute(1, 1, 5);
        this.levelAttributes = this.levelAttributes.addLevelAttributes(this.levelAttributes, MageAttribute);
        this.totalAttributes = this.levelAttributes.addLevelAttributes(this.totalAttributes, MageAttribute);

    }


    @Override
    double heroDamage() {
        double heroDamage;
        if(this.Equipment.get(Item.Slot.valueOf("Weapon")) == null){
            heroDamage = 1 + this.totalAttributes.getIntelligence() / 100;
        }else {
            heroDamage = this.getHeroWeapon().getWeaponDamage() * (1 + ((double)this.totalAttributes.getIntelligence() / 100));

        }
        return heroDamage;
    }


}