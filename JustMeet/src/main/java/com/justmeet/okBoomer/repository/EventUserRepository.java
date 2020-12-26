package com.justmeet.okBoomer.repository;

import java.util.List;

import com.justmeet.okBoomer.model.Event;
import com.justmeet.okBoomer.model.EventUser;
import com.justmeet.okBoomer.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EventUserRepository extends JpaRepository<EventUser, Long> {

	@Query(value="select e from EventUser u,Event e where u.user=:id and e.id=u.event")
	  List<Event> eventsPartecipated(User id);

	  List<EventUser> findByUser(User u);
	  
	  long countByEvent(Event event);
	  
	  @Query("select eu from EventUser eu where eu.event=:event and eu.user=:user")
	  List<EventUser> notDuplicate(Event event,User user);
	  

	
}
