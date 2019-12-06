package softuni.heroes.web.view.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import softuni.heroes.errors.HeroNotFoundException;
import softuni.heroes.services.models.heroes.HeroCreateServiceModel;
import softuni.heroes.services.models.heroes.HeroDetailsServiceModel;
import softuni.heroes.services.models.auth.LoginUserServiceModel;
import softuni.heroes.services.services.HeroesService;
import softuni.heroes.services.services.UsersService;
import softuni.heroes.web.base.BaseController;
import softuni.heroes.web.view.models.HeroCreateModel;
import softuni.heroes.web.view.models.HeroDetailsViewModel;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/heroes")
public class HeroesController extends BaseController {
    private final HeroesService heroesService;
    private final ModelMapper modelMapper;
    private final UsersService usersService;

    public HeroesController(HeroesService heroesService, ModelMapper modelMapper, UsersService usersService) {
        this.heroesService = heroesService;
        this.modelMapper = modelMapper;
        this.usersService = usersService;
    }

    @GetMapping("/details/{name}")
    public ModelAndView getHeroDetails(@PathVariable String name, ModelAndView modelAndView) {
        HeroDetailsServiceModel serviceModel = heroesService.getByName(name);
        HeroDetailsViewModel viewModel = modelMapper.map(serviceModel, HeroDetailsViewModel.class);
        modelAndView.addObject("hero", viewModel);
        modelAndView.setViewName("heroes/hero-details.html");
        return modelAndView;
    }

    @GetMapping("/create")
    public String getCreateHeroForm(HttpSession session) {
        if (!isAuthenticated(session)) {
            return "redirect:/users/login";
        }
        return "heroes/create-hero.html";
    }

    @PostMapping("/create")
    public String createHero(@ModelAttribute HeroCreateModel hero, HttpSession session) {
        if (!isAuthenticated(session)) {
            return "/";
        }

        String username = getUsername(session);

        HeroCreateServiceModel serviceModel = modelMapper.map(hero, HeroCreateServiceModel.class);
        try {
            usersService.createHeroForUser(username, serviceModel);
            LoginUserServiceModel loginUserServiceModel = new LoginUserServiceModel(username, hero.getName());
            session.setAttribute("user", loginUserServiceModel);
            return "redirect:/heroes/details/" + hero.getName();
        } catch (Exception ex) {
            return "redirect:/heroes/create";
        }
    }

    @ExceptionHandler(HeroNotFoundException.class)
    public ModelAndView handleException(HeroNotFoundException exception) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("message", exception.getMessage());

        return modelAndView;
    }
}
