package com.kbe.calculator.calculator;

import com.kbe.calculator.exceptions.DivideWithZeroException;
import org.springframework.stereotype.Component;

@Component
public class VoteRatioCalculator implements VoteRatioCalculatorType {

    @Override
    public float calculateVoteRatio(int totalVotes, int selectedVotes) throws DivideWithZeroException {
        if (totalVotes <= 0 || selectedVotes <= 0) {
            throw new DivideWithZeroException();
        }

        float result = (float) selectedVotes / (float) totalVotes;
        return Math.round(result * 100f) / 100f;
    }
}
