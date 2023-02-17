package no.noroffJava;

public class Main {
    public static void main(String[] args) {
        Mage hero = new Mage("my hero");
        HeroAttribute h = new HeroAttribute(1,0,0);
        //Weapon w2 = new Weapon("Common Axe2", 1, "Axes", 2 );

        Armor a =  new Armor("Common Cloth77", 1,
                "Body", "Cloth", h);

        hero.equip(a);
        System.out.println(a.getName() + " " + a.slot + " " + a.armorType +
                " " + a.ArmorAttribute.getStrength());
    }
}