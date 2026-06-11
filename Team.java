package tennis;


import lombok.Getter;

@Getter
public class Team {
    private Player player1;
    private Player player2; // 단식이면 null
    private boolean isDoubles;

    // 단식용 생성자
    public Team(Player player1) {
        this.player1 = player1;
        this.player2 = null;
        this.isDoubles = false;
    }

    // 복식용 생성자
    public Team(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.isDoubles = true;
    }

    // 팀 이름 표시 (단식: "홍길동", 복식: "홍길동 / 이순신")
    public String getTeamName() {
        if (isDoubles) {
            return player1.getName() + " / " + player2.getName();
        }
        return player1.getName();
    }

    @Override
    public String toString() {
        return "Team{" + getTeamName() + "}";
    }
}
