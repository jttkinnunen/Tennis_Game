
public class TennisGame {
	
	private int p1;
	private int p2;
	private int scoreFlag = 0;
	
	public TennisGame() {
		// TO BE IMPLEMENTED
		p1 = 0;
		p2 = 0;
		System.out.println("1 = point to player1");
		System.out.println("2 = point to player2");
		System.out.println("0 = End Game");
		
	}

	public String getScore() {
		//System.out.println("I am method for displaying score");
		// Here is the format of the scores: "player1Score - player2Score"
		// "0 - 0"
		// "15 - 15"
		// "30 - 30"
		// "deuce"
		// "15 - 0", "0 - 15"
		// "30 - 0", "0 - 30"
		// "40 - 0", "0 - 40"
		// "30 - 15", "15 - 30"
		// "40 - 15", "15 - 40"
		// "advantage player1"
		// "advantage player2"
		// "game player1"
		// "game player2"

		if(scoreFlag == 1) {
			resetPoints();
			scoreFlag=0;		
		}
		
		if (hasWinner()) {
			scoreFlag = 1;
			return playerWithHighestScore() + " wins. Press any key and Enter to start new game";
		}
		
		if (hasAdvantage()) { 
			return "Advantage " + playerWithHighestScore(); 
		}
		
		if (isDeuce()) {
			return "Deuce";
		}
				
		return translateScore(p1) + " - " + translateScore(p2);
		
		
	}
	private boolean isDeuce() {
		return p1 >= 3 && p2 == p1;
	}
	
	private String playerWithHighestScore() {
		if (p1 > p2) {
			return "player1";
		} else {
			return "player2";
		}
	}
	
	private boolean hasWinner() {
		if(p2 >= 4 && p2 >= p1 + 2 )
			return true;
		if(p1 >= 4 && p1 >= p2 + 2)
			return true;
		return false;
	}
	
	private boolean hasAdvantage() {
		if (p2 >= 4 && p2 == p1 + 1)
			return true;
		if (p1 >= 4 && p1 == p2 + 1)
			return true;
		
		return false;

	}

	public void p1s() {
		p1++;
	}

	public void p2s() {
		p2++;
	}
	
	public void resetPoints() {
		p1=0;
		p2=0;
	}

	private String translateScore(int score) {
		switch (score) {
		case 3:
			return "Forty";
		case 2:
			return "Thirty";
		case 1: 
			return "Fifteen";
		case 0:
			return "Love";
		}
		throw new IllegalArgumentException("Illegal score: " + score);
	}
}
