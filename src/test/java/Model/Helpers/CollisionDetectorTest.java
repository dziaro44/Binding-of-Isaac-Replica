package Model.Helpers;

import Model.Bullet.Bullet;
import Model.Bullet.BulletFactory;
import Model.Bullet.BulletImpl;
import Model.Bullet.BulletStatistics;
import Model.Characters.CharacterStatistics;
import Model.Characters.Player.PlayerImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class CollisionDetectorTest {

    @Mock
    private BulletFactory bulletFactoryMock;

    @Mock
    private CharacterStatistics characterStatisticsMock;

    @Mock
    private BulletStatistics bulletStatisticsMock;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void noCollisionTest() {

        PhysicalObject player = new PlayerImpl(bulletFactoryMock, characterStatisticsMock, new Coordinates(100, 100), new Shape(10));
        PhysicalObject bullet = new BulletImpl(Direction.UP, new Coordinates(200, 200), bulletStatisticsMock);

        Assertions.assertFalse(CollisionDetector.isCollision(player, bullet));
    }

    @Test
    public void collisionTest() {

        //uwzględnianie promienia bulletu do naprawy
        PhysicalObject player = new PlayerImpl(bulletFactoryMock, characterStatisticsMock, new Coordinates(100, 100), new Shape(10));
        PhysicalObject bullet = new BulletImpl(Direction.UP, new Coordinates(105, 104), bulletStatisticsMock);

        Assertions.assertTrue(CollisionDetector.isCollision(player, bullet));
    }

    @Test
    public void firstNoCollisionThenCollisionTest() throws NullDirectionException {

        BulletStatistics bulletStatistics = new BulletStatistics(10, 10, true);
        PlayerImpl playerImpl = new PlayerImpl(bulletFactoryMock, characterStatisticsMock, new Coordinates(100, 100), new Shape(10));
        Bullet bullet = new BulletImpl(Direction.UP, new Coordinates(100, 80), bulletStatistics);

        boolean noCollisionReturned = CollisionDetector.isCollision(playerImpl, bullet);
        bullet.move();
        boolean collisionReturned = CollisionDetector.isCollision(playerImpl, bullet);

        Assertions.assertFalse(noCollisionReturned);
        Assertions.assertTrue(collisionReturned);
    }
}
