package com.example.demo;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class MyController {

    @GetMapping
    public void getter(

            @Schema(description = "foo01 description", example = "foo01")
            @RequestParam(required = true) String foo01,
            @Schema(description = "foo02 description", example = "ASC")
            @RequestParam(required = true) SortOrder foo02,
            @Schema(description = "foo03 description", example = "3")
            @Min(0) @Max(10) @RequestParam(required = true) int foo03,
            @Schema(description = "foo04 description", example = "4")
            @RequestParam(required = false) Integer foo04,
            @Schema(description = "foo05 description", example = "5.5")
            @Min(1) @Max(10) @RequestParam(required = true) double foo05,
            @Schema(description = "foo06 description", example = "6")
            @Min(1) @Max(10) @RequestParam(required = true) Long foo06,
            @Schema(description = "foo07 description", example = "DES")
            @RequestParam(required = true) SortOrder foo07,
            @Schema(description = "foo08 description", example = "foo08")
            @RequestParam(required = true) String foo08,
            @Schema(description = "foo09 description", example = "foo09")
            @RequestParam(required = true) String foo09,
            @Schema(description = "foo10 description", example = "DES,ASC,FAR")
            @RequestParam(required = false, defaultValue = "DES,ASC,FAR") List<SortOrder> foo10,
            @Schema(description = "foo11 description", example = "DES,ASC,FAR")
            @RequestParam(required = true) List<SortOrder> foo11

    ) {
        // Do nothing
    }

    @PostMapping(consumes = {APPLICATION_JSON_VALUE})
    public void poster(@RequestBody MyRequestBody body) {
        // Do nothing
    }
}
