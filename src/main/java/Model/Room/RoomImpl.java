package Model.Room;
import Model.Characters.Enemy.Enemy;

import java.util.LinkedList;
import java.util.List;

public class RoomImpl implements Room {

    private LinkedList<Enemy> enemies;

    public void setCharacters(LinkedList<Enemy> enemies) {
        this.enemies = enemies;
    }

    public LinkedList<Enemy> getEnemies() {
        return enemies;
    }

    public void removeEnemies(List<Enemy> enemiesToRemove) {
        enemies.removeAll(enemiesToRemove);
    }

    public boolean isCleared() {
        return enemies.isEmpty();
    }

}
