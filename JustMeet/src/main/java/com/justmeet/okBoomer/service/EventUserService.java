/**
 * 
 */
package com.justmeet.okBoomer.service;

import java.security.Principal;
import java.sql.Date;
import java.util.List;

import com.justmeet.okBoomer.model.Category;
import com.justmeet.okBoomer.model.Event;
import com.justmeet.okBoomer.model.EventUser;
import com.justmeet.okBoomer.model.User;

/**
 * @author Tommaso Cippitelli
 *
 */
public interface EventUserService {

	void save(EventUser eventUser);
	
	List<Event> eventsPartecipated(User id);
	
	List<EventUser> findByUser(User u);

	void delete(long id,Principal user);
	
	long countByEvent(Event event);
	
	List<EventUser> notDuplicate(Event event,User user);

	

}
