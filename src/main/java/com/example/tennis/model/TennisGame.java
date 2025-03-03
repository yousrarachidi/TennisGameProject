package com.example.tennis.model;

public class TennisGame {
    private int player1Score = 0;
    private int player2Score = 0;
    private final String player1;
    private final String player2;

    public TennisGame(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    private String scoreToString(int score) {
        switch (score) {
            case 0:
                return "0";
            case 1:
                return "15";
            case 2:
                return "30";
            case 3:
                return "40";
            default:
                return "";
        }
    }

    public void pointWonBy(String player) {
        if (player.equals(player1)) {
            player1Score++;
        } else if (player.equals(player2)) {
            player2Score++;
        }
    }

    public String getScore() {
        if (player1Score >= 3 && player2Score >= 3) {
            if (player1Score == player2Score) return "Deuce";
            if (player1Score == player2Score + 1) return "Advantage " + player1;
            if (player2Score == player1Score + 1) return "Advantage " + player2;
            if (player1Score >= player2Score + 2) return player1 + " wins";
            if (player2Score >= player1Score + 2) return player2 + " wins";
        }
        return scoreToString(player1Score) + " - " + scoreToString(player2Score);
    }
}
