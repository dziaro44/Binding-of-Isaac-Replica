package Model.Room;

import Model.Characters.Enemy.EnemiesFactory;
import Model.Characters.Enemy.Enemy;
import Model.Characters.Enemy.Tactics.EnemyType;
import Model.Characters.HealthWrongValueException;
import com.google.inject.Inject;

import java.util.LinkedList;
import java.util.Random;

public class RoomFactoryImpl  implements RoomFactory {

    private final EnemiesFactory enemiesFactory;

    @Inject
    public RoomFactoryImpl(EnemiesFactory enemiesFactory) {
        this.enemiesFactory = enemiesFactory;
    }

    public Room getRoom(int currentLevel) throws HealthWrongValueException {
        Room room = new RoomImpl();

        // Tworzenie przeciwników - i wrzucenie do jakiejś listy

        LinkedList<Enemy> enemyList = new LinkedList<>();
        Random random = new Random();
        int rand;
        for(int i=1;i<=currentLevel;i++) {
            rand = random.nextInt(3);
            if (rand == 1) enemyList.add(enemiesFactory.getEnemy(i, EnemyType.SHOOTING_ZOMBIE));
            else if(rand == 2) enemyList.add(enemiesFactory.getEnemy(i, EnemyType.HORIZONTAL_GUY));
            else enemyList.add(enemiesFactory.getEnemy(i, EnemyType.ZOMBIE));
        }

        room.setCharacters(enemyList);
        return room;
    }
}
