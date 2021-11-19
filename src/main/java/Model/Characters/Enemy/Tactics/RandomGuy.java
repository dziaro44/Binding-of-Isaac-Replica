package Model.Characters.Enemy.Tactics;

import Model.Characters.CharacterStatistics;
import Model.Helpers.Coordinates;
import Model.Helpers.Direction;
import Model.Helpers.NullDirectionException;

import java.util.Random;

public class RandomGuy extends EnemyTacticsClass {
    //full random
    private final Random rand = new Random();
    private final int upperbound = 8;

    public RandomGuy(CharacterStatistics characterStatistics) {
        super(characterStatistics);
    }

    @Override
    public Coordinates nextCoordinates(Coordinates playerCoordinate, Coordinates myCoordinates) {
        Coordinates zero = new Coordinates(0, 0);

        int random = rand.nextInt()%upperbound;
        if(random < 0) random = -random;
        Coordinates randomCoordinates = new Coordinates(0,0);
        try {
            if (random == 0) randomCoordinates = zero.getNewCoordinates(Direction.UP, characterStatistics.getSpeed());
            else if (random == 1) randomCoordinates = zero.getNewCoordinates(Direction.RIGHT_UP, characterStatistics.getSpeed());
            else if (random == 2) randomCoordinates = zero.getNewCoordinates(Direction.RIGHT, characterStatistics.getSpeed());
            else if (random == 3) randomCoordinates = zero.getNewCoordinates(Direction.RIGHT_DOWN, characterStatistics.getSpeed());
            else if (random == 4) randomCoordinates = zero.getNewCoordinates(Direction.DOWN, characterStatistics.getSpeed());
            else if (random == 5) randomCoordinates = zero.getNewCoordinates(Direction.LEFT_DOWN, characterStatistics.getSpeed());
            else if (random == 6) randomCoordinates = zero.getNewCoordinates(Direction.LEFT, characterStatistics.getSpeed());
            else randomCoordinates = zero.getNewCoordinates(Direction.LEFT_UP, characterStatistics.getSpeed());
        }
        catch (NullDirectionException ignore) {

        }
        return new Coordinates(myCoordinates.getX() + randomCoordinates.getX(),
                myCoordinates.getY() + randomCoordinates.getY());
    }

    @Override
    public Direction attackDirection(Coordinates playerCoordinate, Coordinates myCoordinates) {
        int random = rand.nextInt()%upperbound;
        if(random < 0) random = -random;
        if (random == 0) return Direction.UP;
        else if (random == 1) return Direction.RIGHT_UP;
        else if (random == 2) return Direction.RIGHT;
        else if (random == 3) return Direction.RIGHT_DOWN;
        else if (random == 4) return Direction.DOWN;
        else if (random == 5) return Direction.LEFT_DOWN;
        else if (random == 6) return Direction.LEFT;
        else return Direction.LEFT_UP;
    }
}
