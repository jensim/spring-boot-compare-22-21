package com.example.demo;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Sorting order for something")
public enum SortOrder21 {
    @Schema(description = "Ascending sorting order")
    ASC,
    @Schema(description = "Descending sorting order")
    DES,
    @Schema(description = "Sideways sorting order")
    SID,
    @Schema(description = "Horizontal sorting order")
    HOR,
    @Schema(description = "Vertical sorting order")
    VER,
    @Schema(description = "Far sorting order")
    FAR,
    @Schema(description = "Near sorting order")
    NEA,
    ;
}
