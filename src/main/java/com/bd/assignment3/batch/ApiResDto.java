package com.bd.assignment3.batch;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ApiResDto {
    private int currentCount;
    private List<Data> data;
    private int matchCount;
    private int page;
    private int perPage;
    private int totalCount;

    @lombok.Data
    static class Data {
        @JsonProperty("과제번호")
        private String id;

        @JsonProperty("과제명")
        private String title;

        @JsonProperty("진료과")
        private String department;

        @JsonProperty("연구책임기관")
        private String organization;

        @JsonProperty("전체목표연구대상자수")
        private String participantsNum;

        @JsonProperty("연구기간")
        private String term;

        @JsonProperty("연구종류")
        private String type;

        @JsonProperty("임상시험단계(연구모형)")
        private String stage;

        @JsonProperty("연구범위")
        private String range;
    }
}
