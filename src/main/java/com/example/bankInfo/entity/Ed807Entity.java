package com.example.bankInfo.entity;

import com.example.bankInfo.converter.DateConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.cbr.ed.leaftypes.v2.ReasonCodeType;
import ru.cbr.ed.leaftypes.v2.RequestCodeType;

import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ed807")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ed807Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ed807EntityId")
    private List<BICDirectoryEntryTypeEntity> bicDirectoryEntry;

    @Enumerated(EnumType.STRING)
    @Column(name = "creation_reason")
    private ReasonCodeType creationReason;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date_time")
    private Date creationDateTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "info_type_code")
    private RequestCodeType infoTypeCode;

    @Column(name = "business_day")
    private String businessDay;

    @Column(name = "directory_version")
    private BigInteger directoryVersion;

    @Column(name = "ed_no")
    private BigInteger edNo;

    @Temporal(TemporalType.DATE)
    @Column(name = "ed_date")
    private Date edDate;

    @Column(name = "ed_author")
    private String edAuthor;

    public void setCreationDateTime(XMLGregorianCalendar calendar) {
        this.creationDateTime = DateConverter.toDate(calendar);
    }


    public void setEdDate(XMLGregorianCalendar calendar) {
        this.edDate = DateConverter.toDate(calendar);
    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public List<BICDirectoryEntryTypeEntity> getBicDirectoryEntry() {
//        return bicDirectoryEntry;
//    }
//
//    public void setBicDirectoryEntry(List<BICDirectoryEntryTypeEntity> bicDirectoryEntry) {
//        this.bicDirectoryEntry = bicDirectoryEntry;
//    }
//
//    public ReasonCodeType getCreationReason() {
//        return creationReason;
//    }
//
//    public void setCreationReason(ReasonCodeType creationReason) {
//        this.creationReason = creationReason;
//    }
//
//    public Date getCreationDateTime() {
//        return creationDateTime;
//    }
//
//    public RequestCodeType getInfoTypeCode() {
//        return infoTypeCode;
//    }
//
//    public void setInfoTypeCode(RequestCodeType infoTypeCode) {
//        this.infoTypeCode = infoTypeCode;
//    }
//
//    public String getBusinessDay() {
//        return businessDay;
//    }
//
//    public void setBusinessDay(String businessDay) {
//        this.businessDay = businessDay;
//    }
//
//    public BigInteger getDirectoryVersion() {
//        return directoryVersion;
//    }
//
//    public void setDirectoryVersion(BigInteger directoryVersion) {
//        this.directoryVersion = directoryVersion;
//    }
//
//    public BigInteger getEdNo() {
//        return edNo;
//    }
//
//    public void setEdNo(BigInteger edNo) {
//        this.edNo = edNo;
//    }
//
//    public Date getEdDate() {
//        return edDate;
//    }
//
//    public void setEdDate(Date edDate) {
//        this.edDate = edDate;
//    }
//
//    public String getEdAuthor() {
//        return edAuthor;
//    }
//
//    public void setEdAuthor(String edAuthor) {
//        this.edAuthor = edAuthor;
//    }
}