package softuni.heroes.web.view.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import softuni.heroes.services.models.LoginUserServiceModel;
import softuni.heroes.services.models.auth.RegisterUserServiceModel;
import softuni.heroes.services.services.AuthService;
import softuni.heroes.web.view.models.RegisterUserModel;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class AuthController {

    private final AuthService authService;
    private final ModelMapper modelMapper;

    public AuthController(AuthService authService, ModelMapper modelMapper) {
        this.authService = authService;
        this.modelMapper = modelMapper;
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
    public String register(@Valid  @ModelAttribute RegisterUserModel model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
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
            httpSession.setAttribute("user", loginUserServiceModel);
            return "redirect:/home";
        } catch (Exception e) {
            return "redirect:/users/login";
        }
    }
}
