package com.justmeet.okBoomer.RepositoryLayerTest;

import static org.assertj.core.api.Assertions.assertThat;

import com.justmeet.okBoomer.model.Event;
import com.justmeet.okBoomer.repository.EventRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@DataJpaTest
public class EventsRepositoryTest {

	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private EventRepository eventsRepository;
    
    @Test
	public void whenFindByName_thenReturnEvent() {
	    // given
	    Event evento = new Event();
	    evento.setTitolo("Partita di calcetto");
	    entityManager.persist(evento);
	    entityManager.flush();
	 
	    // when
	    Event found = eventsRepository.findByTitolo(evento.getTitolo()).get(0);
	 
	    // then
	    assertThat(found.getTitolo())
	      .isEqualTo(evento.getTitolo());
	}
    
    @Test
	public void whenFindById_thenReturnEvent() {
	    // given
	    Event evento = new Event();
	    entityManager.persist(evento);
	    entityManager.flush();
	    
	    long id=evento.getId();
	    // when
	    Event found = eventsRepository.findById(id);
	 
	    // then
	    assertThat(found.getId())
	      .isEqualTo(evento.getId());
	}

}
