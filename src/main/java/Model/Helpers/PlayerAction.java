package Model.Helpers;

import Model.Helpers.Direction;

public class PlayerAction {

    private boolean isShooting = false;
    private boolean isMoving = false;
    private Direction shootDirection = null;
    private Direction moveDirection = null;

    private boolean upgradeHealth = false;
    private boolean upgradeDamage = false;
    private boolean upgradeSpeed = false;
    private boolean upgradeAttackDelay = false;

    private boolean cheatKillAll = false;

    public void clearUpgrades() {
        upgradeHealth = false;
        upgradeDamage = false;
        upgradeSpeed = false;
        upgradeAttackDelay = false;
    }

    public boolean isUpgrading() {
        return (upgradeAttackDelay || upgradeSpeed || upgradeDamage || upgradeHealth);
    }

    public boolean isCheatKillAll() { return cheatKillAll; }
    public void setCheatKillAll(boolean cheatKillAll) { this.cheatKillAll = cheatKillAll; }

    public boolean isUpgradeHealth() { return upgradeHealth; }
    public void setUpgradeHealth(boolean upgradeHealth) { this.upgradeHealth = upgradeHealth; }

    public boolean isUpgradeDamage() { return upgradeDamage; }
    public void setUpgradeDamage(boolean upgradeDamage) { this.upgradeDamage = upgradeDamage; }

    public boolean isUpgradeSpeed() { return upgradeSpeed; }
    public void setUpgradeSpeed(boolean upgradeSpeed) { this.upgradeSpeed = upgradeSpeed; }

    public boolean isUpgradeAttackDelay() { return upgradeAttackDelay; }
    public void setUpgradeAttackDelay(boolean upgradeAttackDelay) { this.upgradeAttackDelay = upgradeAttackDelay; }

    public boolean isShooting() {
        return isShooting;
    }

    public void setShooting(boolean shooting) {
        isShooting = shooting;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    public Direction getMoveDirection() { return moveDirection; }

    public void setMoveDirection(Direction moveDirection) { this.moveDirection = moveDirection; }

    public Direction getShootDirection() { return shootDirection; }

    public void setShootDirection(Direction shootDirection) { this.shootDirection = shootDirection; }
}
