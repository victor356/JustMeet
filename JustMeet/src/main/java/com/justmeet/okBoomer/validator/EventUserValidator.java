/**
 * 
 */
package com.justmeet.okBoomer.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.justmeet.okBoomer.model.EventUser;
import com.justmeet.okBoomer.service.EventUserService;
/**
 * @author Tommaso Cippitelli
 *
 */
@Component
public class EventUserValidator implements Validator{
	
	@Autowired
	EventUserService eUService;
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		EventUser  eUser = (EventUser) target;
		
		   if (!(eUService.notDuplicate(eUser.getEvent(), eUser.getUser()).isEmpty())) {
	            errors.reject("You are already participating in this event.");
	        }
		
		
	}

	

}
