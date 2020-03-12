/**
 * 
 */
package com.justmeet.okBoomer.web;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.justmeet.okBoomer.model.Event;
import com.justmeet.okBoomer.model.EventUser;
import com.justmeet.okBoomer.model.User;
import com.justmeet.okBoomer.service.EventService;
import com.justmeet.okBoomer.service.EventUserService;
import com.justmeet.okBoomer.service.UserService;
import com.justmeet.okBoomer.validator.EventUserValidator;

/**
 * @author Tommaso Cippitelli
 *
 */
@Controller
public class EventUserController {
	@Autowired
	EventUserService eUService;
	@Autowired
	private EventService eventService;
	@Autowired
	UserService userService;
	@Autowired
	EventUserValidator validator;

	
	@GetMapping("/addRequest")
	public String addRequest(@RequestParam long id,Model model,@ModelAttribute EventUser eu,
			Principal user,BindingResult result) {

		Event evento = eventService.findById(id);
		User u = userService.findByUsername(user.getName());
		eu= new EventUser();
		eu.setEvent(evento);
		eu.setUser(u);
		model.addAttribute(eu);
		validator.validate(eu, result);
		if (result.hasErrors()) {
			return "eventDetails?id";
		}
		else {
		eUService.save(eu);
		return "addRequest";
		}
	}
	
	@GetMapping("/eventsPartecipated")
	public String eventsPartecipated(Model model, Principal user) {
		User u= userService.findByUsername(user.getName());
		model.addAttribute("ePartecipated", eUService.eventsPartecipated(u));
		return "eventsPartecipated";
	}
	
	
	@GetMapping("/removeRequest")
	public String removeRequest(@RequestParam long id,Principal user) {
		eUService.delete(id, user);
		
		return "redirect:/eventsPartecipated";
		
	}
	
}
