package Model.Characters.Enemy.Tactics;

import Model.Characters.CharacterStatistics;
import Model.Helpers.Coordinates;
import Model.Helpers.Direction;
import Model.Helpers.MoveValidator;
import Model.Helpers.NullDirectionException;

public class HorizontalGuy extends EnemyTacticsClass{
    //walks left/right shoots up/down
    private Direction actualMoveDirection   = Direction.LEFT;
    private Direction actualShootDirection  = Direction.UP;

    public HorizontalGuy(CharacterStatistics characterStatistics) {
        super(characterStatistics);
    }

    @Override
    public Coordinates nextCoordinates(Coordinates playerCoordinate, Coordinates myCoordinates) {
        Coordinates zero = new Coordinates(0, 0);
        Coordinates afterMove = new Coordinates(0,0);
        try {
            Coordinates moveCoordinates = zero.getNewCoordinates(actualMoveDirection, characterStatistics.getSpeed());
            afterMove = new Coordinates(myCoordinates.getX() + moveCoordinates.getX(),
                    myCoordinates.getY() + moveCoordinates.getY());
            if(!MoveValidator.checkMove(afterMove)) {
                if(actualMoveDirection == Direction.LEFT) {
                    actualMoveDirection = Direction.RIGHT;
                }
                else {
                    actualMoveDirection = Direction.LEFT;
                }
                moveCoordinates = zero.getNewCoordinates(actualMoveDirection, characterStatistics.getSpeed());
                afterMove = new Coordinates(myCoordinates.getX() + moveCoordinates.getX(),
                        myCoordinates.getY() + moveCoordinates.getY());
            }
        }
        catch (NullDirectionException ignore) {

        }
        return afterMove;
    }

    @Override
    public Direction attackDirection(Coordinates playerCoordinate, Coordinates myCoordinates) {
        if(actualShootDirection == Direction.UP) {
            actualShootDirection = Direction.DOWN;
        }
        else {
            actualShootDirection = Direction.UP;
        }
        return actualShootDirection;
    }
}
