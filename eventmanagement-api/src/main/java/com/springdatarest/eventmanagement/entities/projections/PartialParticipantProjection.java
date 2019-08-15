package com.springdatarest.eventmanagement.entities.projections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import com.springdatarest.eventmanagement.entities.Participant;

@Projection(types = { Participant.class }, name = "participantPartial")
public interface PartialParticipantProjection {

	String getName();

	Boolean getCheckedIn();

	@Value("#{target.email} has checkedIn = #{target.checkedIn}")
	String getEmailPlusCheckedIn();

}
