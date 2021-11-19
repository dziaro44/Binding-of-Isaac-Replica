package Model;

import Model.Bullet.Bullet;
import Model.Characters.Enemy.Enemy;
import Model.Characters.HealthWrongValueException;
import Model.Characters.Player.Player;
import Model.Helpers.CollisionDetector;
import Model.Helpers.Coordinates;
import Model.Helpers.NullDirectionException;
import Model.Helpers.PlayerAction;
import Model.Room.Room;

import java.util.LinkedList;
import java.util.List;

public class LevelModel {

    private Room currentRoom;
    private List<Bullet> bulletList = new LinkedList<>();
    private Player player;

    public LevelModel(Player player, Room currentRoom) {
        this.player = player;
        this.currentRoom = currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public boolean isCleared() {
        return currentRoom.isCleared();
    }

    public Room getCurrentRoom() { return currentRoom; }

    public List<Bullet> getBulletList() { return bulletList; }

    public void makeStep(PlayerAction playerAction) throws NullDirectionException, HealthWrongValueException {
        if(playerAction.isCheatKillAll()) {
            currentRoom.getEnemies().clear();
            playerAction.setCheatKillAll(false);
        }

        makePlayerAction(playerAction);
        makeEnemyAction(player.getCoordinates());
        makeBulletMoves();
        checkCollisions();
    }

    public boolean isFinished() {
        return currentRoom.isCleared();
    }

    public boolean isPlayerDead() {
        return !player.isAlive();
    }

    private void makePlayerAction(PlayerAction playerAction) throws NullDirectionException {
        player.reduceTimeToAttack();

        if (playerAction.isShooting() && player.canAttack()) {
            bulletList.add(player.throwBullet(playerAction.getShootDirection()));
        }
        if (playerAction.isMoving()) {
            player.move(playerAction.getMoveDirection());
        }
    }

    private void makeEnemyAction(Coordinates playerCoordinates) {
        for (Enemy enemy: currentRoom.getEnemies()) {
            enemy.reduceTimeToAttack();

            enemy.move(playerCoordinates); // Check if not collision with someone else
            if(enemy.canAttack()) {
                Bullet bullet = enemy.throwBullet(playerCoordinates);
                if(bullet != null) {
                    bulletList.add(bullet);// Add shooting
                }
            }
        }
    }

    private void makeBulletMoves() throws NullDirectionException {

        List<Bullet> toRemove = new LinkedList<>();
        for (Bullet bullet : bulletList) {
            bullet.move();
            if (bullet.didHitWall()) {
                toRemove.add(bullet);
            }
        }
        bulletList.removeAll(toRemove);
    }

    private void checkCollisions() throws HealthWrongValueException {
        List<Bullet> bulletsToRemove = new LinkedList<>();
        List<Enemy> enemiesToRemove = new LinkedList<>();
        for (Enemy enemy : currentRoom.getEnemies()) {
            if(CollisionDetector.isCollision(enemy, player)) {
                player.subtractHealth(enemy.getCharacterStatistics().getDamage());
            }
        }
        for (Bullet bullet : bulletList) {
            if(!bullet.isShotByPlayer()) {
                if(CollisionDetector.isCollision(bullet, player)) {
                    player.subtractHealth(bullet.getDamage());
                    bulletsToRemove.add(bullet);
                }
            }
            else {
                for (Enemy enemy : currentRoom.getEnemies()) {
                    if (CollisionDetector.isCollision(bullet, enemy)) {
                        enemy.subtractHealth(bullet.getDamage());
                        bulletsToRemove.add(bullet);
                        if (!enemy.isAlive()) {
                            enemiesToRemove.add(enemy);
                        }
                    }
                }
            }
        }
        bulletList.removeAll(bulletsToRemove);
        currentRoom.removeEnemies(enemiesToRemove);
    }
}
