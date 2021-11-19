package Model.Room;

import Model.Bullet.BulletFactory;
import Model.Characters.CharacterStatistics;
import Model.Characters.Enemy.EnemiesFactory;
import Model.Characters.Enemy.Enemy;
import Model.Characters.Enemy.EnemyImpl;
import Model.Characters.HealthWrongValueException;
import Model.Helpers.Coordinates;
import Model.Helpers.Shape;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class RoomFactoryTest {

    private RoomFactory roomFactory;

    @Mock
    private EnemiesFactory enemiesFactoryMock;

    @Mock
    private BulletFactory bulletFactoryMock;

    @Mock
    private CharacterStatistics characterStatisticsMock;

    @Mock
    private Coordinates coordinatesMock;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        roomFactory = new RoomFactoryImpl(enemiesFactoryMock);
    }

    @Test
    public void getRoomTest() throws HealthWrongValueException {
        Room returnedRoomOne = roomFactory.getRoom(1);
        Room returnedRoomSeven = roomFactory.getRoom(7);

        Assertions.assertEquals(1, returnedRoomOne.getEnemies().size());
        Assertions.assertEquals(7, returnedRoomSeven.getEnemies().size());
    }
}