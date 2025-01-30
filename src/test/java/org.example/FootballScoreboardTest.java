package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FootballScoreboardTest {

    private FootballScoreboard scoreboard;

    @BeforeEach
    void setUp() {
        scoreboard = new FootballScoreboard();
    }

    @Test
    void testStartMatch() {
        scoreboard.startMatch("Mexico", "Canada");
        List<String> summary = scoreboard.getSummary();
        assertEquals(1, summary.size());
        assertEquals("Mexico 0 - Canada 0", summary.get(0));
    }

    @Test
    void testStartDuplicateMatchThrowsException() {
        scoreboard.startMatch("Mexico", "Canada");
        assertThrows(IllegalArgumentException.class, () -> scoreboard.startMatch("Mexico", "Canada"));
    }

    @Test
    void testUpdateScore() {
        scoreboard.startMatch("Mexico", "Canada");
        scoreboard.updateScore("Mexico", "Canada", 2, 1);
        List<String> summary = scoreboard.getSummary();
        assertEquals("Mexico 2 - Canada 1", summary.get(0));
    }

    @Test
    void testUpdateNonexistentMatchThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> scoreboard.updateScore("Spain", "Brazil", 3, 2));
    }

    @Test
    void testFinishMatch() {
        scoreboard.startMatch("Mexico", "Canada");
        scoreboard.finishMatch("Mexico", "Canada");
        assertTrue(scoreboard.getSummary().isEmpty());
    }

    @Test
    void testSummaryOrder() {
        scoreboard.startMatch("Mexico", "Canada");
        scoreboard.updateScore("Mexico", "Canada", 0, 5);

        scoreboard.startMatch("Spain", "Brazil");
        scoreboard.updateScore("Spain", "Brazil", 10, 2);

        scoreboard.startMatch("Germany", "France");
        scoreboard.updateScore("Germany", "France", 2, 2);

        scoreboard.startMatch("Uruguay", "Italy");
        scoreboard.updateScore("Uruguay", "Italy", 6, 6);

        scoreboard.startMatch("Argentina", "Australia");
        scoreboard.updateScore("Argentina", "Australia", 3, 1);

        List<String> summary = scoreboard.getSummary();
        assertEquals("Uruguay 6 - Italy 6", summary.get(0));
        assertEquals("Spain 10 - Brazil 2", summary.get(1));
    }
}
