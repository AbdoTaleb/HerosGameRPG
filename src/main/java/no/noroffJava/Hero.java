package no.noroffJava;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public abstract class Hero {
    String name;
    int level;

    HashMap<Item.Slot, String> Equipment = new HashMap<>();
    HeroAttribute LevelAttribtues = new HeroAttribute(0, 0, 0);

    protected HashSet<Weapon.WeaponType> validWeapons = new HashSet<>();
    protected HashSet<Armor.ArmorType> validArmor = new HashSet<>();

    String[] ValidWeaponTypes;
    String[] ValidArmorTypes;

    abstract void LevelUp();
    abstract void equip(Weapon weapon);
    abstract void equip(Armor armor) throws InvalidArmorException;

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
}
