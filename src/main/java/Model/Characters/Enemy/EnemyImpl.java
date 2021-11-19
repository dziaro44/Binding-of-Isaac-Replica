package Model.Characters.Enemy;

import Model.Bullet.Bullet;
import Model.Bullet.BulletFactory;
import Model.Bullet.BulletStatistics;
import Model.Characters.CharacterImpl;
import Model.Characters.CharacterStatistics;
import Model.Characters.Enemy.Tactics.EnemyTactics;
import Model.Helpers.Coordinates;
import Model.Helpers.Direction;
import Model.Helpers.MoveValidator;
import Model.Helpers.Shape;

public class EnemyImpl extends CharacterImpl implements Enemy {

    private EnemyTactics enemyTactics;

    public EnemyImpl(BulletFactory bulletFactory, CharacterStatistics characterStatistics, Coordinates coordinates, Shape shape, EnemyTactics enemyTactics) {
        super(bulletFactory, characterStatistics, coordinates, shape);
        this.enemyTactics = enemyTactics;
    }

    @Override
    public void move(Coordinates playerCoordinates) {
        Coordinates newCoordinates = enemyTactics.nextCoordinates(playerCoordinates, coordinates);

        if(MoveValidator.checkMove(newCoordinates))
            setCoordinates(newCoordinates);
    }

    @Override
    public Bullet throwBullet(Coordinates playerCoordinates) {
        turnsUntilAttack = characterStatistics.getAttackDelay();

        Direction shootDirection = enemyTactics.attackDirection(playerCoordinates, coordinates);
        if(shootDirection != null) {
            BulletStatistics bulletStatistics = new BulletStatistics(characterStatistics.getDamage(), characterStatistics.getShotSpeed(), false);
            return bulletFactory.getBullet(shootDirection, coordinates, bulletStatistics);
        }
        else {
            return null;
        }
    }
}
