package org.example;

import java.util.*;

class Match {
    private final String homeTeam;
    private final String awayTeam;
    private int homeScore;
    private int awayScore;
    private final long startTime;

    public Match(String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = 0;
        this.awayScore = 0;
        this.startTime = System.nanoTime();
    }

    public void updateScore(int homeScore, int awayScore) {
        if (homeScore < 0 || awayScore < 0) {
            throw new IllegalArgumentException("Scores cannot be negative.");
        }
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    public int getTotalScore() {
        return homeScore + awayScore;
    }

    public String getIdentifier() {
        return homeTeam + " vs " + awayTeam;
    }

    @Override
    public String toString() {
        return homeTeam + " " + homeScore + " - " + awayTeam + " " + awayScore;
    }
}

public class FootballScoreboard {
    private final List<Match> matches = new ArrayList<>();

    public void startMatch(String homeTeam, String awayTeam) {
        if (matches.stream().anyMatch(m -> m.getIdentifier().equals(homeTeam + " vs " + awayTeam))) {
            throw new IllegalArgumentException("Match already in progress.");
        }
        matches.add(new Match(homeTeam, awayTeam));
    }

    public void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        Match match = matches.stream()
                .filter(m -> m.getIdentifier().equals(homeTeam + " vs " + awayTeam))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Match not found."));
        match.updateScore(homeScore, awayScore);
    }

    public void finishMatch(String homeTeam, String awayTeam) {
        matches.removeIf(m -> m.getIdentifier().equals(homeTeam + " vs " + awayTeam));
    }

    public List<String> getSummary() {
        return matches.stream()
                .sorted(Comparator.comparingInt(Match::getTotalScore).reversed()
                        .thenComparing(matches::indexOf, Comparator.reverseOrder())) // Sorting by recency
                .map(Match::toString)
                .toList();

}
}
