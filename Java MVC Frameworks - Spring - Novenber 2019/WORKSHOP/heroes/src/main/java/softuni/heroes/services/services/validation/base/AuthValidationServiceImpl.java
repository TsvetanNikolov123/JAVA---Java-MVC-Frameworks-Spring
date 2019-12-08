package softuni.heroes.services.services.validation.base;

import org.springframework.stereotype.Service;
import softuni.heroes.data.repositories.UsersRepository;
import softuni.heroes.services.models.auth.RegisterUserServiceModel;
import softuni.heroes.services.services.validation.AuthValidationService;

@Service
public class AuthValidationServiceImpl implements AuthValidationService {

    private final UsersRepository usersRepository;

    public AuthValidationServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public boolean isValid(RegisterUserServiceModel user) {
        return this.isEmailValid(user.getEmail()) &&
                this.arePasswordsValid(user.getPassword(), user.getConfirmPassword()) &&
                this.isUsernameTaken(user.getUsername());
    }

    private boolean arePasswordsValid(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

    private boolean isUsernameTaken(String username) {
        return !usersRepository.existsByUsername(username);
    }

    private boolean isEmailValid(String email) {
        // todo
        return true;
    }
}
