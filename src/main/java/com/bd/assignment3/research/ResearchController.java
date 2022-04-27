package com.bd.assignment3.research;

import com.bd.assignment3.research.dto.ReadResearchResDto;
import com.bd.assignment3.research.dto.SimpleResearchResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/research")
@RequiredArgsConstructor
public class ResearchController {

    private final ResearchService researchService;

    @GetMapping("/{id}")
    public ResponseEntity<ReadResearchResDto> read(@PathVariable Long id) {
        return ResponseEntity.ok(researchService.read(id));
    }

    @GetMapping
    public ResponseEntity<List<SimpleResearchResDto>> getUpdatedList(Pageable pageable) {
        return ResponseEntity.ok(researchService.getUpdatedList(pageable));
    }
}
