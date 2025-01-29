import java.util.ArrayList;

public class MatchResult {
    private String teams;
    private ArrayList<String> goalScorers;


    public MatchResult(String teams, ArrayList<String> goalScorers){
        this.teams = teams;
        this.goalScorers = goalScorers;
    }



    public ArrayList<String> getGoalScorers(){
        return goalScorers;
    }


    @Override
    public String toString() {
        return "Teams: " + teams + " - Goalscoreres: " + goalScorers + "\n";
    }
}
