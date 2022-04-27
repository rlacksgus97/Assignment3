package com.bd.assignment3.research;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLInsert;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
//@SQLInsert(sql="INSERT INTO research(num, title, department, organization, participants_num, term, type, stage, range) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE num = values(num), title = values(title), department = values(department), organization = values(organization), participants_num = values(participants_num), term = values(term), type = values(type), stage = values(stage), range = values(range)" )
//@Table(indexes = @Index(name = "num_index", columnList = "num"))
//public class Research implements Persistable<String> {

public class Research {

//    @Id @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;

    @Id
    @JsonProperty("과제번호")
    @Column(name = "num")
    private String num;

    @JsonProperty("과제명")
    @Column(name = "title")
    private String title;

    @JsonProperty("진료과")
    @Column(name = "department")
    private String department;

    @JsonProperty("연구책임기관")
    @Column(name = "organization")
    private String organization;

    @JsonProperty("전체목표연구대상자수")
    @Column(name = "participantsNum")
    private String participantsNum;

    @JsonProperty("연구기간")
    @Column(name = "term")
    private String term;

    @JsonProperty("연구종류")
    @Column(name = "type")
    private String type;

    @JsonProperty("임상시험단계(연구모형)")
    @Column(name = "stage")
    private String stage;

    @JsonProperty("연구범위")
    @Column(name = "range")
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

//    @Override
//    public String getId() {
//        return this.num;
//    }
//
//    @Override
//    public boolean isNew() {
//        return true;
//    }
}
