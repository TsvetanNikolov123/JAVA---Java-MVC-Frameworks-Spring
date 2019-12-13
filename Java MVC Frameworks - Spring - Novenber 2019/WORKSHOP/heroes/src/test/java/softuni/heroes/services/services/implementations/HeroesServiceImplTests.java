package softuni.heroes.services.services.implementations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import softuni.heroes.data.models.Hero;
import softuni.heroes.data.repositories.HeroesRepository;
import softuni.heroes.errors.HeroNotFoundException;
import softuni.heroes.services.factories.HeroesFactory;
import softuni.heroes.services.factories.base.HeroesFactoryImpl;
import softuni.heroes.services.models.heroes.HeroDetailsServiceModel;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HeroesServiceImplTests {
    private HeroesRepository heroesRepository;
    private HeroesFactory heroesFactory;
    private ModelMapper modelMapper;

    private HeroesServiceImpl heroesService;

    @BeforeEach
    void setupTest() {
        heroesRepository = Mockito.mock(HeroesRepository.class);
        heroesFactory = new HeroesFactoryImpl();
        modelMapper = new ModelMapper();

        heroesService = new HeroesServiceImpl(heroesRepository, heroesFactory, modelMapper);
    }

    @Test
    void getByName_whenHeroDoesNOTExist_shouldThrowNotFoundException() {
        String heroName = "Hero Name";

        Mockito.when(heroesRepository.getByNameIgnoreCase(heroName))
                .thenReturn(Optional.empty());

        assertThrows(HeroNotFoundException.class, () -> heroesService.getByName(heroName));
    }

    @Test
    void getByName_whenHeroDoesExist_shouldReturnHero() {
        String heroName = "Hero name";

        Hero hero = new Hero();
        hero.setName(heroName);
        hero.setItems(new ArrayList<>());

        Mockito.when(heroesRepository.getByNameIgnoreCase(heroName))
                .thenReturn(Optional.of(hero));

        HeroDetailsServiceModel heroDetailsServiceModel = heroesService.getByName(heroName);

        assertEquals(hero.getName(), heroDetailsServiceModel.getName());
    }

    @Test
    void levelUp_whenHeroWon_shouldReturnCorrectLevel() {
        Hero hero = new Hero();
        hero.setName("Pesho");

        heroesService.levelUp(hero);
        assertEquals(hero.getLevel(), 1);
    }
}
