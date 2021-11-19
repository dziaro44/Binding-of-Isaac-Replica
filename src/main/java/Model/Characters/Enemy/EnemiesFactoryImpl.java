package Model.Characters.Enemy;

import Model.Bullet.BulletFactory;
import Model.Characters.CharacterStatistics;
import Model.Characters.Enemy.Tactics.*;
import Model.Characters.HealthWrongValueException;
import Model.Helpers.Constants;
import Model.Helpers.Coordinates;
import Model.Helpers.Shape;
import com.google.inject.Inject;

import java.util.Random;

public class EnemiesFactoryImpl implements EnemiesFactory {
    @Inject
    private BulletFactory bulletFactory;

    private Coordinates getRandomCoordinatesForEnemy() {
        Coordinates center = new Coordinates(Constants.ROOM_WIDTH / 2, Constants.ROOM_HEIGHT / 2);
        Random rand = new Random();
        double x = Constants.ENEMY_RADIUS + ((Constants.ROOM_WIDTH-Constants.ENEMY_RADIUS) - Constants.ENEMY_RADIUS) * rand.nextDouble();
        double y = Constants.ENEMY_RADIUS + ((Constants.ROOM_HEIGHT-Constants.ENEMY_RADIUS) - Constants.ENEMY_RADIUS) * rand.nextDouble();
        Coordinates coordinates = new Coordinates(x, y);
        while(coordinates.distanceFrom(center) < 200) {
            x = Constants.ENEMY_RADIUS + ((Constants.ROOM_WIDTH-Constants.ENEMY_RADIUS) - Constants.ENEMY_RADIUS) * rand.nextDouble();
            y = Constants.ENEMY_RADIUS + ((Constants.ROOM_HEIGHT-Constants.ENEMY_RADIUS) - Constants.ENEMY_RADIUS) * rand.nextDouble();
            coordinates = new Coordinates(x, y);
        }
        return coordinates;
    }
    public Enemy getEnemy(int currentLevel, EnemyType enemyType) throws HealthWrongValueException {
        double speed = new Random().nextDouble() * Constants.ENEMY_SPEED_BOUND;
        CharacterStatistics characterStatistics = new CharacterStatistics(Constants.ENEMY_HP,
                Constants.ENEMY_DMG, speed, Constants.ENEMY_ATTACK_DELAY, Constants.ENEMY_SHOT_SPEED);
        Coordinates coordinates = getRandomCoordinatesForEnemy();

        EnemyTactics enemyTactics;
        if(enemyType == EnemyType.SHOOTING_ZOMBIE) enemyTactics = new ShootingZombie(characterStatistics);
        else if(enemyType == EnemyType.ZOMBIE) enemyTactics = new Zombie(characterStatistics);
        else if(enemyType == EnemyType.HORIZONTAL_GUY) {
            characterStatistics = new CharacterStatistics(Constants.ENEMY_HP*2,
                    Constants.ENEMY_DMG*2, speed*2, Constants.ENEMY_ATTACK_DELAY/2, Constants.ENEMY_SHOT_SPEED*1.5);
            enemyTactics = new HorizontalGuy(characterStatistics);
        }
        else enemyTactics = new RandomGuy(characterStatistics);

        return new EnemyImpl(
                bulletFactory,
                characterStatistics,
                coordinates,
                new Shape(Constants.ENEMY_RADIUS),
                enemyTactics
        );
    }
}
