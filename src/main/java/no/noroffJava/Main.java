package no.noroffJava;

public class Main {
    public static void main(String[] args) throws InvalidArmorException, InvalidWeaponException {
        Mage hero = new Mage("myHero");
        HeroAttribute h = new HeroAttribute(1,1,5);
        Weapon w2 = new Weapon("Common Axe2", 1, "Staffs", 2 );

        Armor a =  new Armor("Common Cloth77", 1,
                "Body", "Cloth", h);

        hero.equip(a);
        hero.equip(w2);

        System.out.println(hero.getValidWeapons());


        System.out.println(hero.display());

    }
}