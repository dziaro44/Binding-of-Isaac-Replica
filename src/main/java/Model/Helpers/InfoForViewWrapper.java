package Model.Helpers;

import Model.Characters.CharacterStatistics;
import Model.Characters.CharacterInfo;

import java.util.LinkedList;

public class InfoForViewWrapper {

    private CharacterInfo player;
    private CharacterStatistics characterStatistics;

    private LinkedList<CharacterInfo> enemies = new LinkedList<>();
    private LinkedList<PhysicalObject> playerBullets = new LinkedList<>();
    private LinkedList<PhysicalObject> enemiesBullets = new LinkedList<>();

    private String currentLevel;
    private String currentRoom;

    public CharacterInfo getPlayer() {
        return player;
    }

    public void setPlayer(CharacterInfo player) {
        this.player = player;
    }

    public void setCharacterStatistics(CharacterStatistics characterStatistics) { this.characterStatistics = characterStatistics; }
    public CharacterStatistics getCharacterStatistics() { return characterStatistics; }

    public LinkedList<CharacterInfo> getEnemies() {
        return enemies;
    }

    public LinkedList<PhysicalObject> getPlayerBullets() {
        return playerBullets;
    }

    public LinkedList<PhysicalObject> getEnemiesBullets() {
        return enemiesBullets;
    }

    public void setCurrentLevel(String currentLevel) { this.currentLevel = currentLevel; }
    public String getCurrentLevel() { return currentLevel; }

    public void setCurrentRoom(String currentRoom) { this.currentRoom = currentRoom; }
    public String getCurrentRoom() { return currentRoom; }
}
