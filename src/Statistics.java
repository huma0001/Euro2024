import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Statistics {
    private List<MatchResult> matchResults;
    private File file;

    public Statistics(String filename) throws FileNotFoundException {
        file = new File(filename);
    }



    public Set<String> getGoalScorerers() {
        Set<String> goalScorersSet = new TreeSet<>(); // Use TreeSet for sorted order

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] teamsPlayers = line.split(";");

                if (teamsPlayers.length < 2 || teamsPlayers[1].isEmpty()) {
                    continue; // Skip lines without goal scorers
                }

                String[] goalScorers = teamsPlayers[1].toLowerCase().split(",");

                for (String goalScorer : goalScorers) {
                    if (!goalScorer.isEmpty()) {
                        goalScorersSet.add(goalScorer.trim()); // Add each goal scorer to the set
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }

        return goalScorersSet;
    }



    public Map<String, Integer> getGoalScorersWithTotals() {

        Map<String, Integer> map = new TreeMap<>();

        try {
            Scanner scanner = new Scanner(file);

            while ( scanner.hasNextLine() ) {
                String line = scanner.nextLine();

                String[] teamsPlayers = line.split(";");

                if (teamsPlayers.length < 2 || teamsPlayers[1].isEmpty()) {
                    continue;
                }

                String[] goalScorerers = teamsPlayers[1].toLowerCase().split(",");

                for (String goalscorer : goalScorerers) {
                    if (!goalscorer.isEmpty()) {
                        map.put(goalscorer, map.getOrDefault(goalscorer, 0) + 1);
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("Filen blev  ikke fundet: " + e.getMessage());
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        return map;
    }


    public int getNumberOfGoals(String goalScorerer) {
        Map<String, Integer> map = new TreeMap<>();
        try {
            Scanner scanner = new Scanner(new File("src/Euro2024QualifyingRound.csv"));


            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] teamsPlayers = line.toLowerCase().split(";");

                if (teamsPlayers.length < 2 || teamsPlayers[1].isEmpty()) {
                    continue;
                }

                String[] goalScorerers = teamsPlayers[1].split(",");

                for (String goalscorer : goalScorerers) {
                    if (!goalscorer.isEmpty()) {
                        map.put(goalscorer, map.getOrDefault(goalscorer, 0) + 1);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Filen blev  ikke fundet: " + e.getMessage());
        }

        return map.get(goalScorerer);
    }

}




