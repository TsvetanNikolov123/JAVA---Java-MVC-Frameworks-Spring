package softuni.heroes.data.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.heroes.data.models.base.BaseEntity;
import softuni.heroes.data.models.enums.Slot;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "items")
public class Item extends BaseEntity {

    @ManyToMany(mappedBy = "items")
    List<Hero> heroes;

    @Column
    private String name;

    @Column
    @Enumerated(EnumType.STRING)
    private Slot slot;

    @Column
    private int stamina;

    @Column
    private int strength;

    @Column
    private int attack;

    @Column
    private int defence;
}
