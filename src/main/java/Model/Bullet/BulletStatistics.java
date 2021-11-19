package Model.Bullet;

public class BulletStatistics {

    private int damage;
    private double speed;
    private boolean isShotByPlayer;

    public BulletStatistics(int damage, double speed, boolean isShotByPlayer) {
        this.setDamage(damage);
        this.setSpeed(speed);
        this.setShotByPlayer(isShotByPlayer);
    }

    public int getDamage() {
        return damage;
    }

    public double getSpeed() {
        return speed;
    }

    public boolean getIsShotByPlayer() {
        return isShotByPlayer();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public boolean isShotByPlayer() {
        return isShotByPlayer;
    }

    public void setShotByPlayer(boolean shotByPlayer) {
        isShotByPlayer = shotByPlayer;
    }
}
