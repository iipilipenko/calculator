package com.pilipenko.calculator.controller;

import com.pilipenko.calculator.service.CalculatorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @Operation(summary = "Addition two numbers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully summed",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid input",
                    content = @Content)})
    @GetMapping("/SUM")
    String summarizeTwoNumbers(@Parameter(description = "first addend") @RequestParam(value = "param1") double param1,
                               @Parameter(description = "second addend") @RequestParam(value = "param2") double param2) {
        return calculatorService.summarize(param1, param2);
    }

    @Operation(summary = "Multiplication two numbers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully multiplied",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid input",
                    content = @Content)})
    @GetMapping("/MULTIPLY")
    String multiplyTwoNumbers(@Parameter(description = "multiplicand") @RequestParam(value = "param1") double param1,
                              @Parameter(description = "multiplier") @RequestParam(value = "param2") double param2) {
        return calculatorService.multiply(param1, param2);
    }

    @Operation(summary = "Subtracting the second number from the first")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully subtracted",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid input",
                    content = @Content)})
    @GetMapping("/SUBTRACT")
    String subtractTwoNumbers(@Parameter(description = "minuend") @RequestParam(value = "param1") double param1,
                              @Parameter(description = "subtrahend") @RequestParam(value = "param2") double param2) {
        return calculatorService.subtract(param1, param2);
    }

    @Operation(summary = "Divide first number by second")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully divided",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid input",
                    content = @Content)})
    @GetMapping("/DIVIDE")
    String divideTwoNumbers(@Parameter(description = "dividend") @RequestParam(value = "param1") double param1,
                            @Parameter(description = "divisor") @RequestParam(value = "param2") double param2) {
        return calculatorService.divide(param1, param2);
    }
}
