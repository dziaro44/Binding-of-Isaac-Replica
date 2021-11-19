package Model.Characters.Player;

import Model.Bullet.Bullet;
import Model.Bullet.BulletFactory;
import Model.Bullet.BulletStatistics;
import Model.Characters.CharacterImpl;
import Model.Characters.CharacterStatistics;
import Model.Helpers.*;

public class PlayerImpl extends CharacterImpl implements Player {

    public PlayerImpl(BulletFactory bulletFactory, CharacterStatistics characterStatistics, Coordinates coordinates, Shape shape) {
        super(bulletFactory, characterStatistics, coordinates, shape);
    }

    @Override
    public void move(Direction direction) throws NullDirectionException {
        Coordinates newCoordinates = coordinates.getNewCoordinates(direction, characterStatistics.getSpeed());

        if(MoveValidator.checkMove(newCoordinates))
            setCoordinates(newCoordinates);
    }

    @Override
    public Bullet throwBullet(Direction direction) {
        turnsUntilAttack = characterStatistics.getAttackDelay();

        BulletStatistics bulletStatistics = new BulletStatistics(characterStatistics.getDamage(), characterStatistics.getShotSpeed(), true);
        return bulletFactory.getBullet(direction, coordinates, bulletStatistics);
    }
}
