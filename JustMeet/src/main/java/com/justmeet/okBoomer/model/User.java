package com.justmeet.okBoomer.model;
/*login class*/
import javax.persistence.*;

import java.util.List;
import java.util.Set;

/**
 * @author  Cippitelli, Rinaldi
 *
 */

@Entity
@Table(name = "user")
public class User {
    @Id
	@Column(name="id") 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @Transient
    private String passwordConfirm;

    
    @ManyToMany
    private Set<Role> roles;
    
    
    @OneToMany(mappedBy="user")
    private List<EventUser>  eventsPartecipated;
   


	/**
	 * @param id
	 * @param username
	 * @param password
	 * @param passwordConfirm
	 * @param roles
	 */
	public User(Long id, String username, String password, String passwordConfirm, Set<Role> roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.roles = roles;
	}
    
    
    public User() {
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


	public List<EventUser> getEventsPartecipated() {
		return eventsPartecipated;
	}


	public void setEventsPartecipated(List<EventUser> eventsPartecipated) {
		this.eventsPartecipated = eventsPartecipated;
	}



    
}
