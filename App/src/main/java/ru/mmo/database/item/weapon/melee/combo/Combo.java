package ru.mmo.database.item.weapon.melee.combo;

import com.vladmihalcea.hibernate.type.array.StringArrayType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import ru.mmo.database.item.weapon.melee.Melee;

import javax.persistence.*;
import java.util.List;

@Entity
@TypeDefs(
        @TypeDef(name = "varchar[]", typeClass = StringArrayType.class)
)
public class Combo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Combo_generator")
    @SequenceGenerator(name = "Combo_generator", sequenceName = "Combo_sequence")
    private long id;

    @Column
    private float damage;

    @Enumerated(EnumType.STRING)
    @Type(type = "varchar[]")
    @Column(columnDefinition = "varchar(255)[]")
    private List<Action> sequence;

    @Enumerated(EnumType.STRING)
    @Type(type = "varchar[]")
    @Column(columnDefinition = "varchar(255)[]")
    private List<Condition> conditions;

    @Column
    private String animation = "";

    @ManyToOne
    private Melee weapon;

    public Combo(float damage) {
        this.damage = damage;
    }

    public Combo() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getDamage() {
        return damage;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    public List<Action> getSequence() {
        return sequence;
    }

    public void setSequence(List<Action> sequence) {
        this.sequence = sequence;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    public String getAnimation() {
        return animation;
    }

    public void setAnimation(String animation) {
        this.animation = animation;
    }

    public Melee getWeapon() {
        return weapon;
    }

    public void setWeapon(Melee weapon) {
        this.weapon = weapon;
    }
}
