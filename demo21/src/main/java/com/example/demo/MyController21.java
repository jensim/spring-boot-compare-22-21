package com.example.demo;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import java.util.Objects;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class MyController21 {

        @GetMapping("/")
        public void getter(
                @Schema(description = "foo01 description", example = "foo01")
                @RequestParam(required = true) String foo01,
                @Schema(description = "foo02 description", example = "ASC")
                @RequestParam(required = true) SortOrder21 foo02,
                @Schema(description = "foo03 description", example = "3")
                @Min(0) @Max(10) @RequestParam(required = true) int foo03,
                @Schema(description = "foo04 description", example = "4")
                @RequestParam(required = false) Integer foo04,
                @Schema(description = "foo05 description", example = "5.5")
                @Min(1) @Max(10) @RequestParam(required = true) double foo05,
                @Schema(description = "foo06 description", example = "6")
                @Min(1) @Max(10) @RequestParam(required = true) Long foo06,
                @Schema(description = "foo07 description", example = "DES")
                @RequestParam(required = true) SortOrder21 foo07,
                @Schema(description = "foo08 description", example = "foo08")
                @RequestParam(required = true) String foo08,
                @Schema(description = "foo09 description", example = "foo09")
                @RequestParam(required = true) String foo09,
                @Schema(description = "foo10 description", example = "DES,ASC,FAR")
                @RequestParam(required = false, defaultValue = "DES,ASC,FAR") List<SortOrder21> foo10,
                @Schema(description = "foo11 description", example = "DES,ASC,FAR")
                @RequestParam(required = true) List<SortOrder21> foo11,
                @Schema(description = "foo12 description", example = "ASC")
                @RequestParam(required = true) SortOrder21 foo12,
                @Schema(description = "foo13 description", example = "3")
                @Min(0) @Max(10) @RequestParam(required = true) int foo13,
                @Schema(description = "foo14 description", example = "4")
                @RequestParam(required = false) Integer foo14,
                @Schema(description = "foo15 description", example = "5.5")
                @Min(1) @Max(10) @RequestParam(required = true) double foo15,
                @Schema(description = "foo16 description", example = "6")
                @Min(1) @Max(10) @RequestParam(required = true) Long foo16,
                @Schema(description = "foo17 description", example = "DES")
                @RequestParam(required = true) SortOrder21 foo17,
                @Schema(description = "foo18 description", example = "foo18")
                @RequestParam(required = true) String foo18,
                @Schema(description = "foo19 description", example = "foo19")
                @RequestParam(required = true) String foo19,
                @Schema(description = "foo20 description", example = "DES,ASC,FAR")
                @RequestParam(required = false, defaultValue = "DES,ASC,FAR") List<SortOrder21> foo20,
                @Schema(description = "foo21 description", example = "DES,ASC,FAR")
                @RequestParam(required = true) List<SortOrder21> foo21
        ) {
                Objects.requireNonNull(foo01);
                Objects.requireNonNull(foo02);
                Objects.requireNonNull(foo03);
                //Objects.requireNonNull(foo04);
                Objects.requireNonNull(foo05);
                Objects.requireNonNull(foo06);
                Objects.requireNonNull(foo07);
                Objects.requireNonNull(foo08);
                Objects.requireNonNull(foo09);
                // Objects.requireNonNull(foo10);
                Objects.requireNonNull(foo11);
                Objects.requireNonNull(foo12);
                Objects.requireNonNull(foo13);
                // Objects.requireNonNull(foo14);
                Objects.requireNonNull(foo15);
                Objects.requireNonNull(foo16);
                Objects.requireNonNull(foo17);
                Objects.requireNonNull(foo18);
                Objects.requireNonNull(foo19);
                //Objects.requireNonNull(foo20);
                Objects.requireNonNull(foo21);
        }

        @GetMapping("/defaults/")
        public void getterWithDefaults(
                @Schema(description = "foo01 description", example = "foo01")
                @RequestParam(required = false, defaultValue = "foo1") String foo01,
                @Schema(description = "foo02 description", example = "ASC")
                @RequestParam(required = false, defaultValue = "FAR") SortOrder21 foo02,
                @Schema(description = "foo03 description", example = "3")
                @Min(0) @Max(10) @RequestParam(required = false, defaultValue = "3") int foo03,
                @Schema(description = "foo04 description", example = "4")
                @RequestParam(required = false, defaultValue = "4") Integer foo04,
                @Schema(description = "foo05 description", example = "5.5")
                @Min(1) @Max(10) @RequestParam(required = false, defaultValue = "5.5") double foo05,
                @Schema(description = "foo06 description", example = "6")
                @Min(1) @Max(10) @RequestParam(required = false, defaultValue = "6") Long foo06,
                @Schema(description = "foo07 description", example = "DES")
                @RequestParam(required = false, defaultValue = "DES") SortOrder21 foo07,
                @Schema(description = "foo08 description", example = "foo08")
                @RequestParam(required = false, defaultValue = "foo08") String foo08,
                @Schema(description = "foo09 description", example = "foo09")
                @RequestParam(required = false, defaultValue = "foo09") String foo09,
                @Schema(description = "foo10 description", example = "DES,ASC,FAR")
                @RequestParam(required = false, defaultValue = "DES,ASC,FAR") List<SortOrder21> foo10,
                @Schema(description = "foo11 description", example = "DES,ASC,FAR")
                @RequestParam(required = false, defaultValue = "DES,ASC,FAR") List<SortOrder21> foo11,
                @Schema(description = "foo12 description", example = "ASC")
                @RequestParam(required = false, defaultValue = "ASC") SortOrder21 foo12,
                @Schema(description = "foo13 description", example = "3")
                @Min(0) @Max(10) @RequestParam(required = false, defaultValue = "3") int foo13,
                @Schema(description = "foo14 description", example = "4")
                @RequestParam(required = false) Integer foo14,
                @Schema(description = "foo15 description", example = "5.5")
                @Min(1) @Max(10) @RequestParam(required = false, defaultValue = "5.5") double foo15,
                @Schema(description = "foo16 description", example = "6")
                @Min(1) @Max(10) @RequestParam(required = false, defaultValue = "6") Long foo16,
                @Schema(description = "foo17 description", example = "DES")
                @RequestParam(required = false, defaultValue = "DES") SortOrder21 foo17,
                @Schema(description = "foo18 description", example = "foo18")
                @RequestParam(required = false, defaultValue = "foo18") String foo18,
                @Schema(description = "foo19 description", example = "foo19")
                @RequestParam(required = false, defaultValue = "foo19") String foo19,
                @Schema(description = "foo20 description", example = "DES,ASC,FAR")
                @RequestParam(required = false, defaultValue = "DES,ASC,FAR") List<SortOrder21> foo20,
                @Schema(description = "foo21 description", example = "DES,ASC,FAR")
                @RequestParam(required = false, defaultValue = "DES,VER") List<SortOrder21> foo21
        ) {
                Objects.requireNonNull(foo01);
                Objects.requireNonNull(foo02);
                Objects.requireNonNull(foo03);
                //Objects.requireNonNull(foo04);
                Objects.requireNonNull(foo05);
                Objects.requireNonNull(foo06);
                Objects.requireNonNull(foo07);
                Objects.requireNonNull(foo08);
                Objects.requireNonNull(foo09);
                // Objects.requireNonNull(foo10);
                Objects.requireNonNull(foo11);
                Objects.requireNonNull(foo12);
                Objects.requireNonNull(foo13);
                // Objects.requireNonNull(foo14);
                Objects.requireNonNull(foo15);
                Objects.requireNonNull(foo16);
                Objects.requireNonNull(foo17);
                Objects.requireNonNull(foo18);
                Objects.requireNonNull(foo19);
                //Objects.requireNonNull(foo20);
                Objects.requireNonNull(foo21);
        }
}
