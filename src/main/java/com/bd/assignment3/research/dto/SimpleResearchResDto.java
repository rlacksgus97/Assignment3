package com.bd.assignment3.research.dto;

import com.bd.assignment3.research.Research;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SimpleResearchResDto {
    private String num;

    private String title;

    private String department;

    private String organization;

    private String term;

    public static SimpleResearchResDto toDto(Research research) {
        return SimpleResearchResDto.builder()
                .num(research.getNum())
                .title(research.getTitle())
                .department(research.getDepartment())
                .organization(research.getOrganization())
                .term(research.getTerm())
                .build();
    }
}
