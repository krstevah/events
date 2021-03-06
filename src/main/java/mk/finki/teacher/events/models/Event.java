package mk.finki.teacher.events.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import mk.finki.teacher.events.models.enums.EventType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private int event_id;

    @Column(name = "name")
    private String eventName;

    @Column(name = "event_from")
    private LocalDateTime eventDateFrom;

    @Column(name = "event_to")
    private LocalDateTime eventDateTo;

    @Column(name = "location")
    private String location;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private EventType eventType;

    @JsonIgnore
    @ManyToMany(mappedBy = "events")
    private List<Teacher> teachers;

    public Event(){
    }

    public Event(String eventName, LocalDateTime eventDateFrom, LocalDateTime eventDateTo, String location, EventType eventType) {
        this.eventName = eventName;
        this.eventDateFrom = eventDateFrom;
        this.eventDateTo = eventDateTo;
        this.location = location;
        this.eventType = eventType;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDateTime getEventDateFrom() {
        return eventDateFrom;
    }

    public void setEventDateFrom(LocalDateTime eventDateFrom) {
        this.eventDateFrom = eventDateFrom;
    }

    public LocalDateTime getEventDateTo() {
        return eventDateTo;
    }

    public void setEventDateTo(LocalDateTime eventDateTo) {
        this.eventDateTo = eventDateTo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

}
