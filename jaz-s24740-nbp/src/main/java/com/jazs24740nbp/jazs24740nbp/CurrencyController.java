package com.jazs24740nbp.jazs24740nbp;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @Operation(summary = "Calculate avarage currency from date to date, and save that information to DataBase.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfuly calculate avarage currency", content = { @Content(schema = @Schema(implementation = CurrencyModel.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", description = "Wrong data was inserted/Invalid date range", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", description = "Can't find that website", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", description = "Problem with Internal Server", content = { @Content(schema = @Schema()) }) })
    @GetMapping("/{currency}/{start_date}/{end_date}")
    public ResponseEntity<Double> calculateAvarageCurrency(@PathVariable String currency, @PathVariable String start_date, @PathVariable String end_date) {
        double averageRate = currencyService.calculateAvarageCurrency(currency, start_date, end_date);
        return new ResponseEntity<>(averageRate, HttpStatus.OK);
    }

    @Operation(summary = "Show the history of checked avarage currency")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfuly shown history", content = { @Content(schema = @Schema(implementation = CurrencyModel.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "Can't find that website", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", description = "Problem with Internal Server", content = { @Content(schema = @Schema()) }) })
    @GetMapping("/history")
    public ResponseEntity<List<CurrencyModel>> getAllCurrencyHistory() {
        return ResponseEntity.ok(currencyService.getAllCurrencyHistory());
    }
}
