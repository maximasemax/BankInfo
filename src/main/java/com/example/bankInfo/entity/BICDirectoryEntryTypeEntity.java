package com.example.bankInfo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "bic_directory_entry_type")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BICDirectoryEntryTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ed807_id")
    private Ed807Entity ed807EntityId;

    @Column(name = "bic")
    private String bic;

    @OneToMany(mappedBy = "bicDirectoryEntryTypeEntity")
    private List<AccountsTypeEntity> accounts;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "participant_info_id")
    private ParticipantInfoTypeEntity participantInfo;

    @OneToMany(mappedBy = "bicDirectoryEntryTypeEntity")
    private List<SwBicsEntity> swbics;
//
//
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Ed807Entity getEd807EntityId() {
//        return ed807EntityId;
//    }
//
//    public void setEd807EntityId(Ed807Entity ed807EntityId) {
//        this.ed807EntityId = ed807EntityId;
//    }
//
//    public String getBic() {
//        return bic;
//    }
//
//    public void setBic(String bic) {
//        this.bic = bic;
//    }
//
//    public List<AccountsTypeEntity> getAccounts() {
//        return accounts;
//    }
//
//    public void setAccounts(List<AccountsTypeEntity> accounts) {
//        this.accounts = accounts;
//    }
//
//    public ParticipantInfoTypeEntity getParticipantInfo() {
//        return participantInfo;
//    }
//
//    public void setParticipantInfo(ParticipantInfoTypeEntity participantInfo) {
//        this.participantInfo = participantInfo;
//    }
//
//    public List<SwBicsEntity> getSwbics() {
//        return swbics;
//    }
//
//    public void setSwbics(List<SwBicsEntity> swbics) {
//        this.swbics = swbics;
//    }
}
