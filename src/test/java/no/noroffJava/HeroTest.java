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
    void equip_InvalidWeapon_ReturnInvalidWeaponException() throws InvalidWeaponException {

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
    void equip_InvalidLevel_ReturnInvalidWeaponException() throws InvalidWeaponException {

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
    void testEquip() {

        // Arrange

        // Act

        // Assert
    }

    @Test
    void setValidWeapons() {

        // Arrange

        // Act

        // Assert
    }

    @Test
    void setValidArmor() {

        // Arrange

        // Act

        // Assert
    }

    @Test
    void getValidArmor() {

        // Arrange


        // Act

        // Assert
    }

    @Test
    void testLevelUp() {

        // Arrange
        // All heroes start with level 1
        int actual  = hero.getLevel(); // = 1

        // Act
        // Increase the level by 1
        hero.levelUp();
        actual = hero.getLevel();

        // Assert
        assertEquals(2, actual);
    }

    @Test
    void testEquip1() {

        // Arrange

        // Act

        // Assert
    }

    @Test
    void testEquip2() {

        // Arrange

        // Act

        // Assert
    }

    @Test
    void heroDamage_NoWeaponEquipped() {

        // Arrange
        double expected = 1 * ((double) 1 + hero.totalAttributes.getIntelligence() / 100);

        // Act
        double actual = hero.heroDamage();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testSetValidWeapons() {

        // Arrange

        // Act

        // Assert
    }

    @Test
    void testSetValidArmor() {

        // Arrange

        // Act

        // Assert
    }

    @Test
    void testGetValidArmor() {

        // Arrange

        // Act

        // Assert
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
    void getValidWeapons() {

        // Arrange

        // Act

        // Assert
    }

    @Test
    void display() {

        // Arrange

        // Act


        // Assert
    }
}