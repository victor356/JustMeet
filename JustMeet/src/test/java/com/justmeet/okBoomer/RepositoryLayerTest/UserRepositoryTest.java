package com.justmeet.okBoomer.RepositoryLayerTest;

import static org.assertj.core.api.Assertions.assertThat;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.justmeet.okBoomer.model.User;
import com.justmeet.okBoomer.repository.UserRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private UserRepository userRepository;

	@Test
	public void whenFindByUsername_thenReturnUser() {
	    // given
	    User alex = new User();
	    alex.setUsername("alex");
	    entityManager.persist(alex);
	    entityManager.flush();
	 
	    // when
	    User found = userRepository.findByUsername(alex.getUsername());
	 
	    // then
	    assertThat(found.getUsername())
	      .isEqualTo(alex.getUsername());
	}

}
