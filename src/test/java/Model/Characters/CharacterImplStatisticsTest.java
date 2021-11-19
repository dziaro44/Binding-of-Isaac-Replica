package Model.Characters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CharacterImplStatisticsTest {

    @Test
    public void addAndGetHealth() throws HealthWrongValueException {

        CharacterStatistics characterStatistics = new CharacterStatistics(10, 0, 0, 0, 0);

        characterStatistics.addHealth(10);
        characterStatistics.addHealth(15);
        Integer result = characterStatistics.getHealthPoints();

        Assertions.assertEquals(35, result);
    }

    @Test
    public void subtractAndGetHealth() throws HealthWrongValueException {

        CharacterStatistics characterStatistics = new CharacterStatistics(100, 0, 0, 0, 0);

        characterStatistics.subtractHealth(10);
        characterStatistics.subtractHealth(30);
        Integer result = characterStatistics.getHealthPoints();

        Assertions.assertEquals(60, result);
    }

    @Test
    public void subtractMoreHealthThanAtFirst() throws HealthWrongValueException {

        CharacterStatistics characterStatistics = new CharacterStatistics(10, 0, 0, 0, 0);

        characterStatistics.subtractHealth(10);
        Integer beforeSubtractingMoreResult = characterStatistics.getHealthPoints();
        characterStatistics.subtractHealth(10);
        Integer afterSubtractingMoreResult = characterStatistics.getHealthPoints();

        Assertions.assertEquals(0, beforeSubtractingMoreResult);
        Assertions.assertEquals(0, afterSubtractingMoreResult);
    }

    @Test
    public void negativeValue_HealthWrongValueException() throws HealthWrongValueException {

        CharacterStatistics characterStatistics = new CharacterStatistics(10, 0, 0, 0, 0);

        Assertions.assertThrows(HealthWrongValueException.class, () -> characterStatistics.subtractHealth(-10));
        Assertions.assertThrows(HealthWrongValueException.class, () -> characterStatistics.addHealth(-10));
        Assertions.assertThrows(HealthWrongValueException.class, () -> characterStatistics.setHealthPoints(-10));
        Assertions.assertThrows(HealthWrongValueException.class, () -> new CharacterStatistics(-10, 0, 0, 0, 0));
    }

}