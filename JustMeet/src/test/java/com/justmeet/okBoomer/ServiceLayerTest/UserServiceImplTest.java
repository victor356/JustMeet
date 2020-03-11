package com.justmeet.okBoomer.ServiceLayerTest;

import static org.assertj.core.api.Assertions.assertThat;



import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.justmeet.okBoomer.model.User;
import com.justmeet.okBoomer.repository.UserRepository;
import com.justmeet.okBoomer.service.UserService;
import com.justmeet.okBoomer.service.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
	
	@TestConfiguration
    static class UserServiceImplTestContextConfiguration {
  
        @Bean
        public UserService userService() {
            return new UserServiceImpl();
        }
    }

	@Autowired
    private UserService userService;
	@MockBean
    private UserRepository userRepository;
	
	@Before
	public void setUp() {
	    User matteo = new User();
	    matteo.setUsername("Tommaso");
	    Mockito.when(userRepository.findByUsername(matteo.getUsername()))
	      .thenReturn(matteo);
	}
	
	@Test
	public void whenValidUsername_thenUserShouldBeFound() {
	    String name = "Tommaso";
	    User found = userService.findByUsername(name);
	     assertThat(
	    		 found.getUsername())
	      .isEqualTo(name);
	 }
	
}
