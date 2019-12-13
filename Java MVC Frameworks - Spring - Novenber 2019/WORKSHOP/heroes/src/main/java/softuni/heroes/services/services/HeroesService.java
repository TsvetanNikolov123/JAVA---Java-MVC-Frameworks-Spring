package softuni.heroes.services.services;

import softuni.heroes.data.models.Hero;
import softuni.heroes.services.models.heroes.HeroCreateServiceModel;
import softuni.heroes.services.models.heroes.HeroDetailsServiceModel;

import java.util.List;

public interface HeroesService {

    HeroDetailsServiceModel getByName(String name);

    Hero create(HeroCreateServiceModel serviceModel);

    boolean areThereOpponents();

    List<HeroDetailsServiceModel> getOpponents(String heroName);

    String getWinner(HeroDetailsServiceModel player1, HeroDetailsServiceModel player2);

    void levelUp(Hero winner);
}
