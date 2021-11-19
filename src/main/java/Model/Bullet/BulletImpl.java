package Model.Bullet;

import Model.Helpers.*;

import static Model.Helpers.Constants.BULLET_RADIUS;


public class BulletImpl extends PhysicalObjectImpl implements Bullet {
    private Direction direction;
    private BulletStatistics statistics;

    private boolean hitWall = false;

    public BulletImpl(Direction direction, Coordinates coordinates, BulletStatistics statistics) {
        super(coordinates, new Shape(BULLET_RADIUS));
        this.direction = direction;
        this.coordinates = coordinates;
        this.statistics = statistics;
    }

    public void move() throws NullDirectionException {
        Coordinates newCoordinates = coordinates.getNewCoordinates(direction, statistics.getSpeed());

        if (MoveValidator.checkMove(newCoordinates))
            setCoordinates(newCoordinates);
        else hitWall = true;
    }

    public int getDamage() {
        return statistics.getDamage();
    }

    public boolean isShotByPlayer() {
        return statistics.getIsShotByPlayer();
    }

    public boolean didHitWall() {
        return hitWall;
    }
}
