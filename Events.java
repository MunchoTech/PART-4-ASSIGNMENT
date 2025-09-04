package com.StudentclubManagement.Clubmanagement.Model;

import jakarta.persistence.*;
import java.time.LocalDate;

// Event.java
@Entity
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Event_id;

    private String Event_name;
    private Long Room_id;

    private LocalDate Event_date;

    @ManyToOne
    @JoinColumn(name = "Club_id")
    private Clubs club;

    // getters & setters
    public Long getEventId() { 
        return Event_id; 
    }
    public void setId(Long Event_id) { 
        this.Event_id = Event_id; 
    }

    public String getEventName() { 
        return Event_name; 
    }
    public void setEventName(String Event_name) { 
        this.Event_name = Event_name; 
    }
        public Long getRoomId() {
        return Room_id;
    }
    public void setRoomId(Long Room_id) {
        this.Room_id = Room_id;
    }

    public LocalDate getEventDate() { 
        return Event_date; 
    }
    public void setEventDate(LocalDate Event_date) { 
        this.Event_date = Event_date; 
    }

    public Clubs getClub() { 
        return club; 
    }
    public void setClub(Clubs club) { 
        this.club = club; 
    }
}
