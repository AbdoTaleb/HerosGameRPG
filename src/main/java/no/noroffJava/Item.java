package no.noroffJava;



public abstract class Item {
    private String Name;
    private int RequiredLevel;

    public void setName(String name) {
        this.Name = name;
    }

    public void setRequiredLevel(int requiredLevel) {
        RequiredLevel = requiredLevel;
    }

    public String getName() {
        return Name;
    }

    public int getRequiredLevel() {
        return RequiredLevel;
    }

    protected enum Slot {
        Weapon,
        Head,
        Body,
        Legs;

    }

}
