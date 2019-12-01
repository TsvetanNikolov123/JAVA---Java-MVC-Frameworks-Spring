package softuni.heroes.services.services.implementations;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.heroes.data.models.Hero;
import softuni.heroes.data.models.User;
import softuni.heroes.data.repositories.HeroesRepository;
import softuni.heroes.data.repositories.UsersRepository;
import softuni.heroes.services.models.HeroCreateServiceModel;
import softuni.heroes.services.services.HeroesService;
import softuni.heroes.services.services.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

    private final HeroesService heroesService;
    private final UsersRepository usersRepository;
    private final HeroesRepository heroesRepository;
    private final ModelMapper modelMapper;

    public UsersServiceImpl(
            HeroesService heroesService,
            UsersRepository usersRepository,
            HeroesRepository heroesRepository,
            ModelMapper modelMapper) {
        this.heroesService = heroesService;
        this.usersRepository = usersRepository;
        this.heroesRepository = heroesRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createHeroForUser(String username, HeroCreateServiceModel heroServiceModel) throws Exception {
        User user = usersRepository.findByUsername(username);
        if (user.getHero() != null) {
            throw new Exception("User already has a hero");
        }

        Hero hero = heroesService.create(heroServiceModel);
        user.setHero(hero);

        usersRepository.saveAndFlush(user);
    }
}
