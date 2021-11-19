package Model.Characters.Enemy;

import Model.Characters.Enemy.Tactics.EnemyType;
import Model.Characters.HealthWrongValueException;

public interface EnemiesFactory {
    Enemy getEnemy(int currentLevel, EnemyType enemyType) throws HealthWrongValueException;
}
