package softuni.heroes.web.view.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import softuni.heroes.data.models.Hero;
import softuni.heroes.data.repositories.HeroesRepository;
import softuni.heroes.services.models.auth.LoginUserServiceModel;
import softuni.heroes.services.models.auth.RegisterUserServiceModel;
import softuni.heroes.services.services.AuthService;
import softuni.heroes.web.view.models.RegisterUserModel;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class AuthController {

    private final AuthService authService;
    private final ModelMapper modelMapper;
    private final HeroesRepository heroesRepository;

    public AuthController(AuthService authService, ModelMapper modelMapper, HeroesRepository heroesRepository) {
        this.authService = authService;
        this.modelMapper = modelMapper;
        this.heroesRepository = heroesRepository;
    }

    @GetMapping("/login")
    public String getLoginForm() {
        return "auth/login.html";
    }

    @GetMapping("/register")
    public String getRegisterForm(Model model) {
        model.addAttribute("model", new RegisterUserModel());
        return "auth/register.html";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute RegisterUserModel model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "auth/register.html";
        }

        RegisterUserServiceModel serviceModel = modelMapper.map(model, RegisterUserServiceModel.class);
        authService.register(serviceModel);
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute RegisterUserModel model, HttpSession httpSession) {
        RegisterUserServiceModel serviceModel = modelMapper.map(model, RegisterUserServiceModel.class);
        try {
            LoginUserServiceModel loginUserServiceModel = authService.login(serviceModel);
            Optional<Hero> hero = heroesRepository
                    .getByUserUsername(loginUserServiceModel.getUsername());
            hero.ifPresent(value -> loginUserServiceModel.setHeroName(value.getName()));
            httpSession.setAttribute("user", loginUserServiceModel);
            return "redirect:/home";
        } catch (Exception e) {
            return "redirect:/users/login";
        }
    }
}
