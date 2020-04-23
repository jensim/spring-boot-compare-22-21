package com.example.demo;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import org.springframework.web.bind.annotation.GetMapping;
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
            @RequestParam(required = true) List<SortOrder> foo11,
            @Schema(description = "foo12 description", example = "ASC")
            @RequestParam(required = true) SortOrder foo12,
            @Schema(description = "foo13 description", example = "3")
            @Min(0) @Max(10) @RequestParam(required = true) int foo13,
            @Schema(description = "foo14 description", example = "4")
            @RequestParam(required = false) Integer foo14,
            @Schema(description = "foo15 description", example = "5.5")
            @Min(1) @Max(10) @RequestParam(required = true) double foo15,
            @Schema(description = "foo16 description", example = "6")
            @Min(1) @Max(10) @RequestParam(required = true) Long foo16,
            @Schema(description = "foo17 description", example = "DES")
            @RequestParam(required = true) SortOrder foo17,
            @Schema(description = "foo18 description", example = "foo18")
            @RequestParam(required = true) String foo18,
            @Schema(description = "foo19 description", example = "foo19")
            @RequestParam(required = true) String foo19,
            @Schema(description = "foo20 description", example = "DES,ASC,FAR")
            @RequestParam(required = false, defaultValue = "DES,ASC,FAR") List<SortOrder> foo20,
            @Schema(description = "foo21 description", example = "DES,ASC,FAR")
            @RequestParam(required = true) List<SortOrder> foo21

    ) {
        // Do nothing
    }
}
