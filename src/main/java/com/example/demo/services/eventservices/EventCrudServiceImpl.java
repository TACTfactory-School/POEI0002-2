package com.example.demo.services.eventservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Event;
import com.example.demo.exeptions.NotFoundException;
import com.example.demo.repository.EventRepository;

@Service
public class EventCrudServiceImpl implements EventCrudService {

    @Autowired
    private EventRepository repository;

    @Autowired
    private EventCreateService createService;

    @Transactional(readOnly = true)
    @Override
    public List<Event> getAll() {
        return this.repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Event getOne(final long id) throws NotFoundException {
        return this.repository
                .findById(id)
                .orElseThrow(() -> new NotFoundException());
    }

    @Transactional()
    @Override
    public Event create(final Event event) {
        return this.createService.create(event);
    }

    public Event update(final Event event) {
        return this.repository.save(event);
    }

    @Override
    public void delete(long id) {
        this.repository.deleteById(id);
    }
}
