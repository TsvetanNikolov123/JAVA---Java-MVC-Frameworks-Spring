package softuni.heroes.services.services.implementations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import softuni.heroes.data.models.Hero;
import softuni.heroes.data.models.User;
import softuni.heroes.data.models.enums.Gender;
import softuni.heroes.data.repositories.HeroesRepository;
import softuni.heroes.data.repositories.UsersRepository;
import softuni.heroes.services.factories.HeroesFactory;
import softuni.heroes.services.factories.base.HeroesFactoryImpl;
import softuni.heroes.services.models.HeroCreateServiceModel;
import softuni.heroes.services.services.HeroesService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UsersServiceImplTest {

    // 1. user exists and does NOT have a hero
    // 2. user does NOT exists and does
    // 3. user exists and has a hero

    HeroesService heroesService;
    UsersRepository usersRepository;
    HeroesRepository heroesRepository;
    HeroesFactory heroesFactory;

    UsersServiceImpl service;

    @BeforeEach
    void setupTest() {
        usersRepository = Mockito.mock(UsersRepository.class);
        heroesRepository = Mockito.mock(HeroesRepository.class);
        heroesFactory = new HeroesFactoryImpl();
        ModelMapper mapper = new ModelMapper();
        heroesService = new HeroesServiceImpl(heroesRepository, heroesFactory, mapper);
        service = new UsersServiceImpl(heroesService, usersRepository, heroesRepository, mapper);
    }

    @Test
    void createHeroForUser_whenUserExistsAndDoesNotHaveAHero_shouldCreateHeroForUser() throws Exception {
        User user = new User();
        user.setUsername("Pesho");
        String heroName = "Gosho";
        Mockito.when(usersRepository.findByUsername(user.getUsername()))
                .thenReturn(user);

        HeroCreateServiceModel heroToCreate = new HeroCreateServiceModel(heroName, Gender.MALE);

        service.createHeroForUser(user.getUsername(), heroToCreate);

        assertEquals(heroName, user.getHero().getName());
    }

    public void createHeroForUser_whenUserDoesNOTExist_shouldThrowException() {

    }

    @Test
    void createHeroForUser_whenUserExistsAndHasAHero_shouldThrowException() {
        User user = new User();
        user.setUsername("Pesho");
        user.setHero(new Hero());
        String heroName = "Gosho";
        Mockito.when(usersRepository.findByUsername(user.getUsername()))
                .thenReturn(user);

        HeroCreateServiceModel heroToCreate = new HeroCreateServiceModel(heroName, Gender.MALE);

        assertThrows(Exception.class, () ->
                service.createHeroForUser(user.getUsername(), heroToCreate));
    }
}