import java.io.IOException;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        // Reader fil og tæller antal målene af hvert målscorer og derefter printer dem alle ud
        try {
            Statistics statistics = new Statistics("src/Euro2024QualifyingRound.csv");

            statistics.getGoalScorersWithTotals();

            // Man kan ved denne metode selv finde "value'en" ved at indskrive "key'en" ind, en slags search bar
            System.out.println(statistics.getNumberOfGoals("wind"));


            System.out.println(statistics.getGoalScorerers());

        } catch(IOException e){
            System.out.println("Error:  " + e.getMessage());
        }

        //Reader fil og printer holdene ud og derefter målscorer
        try {
            MatchResultFileReader reader = new MatchResultFileReader("src/Euro2024QualifyingRound.csv");

            System.out.println(reader.readFile());
        } catch(IOException e){
            System.out.println("Error:  " + e.getMessage());
        }


    }
}
