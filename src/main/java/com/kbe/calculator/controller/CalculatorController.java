package com.kbe.calculator.controller;

import com.kbe.calculator.calculator.VoteRatioCalculatorType;
import com.kbe.calculator.model.CalculatorRequest;
import com.kbe.calculator.model.CalculatorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/calculator")
public class CalculatorController {

    private VoteRatioCalculatorType voteRatioCalculator;

    @Autowired
    public CalculatorController(VoteRatioCalculatorType voteRatioCalculator) {
        this.voteRatioCalculator = voteRatioCalculator;
    }

    @PostMapping("/calculate")
    @ResponseBody
    public ResponseEntity<CalculatorResponse> CalculatePopularity(@RequestBody CalculatorRequest requestBody) {
        int voteCount = requestBody.getUpvotes() + requestBody.getDownvotes();

        float upvoteRate = 0;
        float downvoteRate = 0;

        try {
            upvoteRate = voteRatioCalculator.calculateVoteRatio(voteCount, requestBody.getUpvotes());
            downvoteRate = voteRatioCalculator.calculateVoteRatio(voteCount, requestBody.getDownvotes());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }

        CalculatorResponse response = new CalculatorResponse(upvoteRate, downvoteRate);

        return ResponseEntity.ok(response);
    }
}
