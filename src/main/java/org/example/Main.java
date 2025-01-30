package org.example;

public class Main {
    public static void main(String[] args) {
        FootballScoreboard scoreboard = new FootballScoreboard();

        try {
            scoreboard.startMatch("Mexico", "Canada");
            scoreboard.startMatch("Spain", "Brazil");
            scoreboard.startMatch("Germany", "France");
            scoreboard.startMatch("Uruguay", "Italy");
            scoreboard.startMatch("Argentina", "Australia");

            scoreboard.updateScore("Mexico", "Canada", 0, 5);
            scoreboard.updateScore("Spain", "Brazil", 10, 2);
            scoreboard.updateScore("Germany", "France", 2, 2);
            scoreboard.updateScore("Uruguay", "Italy", 6, 6);
            scoreboard.updateScore("Argentina", "Australia", 3, 1);

            System.out.println("Summary:");
            scoreboard.getSummary().forEach(System.out::println);

            scoreboard.finishMatch("Germany", "France");

            System.out.println("\nSummary after finishing Germany vs France:");
            scoreboard.getSummary().forEach(System.out::println);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
