/**
 * 
 */
package com.justmeet.okBoomer.service;

import java.security.Principal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.justmeet.okBoomer.model.Category;
import com.justmeet.okBoomer.model.Event;
import com.justmeet.okBoomer.repository.EventRepository;
import com.justmeet.okBoomer.repository.UserRepository;

/**
 * @author Tommaso Cippitelli
 *
 */
@Service
public class EventServiceImpl implements EventService {

	@Autowired
	EventRepository repository;
	@Autowired
	UserRepository userRepository;

	@Override
	public void save(Event event) {
		repository.save(event);
	}

	@Override
	public List<Event> findByTitolo(String titolo) {
		return repository.findByTitolo(titolo);
	}

	@Override
	public List<Event> searchBy(@Param(value = "categoria") Category categoria,
			@Param(value = "dataEvento") Date dataEvento) {
		ArrayList<Event> searchResults = (ArrayList<Event>) repository.findByCategoriaAndDataEvento(categoria,
				dataEvento);
		return searchResults;
	}

	@Override
	public Optional<Event> showDetails(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<Event> findByUserUsername(Principal user) {
		List<Event> u = repository.findByOwner(user.getName());
		return u;
	}


	public void deleteById(long id) {
		repository.deleteById(id);

	}

	@Override
	public Event findById(long id) {
		return repository.findById(id);
	}

	@Override
	public List<Event> getAllEvent() {
		return repository.findAll();
	}

}
