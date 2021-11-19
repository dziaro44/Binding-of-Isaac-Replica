package Model.Characters.Player;

import Model.Bullet.Bullet;
import Model.Bullet.BulletFactory;
import Model.Bullet.BulletImpl;
import Model.Bullet.BulletStatistics;
import Model.Characters.CharacterStatistics;
import Model.Helpers.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class PlayerTest {

    @Mock
    private CharacterStatistics characterStatisticsMock;

    @Mock
    private BulletFactory bulletFactoryMock;

    @Mock
    private Coordinates coordinatesMock;

    @Mock
    private BulletStatistics bulletStatisticsMock;

    @Mock
    private Shape shapeMock;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void moveTest() throws NullDirectionException {

        Mockito.when(characterStatisticsMock.getSpeed()).thenReturn(10d);
        Coordinates midCoordinates = new Coordinates(Constants.ROOM_WIDTH / 2, Constants.ROOM_HEIGHT / 2);
        Coordinates cornerCoordinates = new Coordinates(0, 0);

        Player midPlayer = new PlayerImpl(bulletFactoryMock, characterStatisticsMock, midCoordinates, shapeMock);
        Player cornerPlayer = new PlayerImpl(bulletFactoryMock, characterStatisticsMock, cornerCoordinates, shapeMock);

        midPlayer.move(Direction.UP);
        cornerPlayer.move(Direction.LEFT);

        Coordinates midCoordinatesExpected = midCoordinates.getNewCoordinates(Direction.UP, 10);

        Assertions.assertEquals(midCoordinatesExpected.getX(), midPlayer.getCoordinates().getX());
        Assertions.assertEquals(midCoordinatesExpected.getY(), midPlayer.getCoordinates().getY());
        Assertions.assertEquals(cornerCoordinates.getY(), cornerPlayer.getCoordinates().getY());
        Assertions.assertEquals(cornerCoordinates.getY(), cornerPlayer.getCoordinates().getY());
    }

    @Test
    public void getBulletTest() {
        Bullet bullet = new BulletImpl(Direction.UP, coordinatesMock, bulletStatisticsMock);
        Mockito.when(bulletFactoryMock.getBullet(Mockito.eq(Direction.DOWN), Mockito.eq(coordinatesMock), Mockito.any(BulletStatistics.class))).thenReturn(bullet);

        Player Player = new PlayerImpl(bulletFactoryMock, characterStatisticsMock, coordinatesMock, shapeMock);
        Bullet returnedBullet = Player.throwBullet(Direction.DOWN);

        Assertions.assertEquals(bullet, returnedBullet);
    }
}
