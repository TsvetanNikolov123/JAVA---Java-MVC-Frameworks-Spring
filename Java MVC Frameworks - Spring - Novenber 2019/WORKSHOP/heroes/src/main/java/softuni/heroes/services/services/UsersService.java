package softuni.heroes.services.services;

import softuni.heroes.services.models.HeroCreateServiceModel;

public interface UsersService {

    void createHeroForUser(String username, HeroCreateServiceModel hero);
}
