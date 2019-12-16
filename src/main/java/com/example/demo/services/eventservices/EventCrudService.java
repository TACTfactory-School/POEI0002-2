package com.example.demo.services.eventservices;

import com.example.demo.entities.Event;
import com.example.demo.exeptions.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EventCrudService {

  Page getAll(Pageable pageable);

  Event getOne(long id) throws NotFoundException;

  Event create(Event event);

  Event update(Event event);

  void delete(long id);
}
