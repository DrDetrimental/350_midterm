package objects;

public class Team {
	
	private String name;
	private int score;
	
	public Team(String name) {
		this.name = name;
		score = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
}
