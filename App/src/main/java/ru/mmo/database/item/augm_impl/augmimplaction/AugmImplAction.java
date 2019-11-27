package ru.mmo.database.item.augm_impl.augmimplaction;

import javax.persistence.*;

@Entity
@Table(name = "augm_impl_actions")
public class AugmImplAction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AugmImplAction_generator")
    @SequenceGenerator(name = "AugmImplAction_generator", sequenceName = "AugmImplAction_sequence")
    private long id;

    @Column
    private String description;

    @Enumerated(EnumType.STRING)
    @Column
    private ActionT action;

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

    public void setId(long id) {
        this.id = id;
    }

    public ActionT getAction() {
        return action;
    }

    public void setAction(ActionT action) {
        this.action = action;
    }

    public void use() {

    }
}
