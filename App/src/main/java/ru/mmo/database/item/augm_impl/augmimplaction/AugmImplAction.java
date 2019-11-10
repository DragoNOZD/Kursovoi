package ru.mmo.database.item.augm_impl.augmimplaction;

import javax.persistence.*;

@Entity
public class AugmImplAction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AugmImplAction_generator")
    @SequenceGenerator(name = "AugmImplAction_generator", sequenceName = "AugmImplAction_sequence")
    private long id;

    @Column
    private String description;

    public AugmImplAction(String description) {
        this.description = description;
    }

    public AugmImplAction() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void use() {

    }
}
