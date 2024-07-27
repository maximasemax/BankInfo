package com.example.bankInfo.entity;

import jakarta.persistence.*;
import ru.cbr.ed.leaftypes.v2.ParticipantStatusType;
import ru.cbr.ed.v2.RstrListType;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "participant_info_type")
public class ParticipantInfoTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(mappedBy = "participantInfoTypeEntity")
    private List<RstrListTypeEntity> rstrListTypeEntity;

    @Column(name = "name_p")
    private String nameP;

    @Column(name = "reg_n")
    private String regN;

    @Column(name = "cntr_cd")
    private String cntrCd;

    @Column(name = "rgn")
    private String rgn;

    @Column(name = "idn")
    private String ind;

    @Column(name = "tnp")
    private String tnp;

    @Column(name = "nnp")
    private String nnp;

    @Column(name = "adr")
    private String adr;

    @Column(name = "date_in")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateIn;

    @Column(name = "pt_type")
    private String ptType;

    @Column(name = "srvcs")
    private String srvcs;

    @Column(name = "xch_type")
    private String xchType;

    @Column(name = "uid")
    private String uid;

    @Enumerated(EnumType.STRING)
    @Column(name = "participant_status")
    private ParticipantStatusType participantStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<RstrListTypeEntity> getRstrListTypeEntity() {
        return rstrListTypeEntity;
    }

    public void setRstrListTypeEntity(List<RstrListTypeEntity> rstrListTypeEntity) {
        this.rstrListTypeEntity = rstrListTypeEntity;
    }

    public String getNameP() {
        return nameP;
    }

    public void setNameP(String nameP) {
        this.nameP = nameP;
    }

    public String getRegN() {
        return regN;
    }

    public void setRegN(String regN) {
        this.regN = regN;
    }

    public String getCntrCd() {
        return cntrCd;
    }

    public void setCntrCd(String cntrCd) {
        this.cntrCd = cntrCd;
    }

    public String getRgn() {
        return rgn;
    }

    public void setRgn(String rgn) {
        this.rgn = rgn;
    }

    public String getInd() {
        return ind;
    }

    public void setInd(String ind) {
        this.ind = ind;
    }

    public String getTnp() {
        return tnp;
    }

    public void setTnp(String tnp) {
        this.tnp = tnp;
    }

    public String getNnp() {
        return nnp;
    }

    public void setNnp(String nnp) {
        this.nnp = nnp;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public String getPtType() {
        return ptType;
    }

    public void setPtType(String ptType) {
        this.ptType = ptType;
    }

    public String getSrvcs() {
        return srvcs;
    }

    public void setSrvcs(String srvcs) {
        this.srvcs = srvcs;
    }

    public String getXchType() {
        return xchType;
    }

    public void setXchType(String xchType) {
        this.xchType = xchType;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public ParticipantStatusType getParticipantStatus() {
        return participantStatus;
    }

    public void setParticipantStatus(ParticipantStatusType participantStatus) {
        this.participantStatus = participantStatus;
    }
}
