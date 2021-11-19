package Model.Characters;

import Model.Helpers.PhysicalObject;

public class CharacterInfo {
    private PhysicalObject physicalObject;
    private int currentHealth;
    private int baseHealth;

    public CharacterInfo(PhysicalObject physicalObject, int currentHealth, int baseHealth) {
        this.setPhysicalObject(physicalObject);
        this.setCurrentHealth(currentHealth);
        this.setBaseHealth(baseHealth);
    }

    public PhysicalObject getPhysicalObject() {
        return physicalObject;
    }

    public int getBaseHealth() { return baseHealth; }

    public int getCurrentHealth() { return currentHealth; }

    public void setPhysicalObject(PhysicalObject physicalObject) {
        this.physicalObject = physicalObject;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public void setBaseHealth(int baseHealth) {
        this.baseHealth = baseHealth;
    }
}
