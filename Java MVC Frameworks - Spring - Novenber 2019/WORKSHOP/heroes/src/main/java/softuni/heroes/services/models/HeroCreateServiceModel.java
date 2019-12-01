package softuni.heroes.services.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.heroes.data.models.enums.Gender;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HeroCreateServiceModel {

    private String name;
    private Gender gender;
}
