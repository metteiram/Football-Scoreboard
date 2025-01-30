# Football-Scoreboard
# Overview

This project is a Live Football World Cup Scoreboard implemented as a simple Java library. It allows tracking of ongoing football matches, updating scores, and retrieving a summary of all active matches sorted by their total score.

The library follows SOLID principles, Clean Code practices, and Test-Driven Development (TDD) using JUnit 5 for testing.



# Features

Start a match: Add a new match with an initial score of 0-0.
Update score: Modify the score of an ongoing match.
Finish match: Remove a match from the scoreboard.
Get summary: Retrieve all ongoing matches, sorted by total score (highest first), and by most recently started match in case of ties.

# Prerequisites

Before setting up the project, ensure you have:

- Java JDK 17 (not just JRE!)
- Maven 3.x installed
- IntelliJ IDEA (Recommended IDE)

Install Java JDK 17 (If Not Installed)
Mac (Homebrew)
```
#!/bin/bash
brew install --cask temurin17
```


# Project Setup

1. Clone the Repository
```
git clone <repository_url>
cd FootballScoreboard
```
2. Configure Java and Maven
```
Check Installed JDKs
/usr/libexec/java_home -V
```
✅ Ensure the output includes a JDK (.jdk), NOT just a JRE (.jre).
Set JAVA_HOME (Mac/Linux)
```
export JAVA_HOME=$(/usr/libexec/java_home -v 17)
```
To make it permanent:
```
echo 'export JAVA_HOME=$(/usr/libexec/java_home -v 17)' >> ~/.zshrc
source ~/.zshrc
```
Verify Java & Maven

```
java -version
javac -version
mvn -version
```

# Assumptions & Design Decisions

1. Only one match per team pair: The system does not allow duplicate matches between the same two teams.
2. Matches start with a score of 0-0: A match is initialized with zero scores.
3. Scores are always non-negative integers: A match cannot have a negative score.
4. Sorting Rules:
- First, by total score in descending order.
- If scores are tied, by most recent match first.
5. In-Memory Storage: The scoreboard is stored in an in-memory list for simplicity.
6. Test-Driven Development (TDD): The project follows a strict write test first, then implement methodology.

