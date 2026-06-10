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
	private int player1setScore;
	private int player2setScore;

	private boolean set; // true 5경기 false 3경기
	private boolean game = true;

	public void scorePlayer1() {
		player1Point++;
		checkGameWinner();
	}

	public void scorePlayer2() {
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

		if (player1GameScore >= 6 && diff >= 2) {
			player1setScore++;
			resetGameScore();
			checkWinner();
		} else if (player2GameScore >= 6 && diff <= -2) {
			player2setScore++;
			resetGameScore();
			checkWinner();
		}
	}

	private void checkWinner() {
		int win = set ? 3 : 2;
			
		  if (player1setScore == win) {
	            System.out.println("Player 1 Winner");
	            game = false;
	        } else if (player2setScore == win) {
	            System.out.println("Player 2 Winner");
	            game = false;
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
}
