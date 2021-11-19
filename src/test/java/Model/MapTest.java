package Model;

import Model.Characters.HealthWrongValueException;
import Model.Helpers.Constants;
import Model.Room.Room;
import Model.Room.RoomFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class MapTest {

    @Mock
    private RoomFactory roomFactoryMock;

    @Mock
    private Room roomMock;

    @Mock
    private Room roomNextMock;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void GetRoomTest() throws HealthWrongValueException {
        when(roomFactoryMock.getRoom(eq(1))).thenReturn(roomMock);
        when(roomFactoryMock.getRoom(eq(2))).thenReturn(roomNextMock);

        Map map = new Map(roomFactoryMock);

        for (int i = 0; i < Constants.MAP_SIZE; i++) {
            Assertions.assertEquals(map.getCurrentRoom(), roomMock);
            Assertions.assertEquals(1, map.getCurrentLevel());
        }
        for (int i = 0; i < Constants.MAP_SIZE; i++) {
            Assertions.assertEquals(map.getCurrentRoom(), roomNextMock);
            Assertions.assertEquals(2, map.getCurrentLevel());
        }
    }
}
