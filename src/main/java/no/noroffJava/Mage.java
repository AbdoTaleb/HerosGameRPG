package no.noroffJava;

import java.util.HashMap;

public class Mage extends Hero{
    public Mage(String name) {

        this.name = name;
        this.level = 1;
        this.LevelAttribtues.setStrength(1);
        this.LevelAttribtues.setDexterity(1);
        this.LevelAttribtues.setIntelligence(8);

        this.setValidWeapons(Weapon.WeaponType.Staffs);
        this.setValidWeapons(Weapon.WeaponType.Wands);
        this.setValidArmor(Armor.ArmorType.Cloth);

        this.Equipment.put(Item.Slot.Weapon, null);
        this.Equipment.put(Item.Slot.Head, null);
        this.Equipment.put(Item.Slot.Body, null);
        this.Equipment.put(Item.Slot.Legs, null);

    }
    @Override
    void LevelUp() {
        this.level++;
        HeroAttribute MageAttribute = new HeroAttribute(1, 1, 5);
        this.LevelAttribtues = this.LevelAttribtues.addLevelAttribtues(this.LevelAttribtues, MageAttribute);
//        this.LevelAttribtues.setStrength(this.LevelAttribtues.getStrength() + 1);
//        this.LevelAttribtues.setDexterity(this.LevelAttribtues.getDexterity() + 1);
//        this.LevelAttribtues.setIntelligence(this.LevelAttribtues.getIntelligence() + 5);

    }

    @Override
    void equip(Weapon weapon) {
        if(this.validWeapons.contains(weapon.weaponType) && this.level >= weapon.getRequiredLevel()) {
            if (this.Equipment.get(Item.Slot.Weapon) == null) {
                System.out.println("from put");
                this.Equipment.put(Item.Slot.Weapon, weapon.getName());
            } else {
                System.out.println("from replace");
                this.Equipment.replace(Item.Slot.Weapon, weapon.getName());
            }
        }else {
            System.out.println("not right weapon");
        }
    }

    @Override
    void equip(Armor armor) throws InvalidArmorException {
        System.out.println("here in equip");

            if(this.getValidArmor().contains(armor.armorType) && this.getLevel() >= armor.getRequiredLevel()){
                System.out.println("---> " + this.level);
                if(this.Equipment.get(armor.slot) == null) {
                    this.Equipment.put(armor.slot, String.valueOf(armor.armorType));
                }else{
                    System.out.println("here in else");
                    this.Equipment.replace(armor.slot, String.valueOf(armor.armorType));
                }
            }
            else {
                if(this.getValidArmor().contains(armor.armorType) == false){
                    throw new InvalidArmorException("Invalid armor type for our hero" + this.getName());
                }
                if(this.getLevel() < armor.getRequiredLevel()){
                    System.out.println("Can't equip this armor because low level of our hero ");
                    throw new InvalidArmorException("Can't equip this armor because low level of our hero " + this.getName());
                }

            }

    }

}