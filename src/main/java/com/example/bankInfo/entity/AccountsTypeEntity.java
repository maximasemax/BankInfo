package com.example.bankInfo.entity;

import jakarta.persistence.*;
import ru.cbr.ed.leaftypes.v2.AccountStatusType;
import ru.cbr.ed.leaftypes.v2.AccountType;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "account_type")
public class AccountsTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bic_directory_entry_type_id")
    private BICDirectoryEntryTypeEntity bicDirectoryEntryTypeEntity;

    @OneToMany(mappedBy = "accountsType")
    private List<AccRstrListEntity> accRstrList;

    @Column(name = "account")
    private String account;

    @Column(name = "regulation_account_type")
    @Enumerated(EnumType.STRING)
    private AccountType regulationAccountType;

    @Column(name = "ck")
    private String ck;

    @Column(name = "account_cbrbic")
    private String accountCBRBIC;

    @Column(name = "account_status")
    @Enumerated(EnumType.STRING)
    private AccountStatusType accountStatus;

    @Column(name = "date_in")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateIn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BICDirectoryEntryTypeEntity getBicDirectoryEntryTypeEntity() {
        return bicDirectoryEntryTypeEntity;
    }

    public void setBicDirectoryEntryTypeEntity(BICDirectoryEntryTypeEntity bicDirectoryEntryTypeEntity) {
        this.bicDirectoryEntryTypeEntity = bicDirectoryEntryTypeEntity;
    }

    public List<AccRstrListEntity> getAccRstrList() {
        return accRstrList;
    }

    public void setAccRstrList(List<AccRstrListEntity> accRstrList) {
        this.accRstrList = accRstrList;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public AccountType getRegulationAccountType() {
        return regulationAccountType;
    }

    public void setRegulationAccountType(AccountType regulationAccountType) {
        this.regulationAccountType = regulationAccountType;
    }

    public String getCk() {
        return ck;
    }

    public void setCk(String ck) {
        this.ck = ck;
    }

    public String getAccountCBRBIC() {
        return accountCBRBIC;
    }

    public void setAccountCBRBIC(String accountCBRBIC) {
        this.accountCBRBIC = accountCBRBIC;
    }

    public AccountStatusType getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatusType accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }
}















