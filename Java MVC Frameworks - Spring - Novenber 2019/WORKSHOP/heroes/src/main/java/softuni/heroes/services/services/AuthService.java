package softuni.heroes.services.services;

import softuni.heroes.services.models.auth.LoginUserServiceModel;
import softuni.heroes.services.models.auth.RegisterUserServiceModel;

public interface AuthService {

    void register(RegisterUserServiceModel model);

    LoginUserServiceModel login(RegisterUserServiceModel serviceModel) throws Exception;
}
