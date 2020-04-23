package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyRequestBody {
    @Schema(description = "foo01 description", example = "foo01")
    @JsonProperty(required = true)
    private final String foo01;
    @Schema(description = "foo02 description", example = "ASC")
    @JsonProperty(required = true)
    private final SortOrder foo02;
    @Schema(description = "foo03 description", example = "3")
    @Min(0)
    @Max(10)
    @JsonProperty(required = true)
    private final int foo03;
    @Schema(description = "foo04 description", example = "4")
    @JsonProperty(required = false)
    private final Integer foo04;
    @Schema(description = "foo05 description", example = "5.5")
    @Min(1)
    @Max(10)
    @JsonProperty(required = true)
    private final double foo05;
    @Schema(description = "foo06 description", example = "6")
    @Min(1)
    @Max(10)
    @JsonProperty(required = true)
    private final Long foo06;
    @Schema(description = "foo07 description", example = "DES")
    @JsonProperty(required = true)
    private final SortOrder foo07;
    @Schema(description = "foo08 description", example = "foo08")
    @JsonProperty(required = true)
    private final String foo08;
    @Schema(description = "foo09 description", example = "foo09")
    @JsonProperty(required = true)
    private final String foo09;
    @Schema(description = "foo10 description", example = "DES,ASC,FAR")
    @JsonProperty(required = false, defaultValue = "[\"DES\", \"ASC\", \"FAR\"]")
    private final List<SortOrder> foo10;
    @Schema(description = "foo11 description", example = "DES,ASC,FAR")
    @JsonProperty(required = true)
    private final List<SortOrder> foo11;
}
