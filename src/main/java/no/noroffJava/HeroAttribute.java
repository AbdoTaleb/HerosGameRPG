package no.noroffJava;

public class HeroAttribute {
    private int strength;
    private int dexterity;
    private int intelligence;

    public HeroAttribute(int strength, int dexterity, int intelligence){
        this.strength = strength;
        this.dexterity =  dexterity;
        this.intelligence = intelligence;
    }

    /**
     * Function to add two instance and return the sum.
     */
    public HeroAttribute addLevelAttributes(HeroAttribute firstLevelAttribtue, HeroAttribute secondLevelAttribtue){
        HeroAttribute sum = new HeroAttribute(0, 0, 0);
        sum.setStrength(firstLevelAttribtue.getStrength() + secondLevelAttribtue.getStrength());
        sum.setDexterity(firstLevelAttribtue.getDexterity() + secondLevelAttribtue.getDexterity());
        sum.setIntelligence(firstLevelAttribtue.getIntelligence() + secondLevelAttribtue.getIntelligence());
        return sum;
    }
    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
}

