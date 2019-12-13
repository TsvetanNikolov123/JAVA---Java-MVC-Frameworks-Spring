package softuni.heroes.web.view.controllers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import softuni.heroes.services.services.HeroesService;
import softuni.heroes.web.base.BaseController;
import softuni.heroes.web.view.models.HeroHomeModel;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class HomeController extends BaseController {

    private final HeroesService heroesService;
    private final ModelMapper modelMapper;

    @GetMapping("/")
    public String getIndex(HttpSession httpSession) {
        return "home/index.html";
    }

    @GetMapping("/home")
    public ModelAndView getHome(ModelAndView modelAndView, HttpSession session) {
        modelAndView.setViewName("home/home");
        boolean condition = heroesService.areThereOpponents();

        List<HeroHomeModel> heroHomeModels = heroesService
                .getOpponents(getHeroName(session))
                .stream()
                .map(heroDetailsServiceModel -> modelMapper.map(heroDetailsServiceModel, HeroHomeModel.class))
                .collect(Collectors.toList());

        modelAndView.addObject("condition", condition);
        modelAndView.addObject("heroes", heroHomeModels);

        return modelAndView;
    }
}
