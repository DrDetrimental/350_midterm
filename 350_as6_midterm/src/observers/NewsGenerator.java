package observers;

import interfaces.Subscriber;
import objects.Team;

public class NewsGenerator implements Subscriber{
	
	private String newsTitle;

	@Override
	public void update(Team team1, Team team2, boolean gameOver) {
		
		if (gameOver) {
			newsTitle = generateNewsTitle(team1, team2);
		}
		
	}
	
	private String generateNewsTitle(Team team1, Team team2) {
		
		if (team1.getScore() - team2.getScore() > 0) {
			if (team1.getScore() - team2.getScore() < 15) {
				return "The " + team1.getName() + " narrowly beat the " + team2.getName() + " recently with a score of " + team1.getScore() + " - " + team2.getScore();
			} else {
				return "The " + team1.getName() + " comfortably won against the " + team2.getName() + " last game with a score of " + team1.getScore() + " - " + team2.getScore();
			}
		} else {
			if (team1.getScore() - team2.getScore() > -15) {
				return "The " + team2.getName() + " narrowly beat the " + team1.getName() + " recently with a score of " + team2.getScore() + " - " + team1.getScore();
			} else {
				return "The " + team2.getName() + " comfortably won against the " + team1.getName() + " last game with a score of " + team2.getScore() + " - " + team1.getScore();
			}
		}
		
	}
	
	public String getNewsTitle() {
		
		return newsTitle;
		
	}

}
