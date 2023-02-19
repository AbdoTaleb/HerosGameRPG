package no.noroffJava;

public class Rogue extends Hero{

    public Rogue(String name) {

        this.name = name;
        this.level = 1;
        this.levelAttributes.setStrength(2);
        this.levelAttributes.setDexterity(6);
        this.levelAttributes.setIntelligence(1);

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
    void levelUp() {
        this.level++;
        HeroAttribute RogueAttribute = new HeroAttribute(1, 4, 1);
        this.levelAttributes = this.levelAttributes.addLevelAttributes(this.levelAttributes, RogueAttribute);
    }



    @Override
    double heroDamage() {
        double heroDamage;
        if(this.Equipment.get(Item.Slot.valueOf("Weapon")) == null){
            heroDamage = (1 + this.totalAttributes.getIntelligence() / 100);
        }else {
            heroDamage = this.getHeroWeapon().getWeaponDamage() * (1 + ((double)this.totalAttributes.getDexterity() / 100));

        }
        return heroDamage;
    }

}
