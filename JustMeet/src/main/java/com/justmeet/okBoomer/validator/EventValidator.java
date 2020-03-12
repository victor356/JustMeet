/**
 * 
 */
package com.justmeet.okBoomer.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.justmeet.okBoomer.model.Event;
import com.justmeet.okBoomer.service.EventService;

/**
 * @author Tommaso Cippitelli
 *
 */
@Component
public class EventValidator implements Validator{

     EventService eventService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Event.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Event event =(Event) target;
		
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "titolo", "NotEmpty");
        if (event.getTitolo().length() < 6 || event.getTitolo().length() > 32) {
            errors.rejectValue("titolo", "Size.eventForm.titolo");
        } 
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descrizione", "NotEmpty");
        if (event.getDescrizione().length() > 100) {
        	errors.rejectValue("descrizione", "Size.eventForm.descrizione");
        }
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dataEvento", "NotEmpty");
        if (event.getDataEvento().before(event.getScadenzaPagamento()) ) {
        	errors.rejectValue("dataEvento", "Size.eventForm.dataEvento");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "scadenzaPagamento", "NotEmpty");
        if (event.getScadenzaPagamento().after(event.getDataEvento()) ) {
        	errors.rejectValue("scadenzaPagamento", "Size.eventForm.scadenzaPagamento");
        }
	}

}
