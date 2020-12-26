package com.justmeet.okBoomer.web;

import java.security.Principal;
import java.sql.Date;
import java.util.ArrayList;

import com.justmeet.okBoomer.model.Category;
import com.justmeet.okBoomer.model.Event;
import com.justmeet.okBoomer.model.User;
import com.justmeet.okBoomer.service.EventService;
import com.justmeet.okBoomer.service.EventUserService;
import com.justmeet.okBoomer.service.UserService;
import com.justmeet.okBoomer.validator.EventValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EventController {
	@Autowired
	private EventService eventService;
	@Autowired
	UserService userService;
	@Autowired
	EventUserService eUService;
	@Autowired 
	EventValidator eventValidator;
	

	@GetMapping(value = "/newEvent")
	public String createEvent(Model model) {
		model.addAttribute("eventForm", new Event());
		return "newEvent";
	}

	@PostMapping("/newEvent")
	public String createEvent(@ModelAttribute("eventForm") Event eventForm, Model model,
			Principal principal, BindingResult bindingResult) {
		eventValidator.validate(eventForm, bindingResult);
		
		if (bindingResult.hasErrors()) {
			return "newEvent";
        }
		User u = userService.findByUsername(principal.getName());
		eventForm.setOwner(u.getUsername());
		eventService.save(eventForm);
		return "redirect:/modifySummary.jsp";
	}

	@GetMapping("/searchEvent")
	public String searchEventBy(Model model) {
		model.addAttribute("searchForm", new Event());
		model.addAttribute("showAllEvent", eventService.getAllEvent());
		return "searchEvent";
	}

	@PostMapping("/searchEvent")
	public String searchEventBy(@ModelAttribute("searchForm") Event searchForm,
			@ModelAttribute("searchResults") ArrayList<Event> searchResults, Model model,
			@Param(value = "categoria") Category categoria, @Nullable @Param(value = "dataEvento") Date dataEvento) {
		searchResults.addAll(eventService.searchBy(categoria, dataEvento));
		model.addAllAttributes(searchResults);
		return "searchResult";
	}

	@GetMapping(value = "/eventDetails")
	public String showDetailsEvent(@RequestParam long id, Model model) {
		Event e= eventService.findById(id);
		model.addAttribute("eventDetail", eventService.showDetails(id).get());
		model.addAttribute("countPartecipated", eUService.countByEvent(e));
		return ("eventDetails");
	}


	@GetMapping("/myEvents")
	public String findMyEvents(Principal user, Model model) {
		model.addAttribute("mySearchResult",eventService.findByUserUsername(user));
		return ("myEvents");

	}

	@GetMapping("/modifyEvents")
	public String modifyEvent(Model model, @RequestParam long id) {
		model.addAttribute("modifyEvent", eventService.showDetails(id).get());
		return "modifyEvents";
	}

	@PostMapping("/modifyEvents")
	public String modifyEvent(@ModelAttribute("modifyEvent") Event modifyEvent, Principal user) {
		modifyEvent.setOwner(user.getName());
		eventService.save(modifyEvent);
		return "redirect:/modifySummary.jsp";
		
	}

	@GetMapping("/deleteEvents")
	public String deleteEvents(Model model, @RequestParam long id,Principal user) {
		eUService.delete(id, user);
		eventService.deleteById(id);
		return "redirect:/modifySummary.jsp";
	}
	
	

}
