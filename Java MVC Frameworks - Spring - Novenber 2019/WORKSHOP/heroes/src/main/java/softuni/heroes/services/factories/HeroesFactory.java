package softuni.heroes.services.factories;

import softuni.heroes.data.models.Hero;
import softuni.heroes.data.models.enums.Gender;

public interface HeroesFactory {

    Hero create(String name, Gender gender);
}
