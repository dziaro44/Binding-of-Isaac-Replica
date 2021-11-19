package Model.Characters.Enemy;

import Model.Bullet.Bullet;
import Model.Characters.Character;
import Model.Helpers.Coordinates;

public interface Enemy extends Character {
    // Enemy poruszac sie bedzie wedlug podanej mu strategii chodzenia, wiec kontroler gry nie musi wiedziec
    // w ktora strone. To bedzie wiedial kontroler enemy
    void move(Coordinates playerCoordinates);
    Bullet throwBullet(Coordinates playerCoordinates);
}
