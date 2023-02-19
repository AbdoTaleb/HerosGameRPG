package no.noroffJava;



public class Weapon extends Item{
    private double weaponDamage;
    Item.Slot slot;
    WeaponType weaponType;
    // Constructor takes four argument when creating a new armor to initialize its value
    // Weapon Slot is automatically sets to Weapon
    public Weapon(String name, int requiredLevel, String weaponType, int weaponDamage ) {
        this.slot = Slot.Weapon;
        this.setName(name);
        this.setRequiredLevel(requiredLevel);
        this.weaponDamage = weaponDamage;
        this.weaponType = Weapon.WeaponType.valueOf(weaponType);
    }

    public double getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(double weaponDamage) {
        this.weaponDamage = weaponDamage;
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

    // Use this function in testing to check if to instance of Weapon are equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weapon that = (Weapon) o;
        return this.getName().equals(that.getName()) && this.getRequiredLevel() == that.getRequiredLevel() && this.weaponType == that.weaponType &&
                this.slot == that.slot && this.weaponDamage == that.weaponDamage;
    }


}