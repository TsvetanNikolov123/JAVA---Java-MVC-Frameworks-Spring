package softuni.heroes.services.services.implementations;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.heroes.data.models.User;
import softuni.heroes.data.repositories.UsersRepository;
import softuni.heroes.services.models.LoginUserServiceModel;
import softuni.heroes.services.models.auth.RegisterUserServiceModel;
import softuni.heroes.services.services.AuthService;
import softuni.heroes.services.services.AuthValidationService;
import softuni.heroes.services.services.HashingService;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthValidationService authValidationService;
    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper;
    private final HashingService hashingService;

    public AuthServiceImpl(
            AuthValidationService authValidationService,
            UsersRepository usersRepository,
            ModelMapper modelMapper,
            HashingService hashingService) {
        this.authValidationService = authValidationService;
        this.usersRepository = usersRepository;
        this.modelMapper = modelMapper;
        this.hashingService = hashingService;
    }

    @Override
    public void register(RegisterUserServiceModel model) {
        if (!authValidationService.isValid(model)) {
            // todo do something
            return;
        }

        User user = modelMapper.map(model, User.class);
        user.setPassword(hashingService.hash(user.getPassword()));
        usersRepository.save(user);
    }

    @Override
    public LoginUserServiceModel login(RegisterUserServiceModel serviceModel) throws Exception {
        String passwordHashed = hashingService.hash(serviceModel.getPassword());
        return usersRepository
                .findByUsernameAndPassword(serviceModel.getUsername(), passwordHashed)
                .map(user -> {
                    String heroName = user.getHero() == null
                            ? null
                            :user.getHero().getName();

                    return new LoginUserServiceModel(serviceModel.getUsername(), heroName);
                })
                .orElseThrow(() -> new Exception("Invalid user"));
    }
}
