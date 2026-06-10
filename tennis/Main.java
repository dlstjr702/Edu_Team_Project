package tennis;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("플레이어 이름을 입력하세요 ");

		String playerA = scanner.next();
		String playerB = scanner.next();

		System.out.println("경기 세트 수를 입력하세요 true 5세트 false 3세트");
		boolean set = scanner.nextBoolean();
		
		Player p1 = new Player(playerA);
		Player p2 = new Player(playerB);

		System.out.println(p1);
		System.out.println(p2);

		TennisGame t1 = new TennisGame(p1, p2, set);

		 while (t1.getScoreBoard().isGame()) {
	            System.out.println("엔터를 누르면 다음 포인트가 진행됩니다.");
	            scanner.nextLine();

	            int randomNum = (int) (Math.random() * 2) + 1; // 1 or 2
	            t1.pointWinner(randomNum);

	            System.out.println("=".repeat(50));
	            System.out.println(t1.getPlayer1().getName());
	            System.out.println("Player1 세트승: " + t1.getScoreBoard().getPlayer1setScore());
	            System.out.println("Player1 게임: " + t1.getScoreBoard().getPlayer1GameScore());

	            System.out.println();
	            
	            System.out.println(t1.getPlayer2().getName());
	            System.out.println("Player2 세트승: " + t1.getScoreBoard().getPlayer2setScore());
	            System.out.println("Player2 게임: " + t1.getScoreBoard().getPlayer2GameScore());
	            
	            
	            System.out.println(t1.dispScoreBoard());
	            System.out.println("=".repeat(50));
	        }
	}

}
