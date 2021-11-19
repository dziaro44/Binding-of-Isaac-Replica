package Model.Room;

import Model.Characters.Enemy.Enemy;

import java.util.LinkedList;
import java.util.List;

public interface Room {

    void setCharacters(LinkedList<Enemy> enemies);
    LinkedList<Enemy> getEnemies();
    void removeEnemies(List<Enemy> enemiesToRemove);
    boolean isCleared();
}
