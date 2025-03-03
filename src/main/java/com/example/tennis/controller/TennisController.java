package com.example.tennis.controller;

import com.example.tennis.service.TennisService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tennis")
public class TennisController {
    private final TennisService tennisService;

    public TennisController(TennisService tennisService) {
        this.tennisService = tennisService;
    }

    @PostMapping("/point/{player}")
    public String pointWonBy(@PathVariable String player) {
        tennisService.pointWonBy(player);
        return tennisService.getScore();
    }

    @GetMapping("/score")
    public String getScore() {
        return tennisService.getScore();
    }
}
