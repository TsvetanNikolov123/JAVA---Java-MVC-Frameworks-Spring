package softuni.heroes.services.models.items;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.heroes.data.models.enums.Slot;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemCreateServiceModel {
    private String name;
    private Slot slot;
    private int stamina;
    private int strength;
    private int attack;
    private int defence;
}
