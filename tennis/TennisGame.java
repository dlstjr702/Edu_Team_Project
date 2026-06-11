package tennis;

import lombok.Getter;

@Getter
public class TennisGame {

    private final Player player1;
    private final Player player2;
    private final ScoreBoard scoreBoard;

    public TennisGame(Player player1, Player player2, boolean set) {
        this.player1 = player1;
        this.player2 = player2;
        this.scoreBoard = new ScoreBoard();
        this.scoreBoard.setSet(set);
    }

    public void pointWinner(int p) {
        if (p == 1) {
            scoreBoard.scorePlayer1();
        } else {
            scoreBoard.scorePlayer2();
        }
    }

    public String dispScoreBoard() {
        return TennisScoreFormatter.format(
                scoreBoard.getPlayer1Point(),
                scoreBoard.getPlayer2Point()
        );
    }
}