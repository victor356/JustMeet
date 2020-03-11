/**
 * 
 */
package com.justmeet.okBoomer.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Tommaso Cippitelli
 *
 */
//
@Entity
@Table(name = "event_partecipated")
public class EventUser {
	@Id
	@Column(name="id") 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	
	@ManyToOne
    private Event  event;
	
	@ManyToOne
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



	

}
