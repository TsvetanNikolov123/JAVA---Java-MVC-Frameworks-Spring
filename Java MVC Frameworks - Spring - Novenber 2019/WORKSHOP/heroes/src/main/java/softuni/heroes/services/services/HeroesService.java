package softuni.heroes.services.services;

import softuni.heroes.data.models.Hero;
import softuni.heroes.services.models.HeroCreateServiceModel;
import softuni.heroes.services.models.HeroDetailsServiceModel;

public interface HeroesService {

    HeroDetailsServiceModel getByName(String name);

    Hero create(HeroCreateServiceModel serviceModel);
}
