/**
 * 
 */
package com.justmeet.okBoomer.service;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.justmeet.okBoomer.model.Event;
import com.justmeet.okBoomer.model.EventUser;
import com.justmeet.okBoomer.model.User;
import com.justmeet.okBoomer.repository.EventUserRepository;

/**
 * @author Tommaso Cippitelli
 *
 */
@Service
public class EventUserServiceImpl implements EventUserService {

	@Autowired
	EventUserRepository repo;
	@Autowired
	UserService uService;
	@Autowired
	EventService eService;
	
	
	@Override
	public void save(EventUser eventUser) {
		repo.save(eventUser);
	}


	@Override
	public List<Event> eventsPartecipated(User id) {
		return repo.eventsPartecipated(id);
	}


	@Override
	public List<EventUser> findByUser(User u) {
		return repo.findByUser(u);
	}


	@Override
	public void delete(long id,Principal user) {
		User u= uService.findByUsername(user.getName());
		Event ev=eService.findById(id);
		List<EventUser> e =repo.findByUser(u);
		for(EventUser i: e) {
			if(i.getEvent().equals(ev) && i.getUser().equals(u)) {
				repo.delete(i);
			}
		}
		
	}


	@Override
	public long countByEvent(Event event) {
		return repo.countByEvent(event);
	}


	@Override
	public List<EventUser> notDuplicate(Event event, User user) {
		return repo.notDuplicate(event, user);
	}



}
