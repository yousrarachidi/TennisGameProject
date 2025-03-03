package com.example.tennis.service;

import org.springframework.stereotype.Service;

@Service
public class TennisService {
    private int player1Score = 0;
    private int player2Score = 0;

    public void pointWonBy(String player) {
        if (player.equals("Player 1")) {
            player1Score++;
        } else if (player.equals("Player 2")) {
            player2Score++;
        }
    }

    public String getScore() {
        if (player1Score >= 4 && player1Score >= player2Score + 2) {
            return "Player 1 wins";
        } else if (player2Score >= 4 && player2Score >= player1Score + 2) {
            return "Player 2 wins";
        }

        // 🏆 Handle Deuce and Advantage rules
        if (player1Score >= 3 && player2Score >= 3) {
            if (player1Score == player2Score) {
                return "Deuce";
            } else if (player1Score == player2Score + 1) {
                return "Advantage Player 1";
            } else if (player2Score == player1Score + 1) {
                return "Advantage Player 2";
            }
        }

        return formatScore(player1Score) + " - " + formatScore(player2Score);
    }

    private String formatScore(int score) {
        switch (score) {
            case 0: return "0";
            case 1: return "15";
            case 2: return "30";
            case 3: return "40";
            default: return "40";
        }
    }
}
