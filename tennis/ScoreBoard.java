package tennis;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScoreBoard {

	private int player1Point;
	private int player2Point;
	
	private int player1GameScore;
	private int player2GameScore;
	
	private int player1SetScore;
	private int player2SetScore;

	private int player1TieBreakPoint;
	private int player2TieBreakPoint;

	private boolean tieBreak = false;

	private boolean set; // true 5경기 false 3경기
	private boolean game = true;

	public void scorePlayer1() {
		if (!game) {
			return;
		}

		if (tieBreak) {
			player1TieBreakPoint++;
			checkTieBreakWinner();
			return;
		}

		player1Point++;
		checkGameWinner();
	}

	public void scorePlayer2() {
		if (!game) {
			return;
		}
		
		if (tieBreak) {
			player2TieBreakPoint++;
			checkTieBreakWinner();
			return;
		}
		
		player2Point++;
		checkGameWinner();
	}

	private void checkGameWinner() {
		if (player1Point >= 4 || player2Point >= 4) {
			int diff = player1Point - player2Point;

			if (diff >= 2) {
				player1GameScore++;
				resetPoint();
				checkSetWinner();
			} else if (diff <= -2) {
				player2GameScore++;
				resetPoint();
				checkSetWinner();
			}
		}
	}
	private void checkSetWinner() {
		int diff = player1GameScore - player2GameScore;

		if (player1GameScore == 6 && player2GameScore == 6) {
            tieBreak = true;
            resetPoint();
            System.out.println("Tie Break Start!");
            return;
        }
		
		if (player1GameScore >= 6 && diff >= 2) {
			player1SetScore++;
			resetGameScore();
			checkWinner();
		} else if (player2GameScore >= 6 && diff <= -2) {
			player2SetScore++;
			resetGameScore();
			checkWinner();
		}
	}

	private void checkWinner() {
		int win = set ? 3 : 2;

		if (player1SetScore == win) {
			System.out.println("Player 1 Winner");
			game = false;
		} else if (player2SetScore == win) {
			System.out.println("Player 2 Winner");
			game = false;
		}
	}

	private void checkTieBreakWinner() {
		int diff = player1TieBreakPoint - player2TieBreakPoint;

		if (player1TieBreakPoint >= 7 && diff >= 2) {
			player1SetScore++;

			player1GameScore++;

			resetTieBreak();
			resetGameScore();
			checkWinner();

		} else if (player2TieBreakPoint >= 7 && diff <= -2) {
			player2SetScore++;

			player2GameScore++;

			resetTieBreak();
			resetGameScore();
			checkWinner();
		}
	}
	private void resetPoint() {
		setPlayer1Point(0);
		setPlayer2Point(0);
	}

	private void resetGameScore() {
		setPlayer1GameScore(0);
		setPlayer2GameScore(0);       
	}

	private void resetTieBreak() {
		tieBreak = false;
		setPlayer1TieBreakPoint(0);
		setPlayer2TieBreakPoint(0);

	}
}
