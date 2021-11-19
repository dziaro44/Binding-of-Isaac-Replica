package Model;

import Model.Bullet.Bullet;
import Model.Bullet.BulletFactory;
import Model.Characters.CharacterInfo;
import Model.Characters.CharacterStatistics;
import Model.Characters.Enemy.Enemy;
import Model.Characters.HealthWrongValueException;
import Model.Characters.Player.PlayerImpl;
import Model.Helpers.*;
import com.google.inject.Inject;

import static Model.Helpers.Constants.*;

public class GameModel {

    @Inject
    private Map map;

    @Inject
    private BulletFactory bulletFactory;

    private PlayerImpl player;
    private LevelModel levelModel;

    private boolean ChoosingBonusActive = false;
    private boolean BonusChose = false;

    public void prepareGame() throws HealthWrongValueException {
        player = new PlayerImpl(
                bulletFactory,
                new CharacterStatistics(PLAYER_START_HP, PLAYER_START_DMG ,PLAYER_START_SPEED, PLAYER_START_ATTACK_DELAY, PLAYER_START_SHOT_SPEED),
                new Coordinates(ROOM_WIDTH / 2, ROOM_HEIGHT / 2),
                new Shape(PLAYER_RADIUS)
        );

        levelModel = new LevelModel(player, map.getCurrentRoom());
    }

    public void resetGame() {
        map.reset();
    }

    public void goToNextLevel() throws HealthWrongValueException {
        levelModel.setCurrentRoom(map.getCurrentRoom());
        player.setCoordinates(new Coordinates(ROOM_WIDTH / 2, ROOM_HEIGHT / 2));
    }

    public void setChoosingBonusActive(boolean choosingBonusActive) {
        ChoosingBonusActive = choosingBonusActive;
    }

    public void setBonusChose(boolean BonusChose) {
        this.BonusChose = BonusChose;
    }

    public boolean isChoosingBonusActive() {
        return ChoosingBonusActive;
    }

    public boolean isBonusChose() {
        return BonusChose;
    }

    public boolean isCleared() {
        return levelModel.isCleared();
    }

    public boolean isPlayerDead() {
        return levelModel.isPlayerDead();
    }

    public boolean isCurrentRoomLast() {
        return map.isCurrentRoomLast();
    }

    public InfoForViewWrapper makeStep(PlayerAction playerAction) throws HealthWrongValueException, NullDirectionException {
        levelModel.makeStep(playerAction);
        InfoForViewWrapper infoForViewWrapper = new InfoForViewWrapper();
        infoForViewWrapper.setPlayer(new CharacterInfo(player, player.getCharacterStatistics().getHealthPoints(), player.getCharacterStatistics().getBaseHealthPoints()));

        for(Enemy enemy : levelModel.getCurrentRoom().getEnemies()) {
            infoForViewWrapper.getEnemies().add(new CharacterInfo(enemy, enemy.getCharacterStatistics().getHealthPoints(), enemy.getCharacterStatistics().getBaseHealthPoints()));
        }
        for(Bullet bullet : levelModel.getBulletList()) {
            if(bullet.isShotByPlayer()) {
                infoForViewWrapper.getPlayerBullets().add(bullet);
            }
            else {
                infoForViewWrapper.getEnemiesBullets().add(bullet);
            }
        }
        infoForViewWrapper.setCurrentLevel(Integer.toString(map.getCurrentLevel()));
        infoForViewWrapper.setCurrentRoom(Integer.toString(map.getCurrentRoomNr()));
        infoForViewWrapper.setCharacterStatistics(player.getCharacterStatistics());

        if(ChoosingBonusActive) {
            if(playerAction.isUpgrading()) {
                if (map.isCurrentRoomLast()) {
                    if (playerAction.isUpgradeHealth()) {
                        player.addHealth(PLAYER_BIG_HP_BONUS);
                    }
                    else if (playerAction.isUpgradeDamage()) {
                        player.addDamage(PLAYER_BIG_DMG_BONUS);
                    }
                    else if (playerAction.isUpgradeSpeed()) {
                        player.addSpeed(PLAYER_BIG_SPEED_BONUS);
                    }
                    else if (playerAction.isUpgradeAttackDelay()) {
                        player.subtractAttackDelay(PLAYER_BIG_ATTACK_DELAY_BONUS);
                    }
                }
                else {
                    if (playerAction.isUpgradeHealth()) {
                        player.addHealth(PLAYER_SMALL_HP_BONUS);
                    }
                    else if (playerAction.isUpgradeDamage()) {
                        player.addDamage(PLAYER_SMALL_DMG_BONUS);
                    }
                }
                goToNextLevel();
                ChoosingBonusActive = false;
                BonusChose = true;
            }
        }
        return infoForViewWrapper;
    }
}
