package Model.Characters.Enemy.Tactics;

import Model.Characters.CharacterStatistics;
import Model.Helpers.Coordinates;
import Model.Helpers.Direction;

public class Zombie extends EnemyTacticsClass {
    //doesn't shoot, walks after player

    public Zombie(CharacterStatistics characterStatistics) {
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
        return null;
    }
}
