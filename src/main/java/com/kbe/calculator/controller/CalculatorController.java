package com.kbe.calculator.controller;

import com.kbe.calculator.calculator.VoteRatioCalculator;
import com.kbe.calculator.model.CalculatorRequest;
import com.kbe.calculator.model.CalculatorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/calculator")
public class CalculatorController {

    VoteRatioCalculator voteRatioCalculator;

    @Autowired
    public CalculatorController(VoteRatioCalculator voteRatioCalculator) {
        this.voteRatioCalculator = voteRatioCalculator;
    }

    @PostMapping("/calculate")
    @ResponseBody
    public ResponseEntity<CalculatorResponse> CalculatePopularity(@RequestBody CalculatorRequest requestBody) {
        int voteCount = requestBody.getUpvotes() + requestBody.getDownvotes();

        float upvoteRate = voteRatioCalculator.calculateVoteRatio(voteCount, requestBody.getUpvotes());
        upvoteRate = Math.round(upvoteRate * 100f) / 100f;

        float downvoteRate = voteRatioCalculator.calculateVoteRatio(voteCount, requestBody.getDownvotes());
        downvoteRate = Math.round(downvoteRate * 100f) / 100f;

        CalculatorResponse response = new CalculatorResponse(upvoteRate, downvoteRate);

        return ResponseEntity.ok(response);
    }
}
