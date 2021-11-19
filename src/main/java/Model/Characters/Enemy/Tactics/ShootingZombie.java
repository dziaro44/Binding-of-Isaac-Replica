package Model.Characters.Enemy.Tactics;

import Model.Characters.CharacterStatistics;
import Model.Helpers.Coordinates;
import Model.Helpers.Direction;
import Model.Helpers.NullDirectionException;

public class ShootingZombie extends EnemyTacticsClass {
    //shoots in direction of player, walks after player

    public ShootingZombie(CharacterStatistics characterStatistics) {
        super(characterStatistics);
    }

    @Override
    public Coordinates nextCoordinates(Coordinates playerCoordinate, Coordinates myCoordinates) {
        double x = playerCoordinate.getX() - myCoordinates.getX();
        double y = playerCoordinate.getY() - myCoordinates.getY();
        double denominator = Math.sqrt(x*x + y*y);
        return new Coordinates(myCoordinates.getX() + x / denominator * characterStatistics.getSpeed() ,
                myCoordinates.getY() + y / denominator * characterStatistics.getSpeed());
    }

    @Override
    public Direction attackDirection(Coordinates playerCoordinate, Coordinates myCoordinates) {
        double x = playerCoordinate.getX() - myCoordinates.getX();
        double y = playerCoordinate.getY() - myCoordinates.getY();
        double denominator = Math.sqrt(x*x + y*y);
        Coordinates coordinatesDirection = new Coordinates(x/denominator, y/denominator);
        Coordinates zero = new Coordinates(0, 0);

        Direction result = Direction.UP;
        try {
            double minDistance = coordinatesDirection.distanceFrom(zero.getNewCoordinates(Direction.UP, 1));
            if(coordinatesDirection.distanceFrom(zero.getNewCoordinates(Direction.RIGHT_UP, 1)) < minDistance) {
                minDistance = coordinatesDirection.distanceFrom(zero.getNewCoordinates(Direction.RIGHT_UP, 1));
                result = Direction.RIGHT_UP;
            }
            if(coordinatesDirection.distanceFrom(zero.getNewCoordinates(Direction.RIGHT, 1)) < minDistance) {
                minDistance = coordinatesDirection.distanceFrom(zero.getNewCoordinates(Direction.RIGHT, 1));
                result = Direction.RIGHT;
            }
            if(coordinatesDirection.distanceFrom(zero.getNewCoordinates(Direction.RIGHT_DOWN, 1)) < minDistance) {
                minDistance = coordinatesDirection.distanceFrom(zero.getNewCoordinates(Direction.RIGHT_DOWN, 1));
                result = Direction.RIGHT_DOWN;
            }
            if(coordinatesDirection.distanceFrom(zero.getNewCoordinates(Direction.DOWN, 1)) < minDistance) {
                minDistance = coordinatesDirection.distanceFrom(zero.getNewCoordinates(Direction.DOWN, 1));
                result = Direction.DOWN;
            }
            if(coordinatesDirection.distanceFrom(zero.getNewCoordinates(Direction.LEFT_DOWN, 1)) < minDistance) {
                minDistance = coordinatesDirection.distanceFrom(zero.getNewCoordinates(Direction.LEFT_DOWN, 1));
                result = Direction.LEFT_DOWN;
            }
            if(coordinatesDirection.distanceFrom(zero.getNewCoordinates(Direction.LEFT, 1)) < minDistance) {
                minDistance = coordinatesDirection.distanceFrom(zero.getNewCoordinates(Direction.LEFT, 1));
                result = Direction.LEFT;
            }
            if(coordinatesDirection.distanceFrom(zero.getNewCoordinates(Direction.LEFT_UP, 1)) < minDistance) {
                //minDistance = coordinatesDirection.distanceFrom(zero.getNewCoordinates(Direction.LEFT_UP, 1));
                result = Direction.LEFT_UP;
            }
        }
        catch (NullDirectionException ignored) {

        }
        return result;
    }

}
