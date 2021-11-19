package Model.Characters.Enemy.Tactics;

import Model.Characters.CharacterStatistics;

public abstract class EnemyTacticsClass implements EnemyTactics {
    protected final CharacterStatistics characterStatistics;

    public EnemyTacticsClass(CharacterStatistics characterStatistics) {
        this.characterStatistics = characterStatistics;
    }
}
