package Model;

import Model.Characters.HealthWrongValueException;
import Model.Helpers.Constants;
import Model.Room.Room;
import Model.Room.RoomFactory;
import com.google.inject.Inject;

import java.util.LinkedList;

public class Map {
    private final RoomFactory roomFactory;
    private int currentLevel = 0;
    private LinkedList<Room> roomList = new LinkedList<>();

    @Inject
    public Map(final RoomFactory roomFactory) {
        this.roomFactory = roomFactory;
    }

    public Room getCurrentRoom() throws HealthWrongValueException {
        if (roomList.isEmpty()) {
            generateLevel();
        }
        Room room = roomList.getFirst();
        roomList.removeFirst();
        return room;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public int getCurrentRoomNr() {
        return Constants.MAP_SIZE - roomList.size();
    }

    public boolean isCurrentRoomLast() {
        return roomList.isEmpty();
    }

    public void reset() {
        currentLevel = 0;
        roomList.clear();
    }

    private void generateLevel() throws HealthWrongValueException {
        currentLevel++;
        for (int i = 0; i < Constants.MAP_SIZE; i++) {
            roomList.add(roomFactory.getRoom(currentLevel));
        }
    }
}
