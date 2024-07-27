package com.example.bankInfo.entity;

import jakarta.persistence.*;
import ru.cbr.ed.leaftypes.v2.RstrType;

import java.util.Date;

@Entity
@Table(name = "acc_rstr_list")
public class AccRstrListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "accounts_type_id")
    private AccountsTypeEntity accountsType;

    @Column(name = "acc_rstr")
    @Enumerated(EnumType.STRING)
    private RstrType accRstr;

    @Column(name = "acc_rstr_date")
    @Temporal(TemporalType.DATE)
    private Date accRstrDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountsTypeEntity getAccountsType() {
        return accountsType;
    }

    public void setAccountsType(AccountsTypeEntity accountsType) {
        this.accountsType = accountsType;
    }

    public RstrType getAccRstr() {
        return accRstr;
    }

    public void setAccRstr(RstrType accRstr) {
        this.accRstr = accRstr;
    }

    public Date getAccRstrDate() {
        return accRstrDate;
    }

    public void setAccRstrDate(Date accRstrDate) {
        this.accRstrDate = accRstrDate;
    }
}
