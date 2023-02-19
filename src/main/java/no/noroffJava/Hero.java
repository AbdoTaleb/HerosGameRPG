package no.noroffJava;

import java.util.HashMap;
import java.util.HashSet;


public abstract class Hero {

    private Weapon heroWeapon;

    String name;
    int level;
    HeroAttribute totalAttributes = new HeroAttribute(0, 0, 0);
    HeroAttribute levelAttributes = new HeroAttribute(0, 0, 0);
    HashMap<Item.Slot, String> Equipment = new HashMap<>();

    protected HashSet<Weapon.WeaponType> validWeapons = new HashSet<>();
    protected HashSet<Armor.ArmorType> validArmor = new HashSet<>();

    /**
     * Function to increase the hero level by 1, and increase the level attribute.
     */
    abstract void levelUp();

    /**
     * Function to equip weapon and throws exception if something went wrong.
     */
    public void equip(Weapon weapon) throws InvalidWeaponException{
        if(this.validWeapons.contains(weapon.weaponType) && this.level >= weapon.getRequiredLevel()) {
            if (this.Equipment.get(Item.Slot.Weapon) == null) {
                this.Equipment.put(Item.Slot.Weapon, weapon.getName());
            } else {
                this.Equipment.replace(Item.Slot.Weapon, weapon.getName());
            }
            weapon.setWeaponDamage(weapon.getWeaponDamage());
            this.setHeroWeapon(weapon);
        }else {
            if(!this.getValidWeapons().contains(weapon.weaponType)){
                throw new InvalidWeaponException("Invalid weapon type for our hero " + this.getName());
            }
            if(this.getLevel() < weapon.getRequiredLevel()){
                throw new InvalidWeaponException("Can't equip this weapon because low level of our hero " + this.getName());
            }
        }
    }

    /**
     * Function to equip armor and throws exception if something went wrong.
     */
    public void equip(Armor armor) throws InvalidArmorException{
        if(this.getValidArmor().contains(armor.armorType) && this.getLevel() >= armor.getRequiredLevel()){
            if(this.Equipment.get(armor.slot) == null) {
                this.Equipment.put(armor.slot, String.valueOf(armor.armorType));

            }else{
                this.Equipment.replace(armor.slot, String.valueOf(armor.armorType));
            }
            this.totalAttributes = this.totalAttributes.addLevelAttributes(this.totalAttributes, armor.armorAttribute);
        }
        else {
            if(!this.getValidArmor().contains(armor.armorType)){
                throw new InvalidArmorException("Invalid armor type for our hero " + this.getName());
            }
            if(this.getLevel() < armor.getRequiredLevel()){
                throw new InvalidArmorException("Can't equip this armor because low level of our hero " + this.getName());
            }

        }
    }


    /**
     * Abstract Function to calculate the hero damage.
     */
    abstract double heroDamage();


    public void setValidWeapons(Weapon.WeaponType validWeapons) {
        this.validWeapons.add(validWeapons);
    }

    public void setValidArmor(Armor.ArmorType validArmor) {
        this.validArmor.add(validArmor);
    }

    public HashSet<Armor.ArmorType> getValidArmor() {
        return validArmor;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }


    public Weapon getHeroWeapon() {
        return heroWeapon;
    }

    public void setHeroWeapon(Weapon heroWeapon) {
        this.heroWeapon = heroWeapon;
    }

    public HashSet<Weapon.WeaponType> getValidWeapons() {
        return validWeapons;
    }


    /**
     * Function to display information about the hero.
     */
    public StringBuilder display(){
        StringBuilder heroInfo = new StringBuilder();
        heroInfo.append("Hero Name: ").append(this.getName()).append("\n").append("Hero Class: ").
                append(this.getClass().getSimpleName()).append("\n").append("Hero Level: ").append(this.getLevel()).
                append("\n").append("Hero Strength: ").append(this.totalAttributes.getStrength()).append("\n").
                append("Hero Dexterity: ").append(this.totalAttributes.getDexterity()).append("\n").append("Hero Intelligence: ").
                append(this.totalAttributes.getIntelligence()).append("\n").append("Hero Damage: ").append(this.heroDamage());
        return heroInfo;
    }


}
