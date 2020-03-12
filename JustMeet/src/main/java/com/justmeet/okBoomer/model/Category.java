/**
 * 
 */
package com.justmeet.okBoomer.model;

import javax.persistence.Enumerated;

/**
 * @author  Cippitelli, Rinaldi
 *
 */
public enum Category {
	@Enumerated
     SPORT,
     CALCIO,
     CALCETTO,
     PALLAVOLO,
     TENNIS,
     BEACH_VOLLEY,
     SERVIZI,
     RIPETIZIONI,
     GIOCHI_DA_TAVOLO;
     

   
}

