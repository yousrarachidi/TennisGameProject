package com.example.tennis.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TennisServiceTest {
    private TennisService tennisService;

    @BeforeEach
    void setUp() {
        tennisService = new TennisService();
    }

    @Test
    void testInitialScore() {
        assertEquals("0 - 0", tennisService.getScore());
    }

    @Test
    void testPlayer1Scores() {
        tennisService.pointWonBy("Player 1");
        assertEquals("15 - 0", tennisService.getScore());

        tennisService.pointWonBy("Player 1");
        assertEquals("30 - 0", tennisService.getScore());

        tennisService.pointWonBy("Player 1");
        assertEquals("40 - 0", tennisService.getScore());
    }

    @Test
    void testDeuceScenario() {
        TennisService tennisService = new TennisService();

        tennisService.pointWonBy("Player 1");
        tennisService.pointWonBy("Player 1");
        tennisService.pointWonBy("Player 1");

        tennisService.pointWonBy("Player 2");
        tennisService.pointWonBy("Player 2");
        tennisService.pointWonBy("Player 2");

        System.out.println("Current Score: " + tennisService.getScore());

        assertEquals("Deuce", tennisService.getScore());
    }


    @Test
    void testAdvantageScenario() {
        TennisService tennisService = new TennisService();

        tennisService.pointWonBy("Player 1");
        tennisService.pointWonBy("Player 1");
        tennisService.pointWonBy("Player 1");

        tennisService.pointWonBy("Player 2");
        tennisService.pointWonBy("Player 2");
        tennisService.pointWonBy("Player 2");

        tennisService.pointWonBy("Player 1");

        assertEquals("Advantage Player 1", tennisService.getScore());
    }


    @Test
    void testPlayer1Wins() {
        TennisService tennisService = new TennisService();

        tennisService.pointWonBy("Player 1");
        tennisService.pointWonBy("Player 1");
        tennisService.pointWonBy("Player 1");
        tennisService.pointWonBy("Player 1");

        System.out.println("Current Score: " + tennisService.getScore());

        assertEquals("Player 1 wins", tennisService.getScore());
    }

}
