package no.noroffJava;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    @Test
    void levelUp() {
        Mage hero = new Mage("Mage");

        // All heroes start with level 1
        // Increase the level by 1
        hero.LevelUp();
        assertEquals(2, hero.getLevel());

    }

    @Test
    void equip() {
    }

    @Test
    void testEquip() {
    }

    @Test
    void setValidWeapons() {
    }

    @Test
    void setValidArmor() {
    }

    @Test
    void getValidArmor() {
    }
}