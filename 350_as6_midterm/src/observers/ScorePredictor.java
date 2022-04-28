package observers;

import java.util.ArrayList;

import interfaces.Subscriber;
import objects.Team;

public class ScorePredictor implements Subscriber{
	
	private ArrayList<Integer> team1GameScores;
	ArrayList<Integer> team2GameScores;
	private int team1Prediction = -1;
	private int team2Prediction = -1;
	private int correctPredictions = 0;
	
	private Team team1;
	private Team team2;

	@Override
	public void update(Team team1, Team team2, boolean gameOver) {
		
		this.team1.setScore(team1.getScore());
		this.team2.setScore(team2.getScore());
		this.team1.setName(team1.getName());
		this.team2.setName(team2.getName());
		
		checkPreviousPredictions();
		
		team1GameScores.add(team1.getScore());
		team2GameScores.add(team2.getScore());
		
		if (!gameOver) {		
			generatePrediction();
		}
		
	}
	
	private void generatePrediction() {
		
		team1Prediction = team1.getScore() + getAvgScorePerQuarter(team1GameScores);
		team2Prediction = team2.getScore() + getAvgScorePerQuarter(team2GameScores);
		
	}
	
	private int getAvgScorePerQuarter(ArrayList<Integer> scores) {
		
		int scoreSum = 0;
		for (int i = 0; i < scores.size(); i++) {
			scoreSum += scores.get(i);
		}
		return scoreSum/scores.size();
		
	}
	
	private void checkPreviousPredictions() {
		
		if (team1Prediction != -1) {
			if (team1.getScore() == team1Prediction) {
				correctPredictions++;
			}
		}
		if (team2Prediction != -1) {
			if (team2.getScore() == team2Prediction) {
				correctPredictions++;
			}
		}
		
	}
	
	public String getPrediction() {
		
		return "I predict " + team1.getName() + " will have " + team1Prediction + " points and " + team2.getName() + " will have " + team2Prediction + " points next quarter.";
		
	}
	
	public int getCorrectPredictions() {
		
		return correctPredictions;
				
	}

}
