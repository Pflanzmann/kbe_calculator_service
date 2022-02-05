package com.kbe.calculator.model;

public class CalculatorResponse {
    private final float upvoteRate;
    private final float downvoteRate;

    public CalculatorResponse(float upvoteRate, float downvoteRate) {
        this.upvoteRate = upvoteRate;
        this.downvoteRate = downvoteRate;
    }

    public float getUpvoteRate() {
        return upvoteRate;
    }

    public float getDownvoteRate() {
        return downvoteRate;
    }
}
