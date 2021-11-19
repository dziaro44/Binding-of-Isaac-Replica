package Model.Bullet;

import Model.Helpers.NullDirectionException;
import Model.Helpers.PhysicalObject;

public interface Bullet extends PhysicalObject {

    void move() throws NullDirectionException;
    int getDamage();
    boolean isShotByPlayer();
    boolean didHitWall();
}
