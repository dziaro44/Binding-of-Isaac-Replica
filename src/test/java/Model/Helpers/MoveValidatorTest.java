package Model.Helpers;

import Model.Helpers.Constants;
import Model.Helpers.Coordinates;
import Model.Helpers.MoveValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MoveValidatorTest {

    @Test
    void checkMoveTest() {

        Coordinates goodCoordinates = new Coordinates(Constants.ROOM_WIDTH / 2, Constants.ROOM_HEIGHT / 2);
        Coordinates badCoordinatesNegative = new Coordinates(-1, 1);
        Coordinates badCoordinatesTooHigh = new Coordinates(Constants.ROOM_WIDTH / 2, Constants.ROOM_HEIGHT + 1);


        Assertions.assertTrue(MoveValidator.checkMove(goodCoordinates));
        Assertions.assertFalse(MoveValidator.checkMove(badCoordinatesNegative));
        Assertions.assertFalse(MoveValidator.checkMove(badCoordinatesTooHigh));
    }
}