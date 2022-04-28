package observers;

import java.util.ArrayList;

import interfaces.Subscriber;
import objects.Team;

public class ScorePredictor implements Subscriber{
	
	private ArrayList<Integer> team1GameScores;
	ArrayList<Integer> team2GameScores;
	private int team1Score;
	private int team2Score;
	private int team1Prediction;
	private int team2Prediction;
	private String team1Name;
	private String team2Name;

	@Override
	public void update(Team team1, Team team2) {
		
		team1Score = team1.getScore();
		team2Score = team2.getScore();
		team1Name = team1.getName();
		team2Name = team2.getName();
		
		team1GameScores.add(team1Score);
		team2GameScores.add(team2Score);
		
		generatePrediction();
		
	}
	
	private void generatePrediction() {
		
		team1Prediction = team1Score + getAvgScorePerQuarter(team1GameScores);
		team2Prediction = team2Score + getAvgScorePerQuarter(team2GameScores);
		
	}
	
	private int getAvgScorePerQuarter(ArrayList<Integer> scores) {
		int scoreSum = 0;
		for (int i = 0; i < scores.size(); i++) {
			scoreSum += scores.get(i);
		}
		return scoreSum/scores.size();
	}
	
	public String getPrediction() {
		return "I predict " + team1Name + " will have " + team1Prediction + " points and " + team2Name + " will have " + team2Prediction + " points next quarter.";
	}

}
