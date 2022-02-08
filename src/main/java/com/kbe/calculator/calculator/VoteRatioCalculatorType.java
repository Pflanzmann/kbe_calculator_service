package com.kbe.calculator.calculator;

import com.kbe.calculator.exceptions.DivideWithZeroException;

public interface VoteRatioCalculatorType {
    float calculateVoteRatio(int totalVotes, int selectedVotes) throws DivideWithZeroException;
}
