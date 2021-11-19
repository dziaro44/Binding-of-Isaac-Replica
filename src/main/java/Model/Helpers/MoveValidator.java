package Model.Helpers;


import Model.Helpers.Constants;
import Model.Helpers.Coordinates;

public class MoveValidator {

    public static boolean checkMove(Coordinates newCoordinates) {
        if (newCoordinates.getX() > Constants.ROOM_WIDTH || newCoordinates.getX() < 0) return false;
        if (newCoordinates.getY() > Constants.ROOM_HEIGHT || newCoordinates.getY() < 0) return false;
        return true;
    }
}
