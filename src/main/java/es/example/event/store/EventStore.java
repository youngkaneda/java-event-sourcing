package es.example.event.store;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import es.example.event.DomainEvent;
import es.example.event.repository.EventRepository;
import es.example.event.repository.specification.AllEventsSpecification;
import es.example.mq.Producer;

/**
 * 
 * @author kuuhaku
 */
public class EventStore {

    private final EventRepository<DomainEvent> repo;
    private ObjectMapper mapper;
    private final Producer producer;

    public EventStore(EventRepository<DomainEvent> repo, Producer producer) {
        this.repo = repo;
        this.mapper = new ObjectMapper();
        this.producer = producer;
    }
    
    public void store(DomainEvent event) {
        repo.save(event);
        dispatch(event);
    }

    public List<DomainEvent> getEvents() {
        return repo.query(new AllEventsSpecification());
    }
    
    private void dispatch(DomainEvent event) {
        if(mapper == null)
            mapper = new ObjectMapper();
        try {
            String jsonEvent = mapper.writeValueAsString(event);
            producer.send(jsonEvent);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        
    }
}
