package com.justmeet.okBoomer.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import com.justmeet.okBoomer.model.Category;
import com.justmeet.okBoomer.model.Event;

public interface EventRepository extends JpaRepository<Event, Long>{
  List<Event> findByTitolo(String titolo);
  List<Event> findByOwner(String string);
  Event findById(long id);
  
 
  List<Event> findByCategoriaAndDataEvento( @Param(value = "categoria") Category categoria,
		  @Param(value = "dataEvento")  Date dataEvento);
 
  Optional<Event> findById( Long id);
  
  void deleteById(long id);


}