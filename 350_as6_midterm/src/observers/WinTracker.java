package observers;


import interfaces.Subscriber;
import objects.Team;

public class WinTracker implements Subscriber{
	
	private int matchNumber = 0;
	private int[][] matchScores = new int[50][2];
	private String[][] matchTeams = new String[50][2];
	
	@Override
	public void update(Team team1, Team team2, boolean gameOver) {
		
		if (gameOver) {
			matchScores[matchNumber][0] = team1.getScore();
			matchScores[matchNumber][1] = team2.getScore();
			matchTeams[matchNumber][0] = team1.getName();
			matchTeams[matchNumber][1] = team2.getName();
			matchNumber++;
		}
		
	}
	
	public String getMatches() {
		
		if (matchTeams[0][0] != null) {
			String matchTable = "";
			for (int i = 0; i < matchNumber; i++) {
				matchTable += matchTeams[i][0] + " " + matchScores[i][0] + " vs. " + matchScores[i][1] + " " + matchTeams[i][1] + "\n";
			}
			return matchTable;
		} else {
			return "No match data yet.";
		}
		
	}
	
}
