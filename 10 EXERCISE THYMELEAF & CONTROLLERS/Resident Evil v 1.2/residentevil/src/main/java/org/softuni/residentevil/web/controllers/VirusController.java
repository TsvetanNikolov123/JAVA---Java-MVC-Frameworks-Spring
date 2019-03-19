package org.softuni.residentevil.web.controllers;

import org.modelmapper.ModelMapper;
import org.softuni.residentevil.domain.entities.BaseEntity;
import org.softuni.residentevil.domain.models.binding.VirusAddBindingModel;
import org.softuni.residentevil.domain.models.binding.VirusEditBindingModel;
import org.softuni.residentevil.domain.models.binding.VirusShowBindingModel;
import org.softuni.residentevil.domain.models.service.CapitalServiceModel;
import org.softuni.residentevil.domain.models.service.VirusServiceModel;
import org.softuni.residentevil.domain.models.view.CapitalListViewModel;
import org.softuni.residentevil.domain.models.view.VirusListViewModel;
import org.softuni.residentevil.service.CapitalService;
import org.softuni.residentevil.service.VirusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/viruses")
public class VirusController extends BaseController {

    private final CapitalService capitalService;
    private final VirusService virusService;
    private final ModelMapper modelMapper;

    @Autowired
    public VirusController(CapitalService capitalService, VirusService virusService, ModelMapper modelMapper) {
        this.capitalService = capitalService;
        this.virusService = virusService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public ModelAndView add(
            @ModelAttribute(name = "bindingModel") VirusAddBindingModel bindingModel,
            ModelAndView modelAndView) {

        modelAndView.addObject("bindingModel", bindingModel);
        modelAndView.addObject("capitals", getCapitals());
        return super.view("add-virus", modelAndView);
    }

    @PostMapping("/add")
    public ModelAndView addConfirm(
            @Valid @ModelAttribute(name = "bindingModel") VirusAddBindingModel bindingModel,
            BindingResult bindingResult,
            ModelAndView modelAndView) {

        if (bindingResult.hasErrors()) {
            modelAndView.addObject("bindingModel", bindingModel);
            modelAndView.addObject("capitals", getCapitals());
            return super.view("add-virus", modelAndView);
        }
        VirusServiceModel virusServiceModel =
                this.virusService.addVirus(this.modelMapper.map(bindingModel, VirusServiceModel.class));
        if (virusServiceModel == null) {
            throw new IllegalArgumentException("Something went wrong!");
        }
        return super.redirect("/");
    }

    @GetMapping("/show")
    public ModelAndView show(
            @ModelAttribute VirusShowBindingModel bindingModel,
            ModelAndView modelAndView) {

        List<VirusListViewModel> viruses = this.virusService.findAllViruses()
                .stream()
                .map(v -> this.modelMapper.map(v, VirusListViewModel.class))
                .collect(Collectors.toList());
        modelAndView.setViewName("show-virus");
        modelAndView.addObject("viruses", viruses);
        return super.view("show-virus", modelAndView);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(
            @PathVariable("id") String id) {

        this.virusService.deleteVirusById(id);
        return super.redirect("/viruses/show");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(
            @PathVariable final String id,
            ModelAndView modelAndView,
            @ModelAttribute(name = "bindingModel") VirusEditBindingModel bindingModel) {

        Map<CapitalServiceModel, Boolean> infectedCapitals = new LinkedHashMap<>();
        VirusServiceModel virus = this.virusService.findVirusById(id);
        List<String> capitalsIds = virus.getCapitals().stream().map(BaseEntity::getId).collect(Collectors.toList());
        List<CapitalServiceModel> capitals = this.capitalService.findAllCapitals();
        for (CapitalServiceModel capital : capitals) {
            if (capitalsIds.contains(capital.getId())) {
                infectedCapitals.put(capital, true);
            } else {
                infectedCapitals.put(capital, false);
            }
        }
        modelAndView.addObject("capitals", infectedCapitals);
        bindingModel = this.modelMapper.map(virus, VirusEditBindingModel.class);
        modelAndView.addObject("bindingModel", bindingModel);
        return super.view("edit-virus", modelAndView);
    }

    @PostMapping("/edit/{id}")
    public ModelAndView edinConfirm(
            @PathVariable final String id,
            ModelAndView modelAndView,
            @Valid
            @ModelAttribute(name = "bindingModel") VirusEditBindingModel bindingModel,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            modelAndView.addObject("bindingModel", bindingModel);
            modelAndView.addObject("capitals", this.getCapitals());
            return super.view("edit-virus", modelAndView);
        }

        VirusServiceModel virusServiceModel = this.modelMapper.map(bindingModel, VirusServiceModel.class);
        this.virusService.editVirus(virusServiceModel);

        return super.redirect("/viruses/show");
    }

    private List<CapitalListViewModel> getCapitals() {
        return this.capitalService.findAllCapitals()
                .stream()
                .map(c -> this.modelMapper.map(c, CapitalListViewModel.class))
                .collect(Collectors.toList());
    }
}
