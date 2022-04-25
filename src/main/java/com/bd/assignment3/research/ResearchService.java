package com.bd.assignment3.research;

import com.bd.assignment3.research.dto.ReadResearchResDto;
import com.bd.assignment3.research.dto.SimpleResearchResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResearchService {

    private final ResearchRepository researchRepository;

    public ReadResearchResDto read(Long id) {
        Research research = researchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 id의 임상 정보가 존재하지 않습니다"));
        return ReadResearchResDto.builder()
                .num(research.getNum())
                .title(research.getTitle())
                .department(research.getDepartment())
                .organization(research.getOrganization())
                .participantsNum(research.getParticipantsNum())
                .term(research.getTerm())
                .type(research.getType())
                .stage(research.getStage())
                .build();
    }

    public List<SimpleResearchResDto> getUpdatedList(Pageable pageable) {
        Page<SimpleResearchResDto> researchPage = researchRepository.findAll(pageable)
                .map(SimpleResearchResDto::toDto);
        return researchPage.getContent();
    }
}
