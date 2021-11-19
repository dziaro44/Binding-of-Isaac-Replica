package Model.Characters;

import Model.Helpers.Constants;

public class CharacterStatistics {

    private final int baseHealthPoints;
    private int healthPoints;
    private int damage; //attack damage
    private double speed; //movement speed
    private int attackDelay; //min time between two attacks (double?)
    private double shotSpeed; //how fast bullets travel, only for throwing

    public CharacterStatistics(int healthPoints, int damage, double speed, int attackDelay, double shotSpeed) throws HealthWrongValueException {
        checkIfNonNegativeHealth(healthPoints);
        this.setHealthPoints(healthPoints);
        this.setDamage(damage);
        this.setSpeed(speed);
        this.setAttackDelay(attackDelay);
        this.setShotSpeed(shotSpeed);
        baseHealthPoints = healthPoints;
    }

    public int getBaseHealthPoints() { return baseHealthPoints; }
    public int getHealthPoints() {
        return healthPoints;
    }
    public int getDamage() { return damage; }
    public double getSpeed() { return speed; }
    public int getAttackDelay() { return attackDelay; }
    public double getShotSpeed() { return shotSpeed; }

    public void setSpeed(double speed) { this.speed = speed; }
    public void setShotSpeed(double shotSpeed) { this.shotSpeed = shotSpeed; }

    public void setHealthPoints(int healthPoints) throws HealthWrongValueException {
        checkIfNonNegativeHealth(healthPoints);
        this.healthPoints = healthPoints;
    }

    public boolean isAlive() {
        return getHealthPoints() > 0;
    }

    public void addHealth(int points) throws HealthWrongValueException {
        checkIfNonNegativeHealth(points);
        setHealthPoints(getHealthPoints() + points);
    }

    public void subtractHealth(int points) throws HealthWrongValueException {
        checkIfNonNegativeHealth(points);
        setHealthPoints(Math.max(0, getHealthPoints() - points));
    }

    public void addDamage(int damagePoints) {
        setDamage(getDamage() + damagePoints);
    }
    public void addSpeed(double speedPoints) {
        setSpeed(getSpeed() + speedPoints);
    }
    public void subtractAttackDelay(int attackDelayPoints) {
        if(getAttackDelay() - attackDelayPoints >= Constants.PLAYER_MIN_ATTACK_DELAY) {
            setAttackDelay(getAttackDelay() - attackDelayPoints);
        }
    }

    private void checkIfNonNegativeHealth(int value) throws HealthWrongValueException {
        if (value < 0) throw new HealthWrongValueException();
    }


    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setAttackDelay(int attackDelay) {
        this.attackDelay = attackDelay;
    }
}
