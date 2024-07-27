package com.example.bankInfo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sw_bics")
public class SwBicsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bic_directory_entry_type_id")
    private BICDirectoryEntryTypeEntity bicDirectoryEntryTypeEntity;

    @Column(name = "sw_bic")
    private String swbic;

    @Column(name = "default_sw_bic")
    private boolean defaultSwBic;


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

    public String getSwbic() {
        return swbic;
    }

    public void setSwbic(String swbic) {
        this.swbic = swbic;
    }

    public boolean isDefaultSwBic() {
        return defaultSwBic;
    }

    public void setDefaultSwBic(boolean defaultSwBic) {
        this.defaultSwBic = defaultSwBic;
    }
}
