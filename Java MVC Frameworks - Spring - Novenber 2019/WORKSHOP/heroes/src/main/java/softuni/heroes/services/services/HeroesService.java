package softuni.heroes.services.services;

import softuni.heroes.data.models.Hero;
import softuni.heroes.services.models.heroes.HeroCreateServiceModel;
import softuni.heroes.services.models.heroes.HeroDetailsServiceModel;

public interface HeroesService {

    HeroDetailsServiceModel getByName(String name);

    Hero create(HeroCreateServiceModel serviceModel);
}
