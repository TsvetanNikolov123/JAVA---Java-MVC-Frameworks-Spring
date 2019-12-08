package softuni.heroes.services.services.validation;

import softuni.heroes.services.models.auth.RegisterUserServiceModel;

public interface AuthValidationService {
    boolean isValid(RegisterUserServiceModel user);
}
