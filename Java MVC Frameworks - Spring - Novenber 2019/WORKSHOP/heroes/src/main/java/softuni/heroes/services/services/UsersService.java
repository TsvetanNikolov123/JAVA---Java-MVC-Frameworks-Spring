package softuni.heroes.services.services;

import softuni.heroes.services.models.heroes.HeroCreateServiceModel;

public interface UsersService {

    void createHeroForUser(String username, HeroCreateServiceModel hero) throws Exception;
}
