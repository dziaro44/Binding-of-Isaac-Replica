package Model.Bullet;

import Model.Helpers.Constants;
import Model.Helpers.Coordinates;
import Model.Helpers.Direction;
import Model.Helpers.NullDirectionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class BulletTest {

    private static final BulletStatistics bulletStatistics = new BulletStatistics(10, 10, true);

    @Test
    public void moveTest() throws NullDirectionException {

        Coordinates coordinates = new Coordinates(Constants.ROOM_WIDTH / 2, Constants.ROOM_HEIGHT / 2);

        Bullet bullet = new BulletImpl(Direction.UP, coordinates, bulletStatistics);

        bullet.move();

        Coordinates returnedCoordinates = bullet.getCoordinates();
        Coordinates expectedCoordinates = coordinates.getNewCoordinates(Direction.UP, 10);

        Assertions.assertEquals(expectedCoordinates.getX(), returnedCoordinates.getX());
        Assertions.assertEquals(expectedCoordinates.getY(), returnedCoordinates.getY());
        Assertions.assertFalse(bullet.didHitWall());
    }

    @Test
    public void moveHitWallTest() throws NullDirectionException {

        Coordinates coordinates = new Coordinates(1, 1);
        Bullet bullet = new BulletImpl(Direction.DOWN, coordinates, bulletStatistics);

        bullet.move();

        Coordinates returnedCoordinates = bullet.getCoordinates();

        Assertions.assertTrue(bullet.didHitWall());
        Assertions.assertEquals(coordinates.getX(), returnedCoordinates.getX());
        Assertions.assertEquals(coordinates.getY(), returnedCoordinates.getY());
    }

}
