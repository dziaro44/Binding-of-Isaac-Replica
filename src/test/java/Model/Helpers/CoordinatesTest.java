package Model.Helpers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CoordinatesTest {

    @Test
    public void getNewCoordinatesTest() throws NullDirectionException {
        Coordinates coordinates = new Coordinates(100, 100);
        double diagonal = Math.sqrt(2) / 2 * 10;

        Coordinates upCoordinates = coordinates.getNewCoordinates(Direction.UP, 10);
        Coordinates downCoordinates = coordinates.getNewCoordinates(Direction.DOWN, 10);
        Coordinates rightCoordinates = coordinates.getNewCoordinates(Direction.RIGHT, 10);
        Coordinates leftCoordinates = coordinates.getNewCoordinates(Direction.LEFT, 10);
        Coordinates upRightCoordinates = coordinates.getNewCoordinates(Direction.RIGHT_UP, 10);
        Coordinates upLeftCoordinates = coordinates.getNewCoordinates(Direction.LEFT_UP, 10);
        Coordinates downRightCoordinates = coordinates.getNewCoordinates(Direction.RIGHT_DOWN, 10);
        Coordinates downLeftCoordinates = coordinates.getNewCoordinates(Direction.LEFT_DOWN, 10);

        Assertions.assertEquals(100, upCoordinates.getX());
        Assertions.assertEquals(110, upCoordinates.getY());

        Assertions.assertEquals(100, downCoordinates.getX());
        Assertions.assertEquals(90, downCoordinates.getY());

        Assertions.assertEquals(110, rightCoordinates.getX());
        Assertions.assertEquals(100, rightCoordinates.getY());

        Assertions.assertEquals(90, leftCoordinates.getX());
        Assertions.assertEquals(100, leftCoordinates.getY());

        Assertions.assertEquals(100 + diagonal, upRightCoordinates.getX());
        Assertions.assertEquals(100 + diagonal, upRightCoordinates.getY());

        Assertions.assertEquals(100 - diagonal, upLeftCoordinates.getX());
        Assertions.assertEquals(100 + diagonal, upLeftCoordinates.getY());

        Assertions.assertEquals(100 + diagonal, downRightCoordinates.getX());
        Assertions.assertEquals(100 - diagonal, downRightCoordinates.getY());

        Assertions.assertEquals(100 - diagonal, downLeftCoordinates.getX());
        Assertions.assertEquals(100 - diagonal, downLeftCoordinates.getY());
    }

}