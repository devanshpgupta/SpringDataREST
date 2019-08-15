package com.springdatarest.eventmanagement.entities.projections;

import java.time.Instant;
import java.time.ZonedDateTime;

import org.springframework.data.rest.core.config.Projection;

import com.springdatarest.eventmanagement.entities.Event;

@Projection(types = { Event.class }, name = "partialEventaData")
public interface PartialEventProjection {

	String getName();

	ZonedDateTime getStartDate();

	ZonedDateTime getEndDate();

	long getResourceId();
	
	//Can even return hidden data i.e. @JsonIgnore
	Instant getCreated();
}
