package game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import interfaces.Subject;
import interfaces.Subscriber;
import objects.Team;

public class GameData implements Subject{
	
	private Random randGen = new Random();
	private ArrayList<Team> teamList;
	private Team team1;
	private Team team2;
	private int quarter = 0;
	private boolean gameOver = true;
	private ArrayList<Subscriber> subscriberList;
	
	public GameData() {
		
		populateTeams();
		subscriberList = new ArrayList<Subscriber>();
		
	}

	@Override
	public void registerSubscriber(Subscriber s) {
		
		subscriberList.add(s);
		
	}

	@Override
	public void unregisterSubscriber(Subscriber s) {
		
		subscriberList.remove(subscriberList.indexOf(s));
		
	}

	@Override
	public void notifySubscribers() {
		
		for (Iterator<Subscriber> i = subscriberList.iterator(); i.hasNext();) {
			Subscriber s = i.next();
			s.update(team1, team2, gameOver);
		}
		
	}
	
	public void playQuarter() {
		
		System.out.println("Playing quarter " + quarter);
		team1.setScore(team1.getScore() + randGen.nextInt(60));
		team2.setScore(team2.getScore() + randGen.nextInt(60));
		quarter++;
		
		if (quarter >= 5) {
			if (team1.getScore() != team2.getScore()) {
				endGame();
			}
		}
		
	}
	
	public void startGame() {
		
		gameOver = false;
		quarter = 1;
		team1 = teamList.get(randGen.nextInt(teamList.size()));
		team2 = teamList.get(randGen.nextInt(teamList.size()));
		while (team1.getName().equals(team2.getName())) {
			team2 = teamList.get(randGen.nextInt(teamList.size()));
		}
		
		System.out.println("Starting game between the " + team1.getName() + " and the " + team2.getName());
		notifySubscribers();
		
	}
	
	public void endGame() {
		
		gameOver = true;
		notifySubscribers();
		team1.setScore(0);
		team2.setScore(0);
		
	}
	
	private void populateTeams() {
		
		Team team = new Team("Golden State Warriors");
		teamList.add(team);
		team = new Team("Boston Celtics");
		teamList.add(team);
		team = new Team("Los Angeles Lakers");
		teamList.add(team);
		team = new Team("Brooklyn Nets");
		teamList.add(team);
		team = new Team("Phoenix Suns");
		teamList.add(team);
		team = new Team("Toronto Raptors");
		teamList.add(team);
		team = new Team("Philadelphia 76ers");
		teamList.add(team);
		team = new Team("Milwaukee Bucks");
		teamList.add(team);
		team = new Team("Dallas Mavericks");
		teamList.add(team);
		team = new Team("Miami Heat");
		teamList.add(team);
		
	}
	
	public boolean isOver() {
		
		return gameOver;
		
	}
	
	public String getScores() {
		return team1.getName() + " - " + team1.getScore() + " vs. " + team2.getScore() + " - " + team2.getName();
	}
	
}
