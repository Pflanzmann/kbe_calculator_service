package com.kbe.calculator.calculator;

import org.springframework.stereotype.Component;

@Component
public class VoteRatioCalculator {

    public float calculateVoteRatio(int totalVotes, int selectedVotes) {
        return (float) selectedVotes / (float) totalVotes;
    }
}
