package Model.Characters.Enemy.Tactics;

import Model.Helpers.Coordinates;
import Model.Helpers.Direction;

public interface EnemyTactics {
    Coordinates nextCoordinates(Coordinates playerCoordinate, Coordinates myCoordinates);
    Direction attackDirection(Coordinates playerCoordinate, Coordinates myCoordinates);
}
