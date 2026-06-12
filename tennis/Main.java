package tennis;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 단식/복식 선택
        System.out.println("단식/복식을 선택하세요 (true: 복식, false: 단식)");
        boolean isDoubles = scanner.nextBoolean();
        scanner.nextLine();

        Team team1, team2;

        if (isDoubles) {
            System.out.println("팀1 선수 이름 2명을 입력하세요 (공백으로 구분)");
            team1 = new Team(new Player(scanner.next()), new Player(scanner.next()));
            scanner.nextLine();

            System.out.println("팀2 선수 이름 2명을 입력하세요 (공백으로 구분)");
            team2 = new Team(new Player(scanner.next()), new Player(scanner.next()));
            scanner.nextLine();
        } else {
            System.out.println("플레이어 이름을 입력하세요 (공백으로 구분)");
            team1 = new Team(new Player(scanner.next()));
            team2 = new Team(new Player(scanner.next()));
            scanner.nextLine();
        }

        System.out.println("경기 세트 수를 입력하세요 (true: 5세트 / false: 3세트)");
        boolean set = scanner.nextBoolean();
        scanner.nextLine();

        // Team에서 Player 추출해서 TennisGame에 전달 (기존 구조 유지)
        Player p1 = team1.getPlayer1();
        Player p2 = team2.getPlayer1();

        TennisGame t1 = new TennisGame(p1, p2, set);

        while (t1.getScoreBoard().isGame()) {
            System.out.println("엔터를 누르면 다음 포인트가 진행됩니다.");
            scanner.nextLine();

            int randomNum = (int) (Math.random() * 2) + 1;
            t1.pointWinner(randomNum);

            System.out.println("=".repeat(50));
            System.out.println(team1.getTeamName());  // Player 이름 대신 Team 이름 표시
            System.out.println("Team1 세트승: " + t1.getScoreBoard().getPlayer1SetScore());
            System.out.println("Team1 게임: " + t1.getScoreBoard().getPlayer1GameScore());
            if (t1.getScoreBoard().isTieBreak()) System.out.println("타이브레이크 스코어 :" + t1.getScoreBoard().getPlayer1TieBreakPoint());

			System.out.println();

			System.out.println(team2.getTeamName());  // Player 이름 대신 Team 이름 표시
			System.out.println("Team2 세트승: " + t1.getScoreBoard().getPlayer2SetScore());
			System.out.println("Team2 게임: " + t1.getScoreBoard().getPlayer2GameScore());
			if (t1.getScoreBoard().isTieBreak()) System.out.println("타이브레이크 스코어 :" + t1.getScoreBoard().getPlayer2TieBreakPoint());

			if (!t1.getScoreBoard().isTieBreak()) System.out.println(t1.dispScoreBoard());
			System.out.println("=".repeat(50));
        }
    }

}
