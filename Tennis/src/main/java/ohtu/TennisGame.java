package ohtu;

public class TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if ("player1".equals(playerName)) {
            player1Score++;
        } else {
            player2Score++;
        }
    }

    public String getScore() {
        String displayedScore;
        if (player1Score == player2Score) {
            displayedScore = scoreWhenTied();
        } else if (player1Score >= 4 || player2Score >= 4) {
            displayedScore = scoreWhenAtLeastOnePlayerAtOrAbove40();
        } else {
            displayedScore = scoreWhenBothPlayersBetween0And40();
        }
        return displayedScore;
    }

    private String scoreWhenTied() {
        String displayedScore = pointTranslationToTennisSystem(player1Score);
        if (!displayedScore.equals("Deuce")) {
            displayedScore += "-All";
        }
        return displayedScore;
    }

    private String scoreWhenAtLeastOnePlayerAtOrAbove40() {
        String displayedScore;
        int pointDifference = player1Score - player2Score;
        if (pointDifference == 1) {
            displayedScore = "Advantage player1";
        } else if (pointDifference == -1) {
            displayedScore = "Advantage player2";
        } else if (pointDifference >= 2) {
            displayedScore = "Win for player1";
        } else {
            displayedScore = "Win for player2";
        }
        return displayedScore;
    }

    private String scoreWhenBothPlayersBetween0And40() {
        String displayedScore = "";
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                displayedScore += pointTranslationToTennisSystem(player1Score);
            } else {
                displayedScore += "-";
                displayedScore += pointTranslationToTennisSystem(player2Score);
            }
        }
        return displayedScore;
    }

    private String pointTranslationToTennisSystem(int score) {
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
        }
        return "Deuce";
    }
}
