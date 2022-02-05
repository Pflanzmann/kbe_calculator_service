package com.kbe.calculator.controller;

import com.kbe.calculator.calculator.VoteRatioCalculator;
import com.kbe.calculator.model.CalculatorRequest;
import com.kbe.calculator.model.CalculatorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    @GetMapping("/calculate")
    @ResponseBody
    public ResponseEntity<CalculatorResponse> CalculatePopularity(
            @RequestBody CalculatorRequest requestBody
    ) {
        VoteRatioCalculator voteRatioCalculator = new VoteRatioCalculator();

        int voteCount = requestBody.getUpvotes() + requestBody.getDownvotes();
        float upvoteRate = voteRatioCalculator.calculateVoteRatio(voteCount, requestBody.getUpvotes());
        float downvoteRate = voteRatioCalculator.calculateVoteRatio(voteCount, requestBody.getDownvotes());

        CalculatorResponse response = new CalculatorResponse(upvoteRate, downvoteRate);

        return ResponseEntity.ok(response);
    }
}
