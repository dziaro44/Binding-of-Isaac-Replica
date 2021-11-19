package Model.Characters.Player;

import Model.Bullet.Bullet;
import Model.Characters.Character;
import Model.Helpers.Direction;
import Model.Helpers.NullDirectionException;

public interface Player extends Character {
    void move(Direction direction) throws NullDirectionException;
    Bullet throwBullet(Direction direction);
}
