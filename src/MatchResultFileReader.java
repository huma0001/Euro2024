import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatchResultFileReader {
    private File file;


    public MatchResultFileReader(String filename) throws FileNotFoundException {
        file = new File(filename);
    }


    public List<MatchResult> readFile() {

        List<MatchResult> matchResults = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] attributes = line.split(";");
                ArrayList<String> matchResultList = new ArrayList<>();

                if (attributes.length > 1) {

                    String[] goalScoreres = attributes[1].split(",");

                    for (String goalScorere : goalScoreres) {
                        matchResultList.add(goalScorere);
                    }

                    matchResults.add(new MatchResult(attributes[0], matchResultList));
                }

            }
        } catch (IOException e) {
            System.out.println("Error has occurred: " + e.getMessage());
        }

        return matchResults;
    }


}
