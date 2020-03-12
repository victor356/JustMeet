package com.justmeet.okBoomer.web;

import com.justmeet.okBoomer.model.User;
import com.justmeet.okBoomer.service.SecurityService;
import com.justmeet.okBoomer.service.UserService;
import com.justmeet.okBoomer.validator.UserValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * @author  Cippitelli, Rinaldi
 *
 */

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
        	return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());
        System.out.println(userForm.getId());
        return "redirect:/index.jsp";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null) {
        	
        	model.addAttribute("error", "Your username and password is invalid.");
        }

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @GetMapping({"/", "/welcome"})
    public String welcome(Model model) {
        return "index";
    }
}
