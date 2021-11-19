package Model.Bullet;

import Model.Helpers.Coordinates;
import Model.Helpers.Direction;

public class BulletFactoryImpl implements BulletFactory {

    public Bullet getBullet(Direction direction, Coordinates coordinates, BulletStatistics bulletStatistics) {
        return new BulletImpl(direction, coordinates, bulletStatistics);
    }
}
