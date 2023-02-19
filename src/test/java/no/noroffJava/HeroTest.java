package no.noroffJava;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {
    Mage hero;
    @BeforeEach
    void setUp(){
        hero = new Mage("Mage");
    }

    @Test
    void equip_ValidWeapon_ReturnWeaponEqualsHeroWeapon() throws InvalidWeaponException {

        // Arrange
        // Send only 4 arguments because the slot is automatically sets to Weapon
        Weapon weapon = new Weapon("Common Axe", 1, "Staffs", 2 );

        // Act

        hero.equip(weapon);

        // Assert
        assertTrue(weapon.equals(hero.getHeroWeapon()));
    }

    @Test
    void equip_InvalidWeapon_ReturnInvalidWeaponException(){

        // Arrange
        // Send only 4 arguments because the slot is automatically sets to Weapon
        Weapon weapon = new Weapon("Common Axe", 1, "Bows", 2 );

        String expected = "Invalid weapon type for our hero " + hero.getName();

        // Act
        InvalidWeaponException exception =
                assertThrows(InvalidWeaponException.class, () -> hero.equip(weapon));


        // Assert
        assertEquals(expected, exception.getMessage());
    }

    @Test
    void equip_InvalidArmor_ReturnInvalidArmorException(){

        // Arrange
        HeroAttribute armorAttribute = new HeroAttribute(1,1,5);
        Armor armor =  new Armor("Common Leather", 1,
                "Body", "Leather", armorAttribute);

        String expected = "Invalid armor type for our hero " + hero.getName();

        // Act
        InvalidArmorException exception =
                assertThrows(InvalidArmorException.class, () -> hero.equip(armor));


        // Assert
        assertEquals(expected, exception.getMessage());
    }

    @Test
    void equip_InvalidLevel_ReturnInvalidWeaponException(){

        // Arrange
        // Send only 4 arguments because the slot is automatically sets to Weapon
        Weapon weapon = new Weapon("Common Axe", 10, "Staffs", 2 );

        String expected = "Can't equip this weapon because low level of our hero " + hero.getName();

        // Act
        InvalidWeaponException exception =
                assertThrows(InvalidWeaponException.class, () -> hero.equip(weapon));


        // Assert
        assertEquals(expected, exception.getMessage());
    }

    @Test
    void equip_InvalidLevel_ReturnInvalidArmorException(){

        // Arrange
        HeroAttribute armorAttribute = new HeroAttribute(1,1,5);
        Armor armor =  new Armor("Common Cloth", 5,
                "Body", "Cloth", armorAttribute);

        String expected = "Can't equip this armor because low level of our hero " + hero.getName();

        // Act
        InvalidArmorException exception =
                assertThrows(InvalidArmorException.class, () -> hero.equip(armor));


        // Assert
        assertEquals(expected, exception.getMessage());
    }


    @Test
    void testLevelUp() {

        // Arrange
        // All heroes start with level 1
        // Increase the level by 1
        int expected = 2; // 1 + 1 = 2

        // Act
        hero.levelUp();
        int actual = hero.getLevel();

        // Assert
        assertEquals(expected, actual);
    }



    @Test
    void heroDamage_NoWeaponEquipped() {

        // Arrange
        // Hero Mage total Intelligence start at 8
        double expected = 1 * ((double) 1 + 8 / 100);

        // Act
        double actual = hero.heroDamage();

        // Assert
        assertEquals(expected, actual);
    }


    @Test
    void heroDamage_WithWeaponEquipped() throws InvalidWeaponException {

        // Arrange
        // creating weapon with damage 2
        Weapon weapon = new Weapon("Common Axe", 1, "Staffs", 2 );
        hero.equip(weapon);
        // When creating the hero Mage the Intelligence will be initialized to 8.0 (double)
        double expected = 2 * (1 + (8.0 / 100)); // This will be equal to 2.16

        // Act
        double actual = hero.heroDamage();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void getLevel_shouldReturnHeroLevel() {

        // Arrange

        int expected  = hero.getLevel(); // = 1

        // Act
        // All heroes start with level 1
        int actual = 1;

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void getName_shouldReturnHeroName() {

        // Arrange
        String expected = "Mage";
        // Act
        String actual = hero.getName();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void getHeroWeapon_ReturnHeroWeapon() throws InvalidWeaponException {

        // Arrange
        // Send only 4 arguments because the slot is automatically sets to Weapon
        Weapon weapon = new Weapon("Common Axe", 1, "Staffs", 2 );

        // Act

        hero.equip(weapon);

        // Assert
        assertTrue(weapon.equals(hero.getHeroWeapon()));
    }

    @Test
    void setHeroWeapon_ReturnHeroWeapon() {

        // Arrange
        // Send only 4 arguments because the slot is automatically sets to Weapon
        Weapon weapon = new Weapon("Common Axe", 1, "Staffs", 2 );

        // Act

        hero.setHeroWeapon(weapon);

        // Assert
        assertTrue(weapon.equals(hero.getHeroWeapon()));
    }

    @Test
    void getValidWeapons_ReturnSetOfValidWeapon() {

        // Arrange
        // When crating a hero we add to the validWeapon Set the
        // hero valid weapon. For Mage hero the valid weapon is ["Staffs", "Wands"]
        HashSet<Weapon.WeaponType> expected = new HashSet<>();
        expected.add(Weapon.WeaponType.Staffs);
        expected.add((Weapon.WeaponType.Wands));

        // Act
        HashSet<Weapon.WeaponType> actual = hero.getValidWeapons();

        // Assert
        assertEquals(expected, actual);
    }


    @Test
    void getValidArmor_ReturnSetOfValidArmor() {

        // Arrange
        // When crating a hero we add to the validArmor Set the
        // hero valid armor. For Mage hero the valid armor is ["Cloth"]
        HashSet<Armor.ArmorType> expected = new HashSet<>();
        expected.add(Armor.ArmorType.Cloth);

        // Act
        HashSet<Armor.ArmorType> actual = hero.getValidArmor();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void display() throws InvalidWeaponException, InvalidArmorException {

        // Arrange

        Weapon weapon = new Weapon("Common Axe", 1, "Staffs", 2 );
        HeroAttribute armorAttribute = new HeroAttribute(1,1,5);
        Armor armor =  new Armor("Common Cloth", 1,
                "Body", "Cloth", armorAttribute);

        StringBuilder expected  = new StringBuilder();
        expected.append("Hero Name: ").append("Mage").append("\n").append("Hero Class: ").
                append("Mage").append("\n").append("Hero Level: ").append(1).
                append("\n").append("Hero Strength: ").append(2).append("\n").
                append("Hero Dexterity: ").append(2).append("\n").append("Hero Intelligence: ").
                append(13).append("\n").append("Hero Damage: ").append(2.26);


        hero.equip(weapon);
        hero.equip(armor);


        // Act

        StringBuilder actual;
        actual = hero.display();


        // Assert

        assertEquals(expected.toString(), actual.toString());

    }
}




