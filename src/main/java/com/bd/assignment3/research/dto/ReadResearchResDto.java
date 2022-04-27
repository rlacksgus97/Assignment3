package com.bd.assignment3.research.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReadResearchResDto {
    private String num;

    private String title;

    private String department;

    private String organization;

    private String participantsNum;

    private String term;

    private String type;

    private String stage;

    private String range;
}
