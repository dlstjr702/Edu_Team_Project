package tennis;

public class TennisScoreFormatter {

    private static final String[] SCORES =
            {"0", "15", "30", "40"};

    public static String format(int p1, int p2) {

        if (p1 >= 3 && p2 >= 3) {
            if (p1 == p2) {
                return "Deuce";
            }

            int diff = p1 - p2;

            if (diff == 1) {
                return "Advantage Player1";
            }

            if (diff == -1) {
                return "Advantage Player2";
            }

            if (diff >= 2) {
                return "Win for Player1";
            }

            if (diff <= -2) {
                return "Win for Player2";
            }
        }

        return SCORES[p1] + "-" + SCORES[p2];
    }
}