package com.springdatarest.eventmanagement.entities.projections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import com.springdatarest.eventmanagement.entities.Venue;

@Projection(types = { Venue.class }, name = "streetAddressVirtual")
public interface StreetAddressProjection {

	@Value("#{target.streetaddress} #{target.streetaddress2}")
	String getCompleteStreetAddress();

}
