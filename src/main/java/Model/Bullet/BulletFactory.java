package Model.Bullet;

import Model.Helpers.Coordinates;
import Model.Helpers.Direction;

public interface BulletFactory {
    Bullet getBullet(Direction direction, Coordinates coordinates, BulletStatistics statistics);
}
