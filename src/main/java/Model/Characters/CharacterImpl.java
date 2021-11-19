package Model.Characters;

import Model.Bullet.BulletFactory;
import Model.Helpers.Coordinates;
import Model.Helpers.PhysicalObjectImpl;
import Model.Helpers.Shape;

public abstract class CharacterImpl extends PhysicalObjectImpl implements Character {

    //można się zastanowić czy nie chcemy mieć różnych wielkości dla różnych postaci i jak to rozwiązać
    //public static final double CHARACTER_RADIUS = 15;

    protected final BulletFactory bulletFactory;

    protected CharacterStatistics characterStatistics;
    protected int turnsUntilAttack;

    public CharacterImpl(final BulletFactory bulletFactory,
                         CharacterStatistics characterStatistics,
                         Coordinates coordinates,
                         Shape shape) {
        super(coordinates, shape);
        this.bulletFactory = bulletFactory;
        this.characterStatistics = characterStatistics;
        turnsUntilAttack = 0;
    }

    @Override
    public void setCharacterStatistics(CharacterStatistics characterStatistics) {
        this.characterStatistics = characterStatistics;
    }

    @Override
    public CharacterStatistics getCharacterStatistics() {
        return characterStatistics;
    }

    @Override
    public void addHealth(int healthPoints) throws HealthWrongValueException {
        characterStatistics.addHealth(healthPoints);
    }

    @Override
    public void subtractHealth(int healthPoints) throws HealthWrongValueException {
        characterStatistics.subtractHealth(healthPoints);
    }

    @Override
    public void addDamage(int damagePoints) {
        characterStatistics.addDamage(damagePoints);
    }

    @Override
    public void addSpeed(double speedPoints) {
        characterStatistics.addSpeed(speedPoints);
    }

    @Override
    public void subtractAttackDelay(int attackDelayPoints) {
        characterStatistics.subtractAttackDelay(attackDelayPoints);
    }

    @Override
    public boolean isAlive() {
        return characterStatistics.isAlive();
    }

    @Override
    public boolean canAttack() { return (turnsUntilAttack == 0); }

    @Override
    public void reduceTimeToAttack() { if (turnsUntilAttack > 0) turnsUntilAttack--; }
}
