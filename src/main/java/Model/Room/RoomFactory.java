package Model.Room;

import Model.Characters.HealthWrongValueException;

public interface RoomFactory {
    Room getRoom(int currentLevel) throws HealthWrongValueException;
}
