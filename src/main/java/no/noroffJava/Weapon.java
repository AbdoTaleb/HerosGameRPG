package no.noroffJava;



public class Weapon extends Item{

    private int WeaponDamage;
    public Weapon(){}

    Item.Slot slot;
    WeaponType weaponType;
    public Weapon(String name, int requiredLevel, String weaponType, int weaponDamage ) {
        this.slot = Slot.Weapon;
        this.setName(name);
        this.setRequiredLevel(requiredLevel);
        this.WeaponDamage = weaponDamage;
        this.weaponType = Weapon.WeaponType.valueOf(weaponType);


    }

    public int getWeaponDamage() {
        return WeaponDamage;
    }

    enum WeaponType{
        Axes,
        Bows,
        Daggers,
        Hammers,
        Staffs,
        Swords,
        Wands

    }


}