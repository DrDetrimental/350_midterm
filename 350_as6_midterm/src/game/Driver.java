package game;

import java.util.Scanner;

import observers.NewsGenerator;
import observers.ScorePredictor;
import observers.WinTracker;

public class Driver {
	
	public static void main(String[] args) {
		
		boolean loop = true;
		String userInput;
		Scanner user = new Scanner(System.in);
		GameData game = new GameData();
		ScorePredictor scorePredictor = new ScorePredictor();
		WinTracker winTracker = new WinTracker();
		NewsGenerator newsGenerator = new NewsGenerator();
		
		game.registerSubscriber(scorePredictor);
		game.registerSubscriber(winTracker);
		game.registerSubscriber(newsGenerator);
		
		System.out.print("Welcome to Basketball Game Simulator 2022.");
		while (loop) {
			if (game.isOver()) {
				
				System.out.println(" Enter the number of the option you'd like and press Enter:\n"
						+ "1. Start a new match\n"
						+ "2. Show prediction stats\n"
						+ "3. Show past game results\n"
						+ "4. Generate news headline for last game\n"
						+ "5. Quit");
				
				userInput = user.next();
				
				if (userInput.equals("1")) {
					game.startGame();
				} else if (userInput.equals("2")) {
					System.out.println("Correct predictions: " + scorePredictor.getCorrectPredictions());
				} else if (userInput.equals("3")) {
					System.out.println(winTracker.getMatches());
				} else if (userInput.equals("4")) {
					if (newsGenerator.getNewsTitle() != null) {
						System.out.println(newsGenerator.getNewsTitle());
					} else {
						System.out.println("There doesn't seem to be a prior game to write about.");
					}
				} else if (userInput.equals("5")) {
					loop = false;
				} else {
					System.out.println("Your input is bad and you should feel bad. Try again.");
				}
			} else {
				
				System.out.println(" Enter the number of the option you'd like and press Enter:\n"
						+ "1. Play a quarter\n"
						+ "2. Show current scores\n"
						+ "3. Show current prediction for next quarter scores\n"
						+ "4. Show prediction stats\n"
						+ "5. Show past game results\n"
						+ "6. Generate news headline for last game\n"
						+ "7. Quit");
				
				userInput = user.next();
				
				if (userInput.equals("1")) {
					game.playQuarter();
				} else if (userInput.equals("2")) {
					System.out.println(game.getScores());
				} else if (userInput.equals("3")) {
					System.out.println(scorePredictor.getPrediction());
				} else if (userInput.equals("4")) {
					System.out.println("Correct predictons: " + scorePredictor.getCorrectPredictions());
				} else if (userInput.equals("5")) {
					System.out.println(winTracker.getMatches());
				} else if (userInput.equals("6")) {
					if (newsGenerator.getNewsTitle() != null) {
						System.out.println(newsGenerator.getNewsTitle());
					} else {
						System.out.println("There doesn't seem to be a prior game to write about.");
					}
				} else if (userInput.equals("7")) {
					loop = false;
				} else {
					System.out.println("Your input is bad and you should feel bad. Try again.");
				}
			}
		}
	}
}
