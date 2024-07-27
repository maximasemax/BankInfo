package com.example.bankInfo.entity;


import jakarta.persistence.*;
import ru.cbr.ed.leaftypes.v2.RstrType;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;

@Entity
@Table(name = "rstr_list_type")
public class RstrListTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "participant_info_type_id")
    public ParticipantInfoTypeEntity participantInfoTypeEntity;

    @Enumerated(EnumType.STRING)
    @Column(name = "rstr")
    public RstrType rstr;

    @Column(name = "rstr_date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date rstrDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ParticipantInfoTypeEntity getParticipantInfoTypeEntity() {
        return participantInfoTypeEntity;
    }

    public void setParticipantInfoTypeEntity(ParticipantInfoTypeEntity participantInfoTypeEntity) {
        this.participantInfoTypeEntity = participantInfoTypeEntity;
    }

    public RstrType getRstr() {
        return rstr;
    }

    public void setRstr(RstrType rstr) {
        this.rstr = rstr;
    }

    public Date getRstrDate() {
        return rstrDate;
    }

    public void setRstrDate(Date rstrDate) {
        this.rstrDate = rstrDate;
    }
}
