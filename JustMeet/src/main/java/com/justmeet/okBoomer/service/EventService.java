/**
 * 
 */
package com.justmeet.okBoomer.service;

import java.security.Principal;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.justmeet.okBoomer.model.Category;
import com.justmeet.okBoomer.model.Event;

/**
 * @author Tommaso Cippitelli
 *
 */
public interface EventService {

	List<Event> findByTitolo(String titolo);

	public List<Event> searchBy(@Param(value = "categoria") Category categoria,
			@Param(value = "dataEvento") Date dataEvento);

	void save(Event event);

	List<Event> findByUserUsername(Principal user);

	Optional<Event> showDetails(Long id);

	void deleteById(long id);

	Event findById(long id);

	List<Event> getAllEvent();
	

}
