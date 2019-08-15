package com.springdatarest.eventmanagement.entities;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.rest.core.annotation.RestResource;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"started"})
@Entity
public class Event extends AbstractEntity {
	// ID INT NOT NULL AUTO_INCREMENT,
	// CREATED TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	// NAME VARCHAR(256),
	// DESCRIPTION VARCHAR(2048),
	// START_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	// END_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	// ZONE_ID VARCHAR(128),
	// STARTED INT,
	// ORGANIZER_ID INT NOT NULL,
	// VENUE_ID INT,
	// PRIMARY KEY(ID),
	// FOREIGN KEY (ORGANIZER_ID) REFERENCES ORGANIZER(ID) ON DELETE CASCADE,
	// FOREIGN KEY (VENUE_ID) REFERENCES VENUE(ID)

	@Column
	private String name;

	@JsonProperty("White Box Description")
	@Column
	private String description;

	@Column
	private ZonedDateTime startDate;

	@Column
	private ZonedDateTime endDate;

	@Column
	private ZoneId zoneId;

	@Column
	private Boolean started;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false)
	// Join Column since this is not a direct column in database
	private Organizer organizer;

	@JsonIgnore
	@OneToMany(mappedBy = "event", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Participant> participants;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@RestResource(exported = false)
	private Venue venue;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ZonedDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(ZonedDateTime startDate) {
		this.startDate = startDate;
	}

	public ZonedDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(ZonedDateTime endDate) {
		this.endDate = endDate;
	}

	public ZoneId getZoneId() {
		return zoneId;
	}

	public void setZoneId(ZoneId zoneId) {
		this.zoneId = zoneId;
	}

	public Boolean getStarted() {
		return started;
	}

	public void setStarted(Boolean started) {
		this.started = started;
	}

	public Organizer getOrganizer() {
		return organizer;
	}

	public void setOrganizer(Organizer organizer) {
		this.organizer = organizer;
	}

	public Set<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(Set<Participant> participants) {
		this.participants = participants;
	}

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}
	
	@Override
	public boolean equals(Object obj) {
		return Objects.equals(id, ((Event) obj).id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}




}
