package com.kbe.calculator.calculator;

public class VoteRatioCalculator {

    public float calculateVoteRatio(int totalVotes, int selectedVotes) {
        return (float) selectedVotes / (float) totalVotes;
    }
}
