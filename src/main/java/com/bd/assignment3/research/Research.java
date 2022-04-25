package com.bd.assignment3.research;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
//@Table(indexes = @Index(name = "num_index", columnList = "num"))
public class Research {

//    @Id @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;

    @Id
    @JsonProperty("과제번호")
    private String num;

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

    public void update(Research research) {
        this.num = research.getNum();
        this.title = research.getTitle();
        this.department = research.getDepartment();
        this.organization = research.getOrganization();
        this.participantsNum = research.getParticipantsNum();
        this.term = research.getTerm();
        this.type = research.getType();
        this.stage = research.getStage();
        this.range = research.getRange();
    }
}
