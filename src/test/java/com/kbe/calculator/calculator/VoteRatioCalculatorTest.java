package com.kbe.calculator.calculator;

import com.kbe.calculator.exceptions.DivideWithZeroException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VoteRatioCalculatorTest {

    private VoteRatioCalculator voteRatioCalculator;

    @BeforeEach
    void beforeEach() {
        voteRatioCalculator = new VoteRatioCalculator();
    }

    @Test
    void calculateVoteRatio_NegativeTotal_DivideByZeroException() {
        int totalVotes = -10;
        int selectedVotes = 10;

        Assertions.assertThrows(DivideWithZeroException.class, () -> {
            voteRatioCalculator.calculateVoteRatio(totalVotes, selectedVotes);
        });
    }

    @Test
    void calculateVoteRatio_NegativeSelected_DivideByZeroException() {
        int totalVotes = 10;
        int selectedVotes = -10;

        Assertions.assertThrows(DivideWithZeroException.class, () -> {
            voteRatioCalculator.calculateVoteRatio(totalVotes, selectedVotes);
        });
    }

    @Test
    void calculateVoteRatio_ZeroSelected_DivideByZeroException() {
        int totalVotes = 10;
        int selectedVotes = 0;

        Assertions.assertThrows(DivideWithZeroException.class, () -> {
            voteRatioCalculator.calculateVoteRatio(totalVotes, selectedVotes);
        });
    }

    @Test
    void calculateVoteRatio_ZeroTotal_DivideByZeroException() {
        int totalVotes = 0;
        int selectedVotes = 10;

        Assertions.assertThrows(DivideWithZeroException.class, () -> {
            voteRatioCalculator.calculateVoteRatio(totalVotes, selectedVotes);
        });
    }

    @Test
    void calculateVoteRatio_ZeroAll_DivideByZeroException() {
        int totalVotes = 0;
        int selectedVotes = 0;

        Assertions.assertThrows(DivideWithZeroException.class, () -> {
            voteRatioCalculator.calculateVoteRatio(totalVotes, selectedVotes);
        });
    }

    @Test
    void calculateVoteRatio_NegativeAll_DivideByZeroException() {
        int totalVotes = -10;
        int selectedVotes = -10;

        Assertions.assertThrows(DivideWithZeroException.class, () -> {
            voteRatioCalculator.calculateVoteRatio(totalVotes, selectedVotes);
        });
    }

    @Test
    void calculateVoteRatio_Correct1_NotRounded() throws DivideWithZeroException {
        int totalVotes = 20;
        int selectedVotes = 10;
        float expected = 0.5f;

        float result = voteRatioCalculator.calculateVoteRatio(totalVotes, selectedVotes);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void calculateVoteRatio_Correct2_Rounded() throws DivideWithZeroException {
        int totalVotes = 30;
        int selectedVotes = 10;
        float expected = 0.33f;

        float result = voteRatioCalculator.calculateVoteRatio(totalVotes, selectedVotes);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void calculateVoteRatio_Correct3_RoundedToZero() throws DivideWithZeroException {
        int totalVotes = 1000000;
        int selectedVotes = 10;
        float expected = 0f;

        float result = voteRatioCalculator.calculateVoteRatio(totalVotes, selectedVotes);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void calculateVoteRatio_Correct4_RoundedToOne() throws DivideWithZeroException {
        int totalVotes = 1000000;
        int selectedVotes = 1000000 - 10;
        float expected = 1f;

        float result = voteRatioCalculator.calculateVoteRatio(totalVotes, selectedVotes);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void calculateVoteRatio_Correct5_SmallerTotal() throws DivideWithZeroException {
        int totalVotes = 10;
        int selectedVotes = 100;
        float expected = 10f;

        float result = voteRatioCalculator.calculateVoteRatio(totalVotes, selectedVotes);

        Assertions.assertEquals(expected, result);
    }
}