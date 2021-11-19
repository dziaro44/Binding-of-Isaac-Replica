package Model.Characters;

import Model.Helpers.PhysicalObject;

public interface Character extends PhysicalObject {

    void setCharacterStatistics(CharacterStatistics characterStatistics);
    CharacterStatistics getCharacterStatistics();
    void addHealth(int healthPoints) throws HealthWrongValueException;
    void subtractHealth(int healthPoints) throws HealthWrongValueException;
    void addDamage(int damagePoints);
    void addSpeed(double speedPoints);
    void subtractAttackDelay(int attackDelayPoints);
    boolean isAlive();
    boolean canAttack();
    void reduceTimeToAttack();
}
