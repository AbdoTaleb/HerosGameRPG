package no.noroffJava;

public class Ranger extends Hero{

    public Ranger(String name) {

        this.name = name;
        this.level = 1;
        this.levelAttributes.setStrength(1);
        this.levelAttributes.setDexterity(7);
        this.levelAttributes.setIntelligence(1);

        this.setValidWeapons(Weapon.WeaponType.Bows);
        this.setValidArmor(Armor.ArmorType.Mail);
        this.setValidArmor(Armor.ArmorType.Leather);

        this.Equipment.put(Item.Slot.Weapon, null);
        this.Equipment.put(Item.Slot.Head, null);
        this.Equipment.put(Item.Slot.Body, null);
        this.Equipment.put(Item.Slot.Legs, null);

    }
    @Override
    void levelUp() {
        this.level++;
        HeroAttribute RangerAttribute = new HeroAttribute(1, 5, 1);
        this.levelAttributes =  this.levelAttributes.addLevelAttributes(this.levelAttributes, RangerAttribute);

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
