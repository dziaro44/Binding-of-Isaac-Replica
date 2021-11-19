package Model.Bullet;

import Model.Helpers.Constants;
import Model.Helpers.Coordinates;
import Model.Helpers.Direction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class BulletFactoryTest {

    @Mock
    Coordinates coordinatesMock;

    @Test
    public void getBulletTest() {
        BulletStatistics bulletStatistics = new BulletStatistics(10, 10, true);
        BulletFactory bulletFactory = new BulletFactoryImpl();


        Bullet returnedBullet = bulletFactory.getBullet(Direction.UP, coordinatesMock, bulletStatistics);

        Assertions.assertTrue(returnedBullet.isShotByPlayer());
        Assertions.assertEquals(coordinatesMock, returnedBullet.getCoordinates());
        Assertions.assertEquals(Constants.BULLET_RADIUS, returnedBullet.getShape().getRadius());
        Assertions.assertEquals(10, returnedBullet.getDamage());
    }
}