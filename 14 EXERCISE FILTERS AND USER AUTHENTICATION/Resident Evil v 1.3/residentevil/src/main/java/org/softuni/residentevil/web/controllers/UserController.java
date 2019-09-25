package org.softuni.residentevil.web.controllers;

import org.modelmapper.ModelMapper;
import org.softuni.residentevil.domain.models.binding.UserRegisterBindingModel;
import org.softuni.residentevil.domain.models.service.UserServiceModel;
import org.softuni.residentevil.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController extends BaseController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/register")
    @PreAuthorize("isAnonymous()")
    public ModelAndView register() {
        return super.view("register");
    }

    @PostMapping("/register")
    public ModelAndView registerConfirm(
            @ModelAttribute(name = "model") UserRegisterBindingModel model,
            ModelAndView modelAndView) {

        if (!model.getPassword().equals(model.getConfirmPassword())) {
            return super.view("register");
        }
        // todo validaciq 01:30:00
        this.userService.registerUser(this.modelMapper.map(model, UserServiceModel.class));
        return super.redirect("/login");
    }

    @GetMapping("/login")
    @PreAuthorize("isAnonymous()")
    public ModelAndView login(){
        return super.view("login");
    }

    @PostMapping("/login")
    public ModelAndView loginConfirm(){
        return super.redirect("/home");
    }
}
