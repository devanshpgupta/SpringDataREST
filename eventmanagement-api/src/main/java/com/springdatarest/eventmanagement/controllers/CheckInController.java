package com.springdatarest.eventmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springdatarest.eventmanagement.controllers.exception.AlreadyExistingException;
import com.springdatarest.eventmanagement.entities.Participant;
import com.springdatarest.eventmanagement.repos.ParicipantRepository;

@RepositoryRestController
@RequestMapping("/events")
public class CheckInController {

	@Autowired
	private ParicipantRepository participantRepository;

	@PostMapping("/checkin/{id}")
	public ResponseEntity<PersistentEntityResource> checkin(@PathVariable Long id,PersistentEntityResourceAssembler assembler) throws AlreadyExistingException
	{
		Participant participant = participantRepository.findOne(id);
		if(participant == null)
			throw new ResourceNotFoundException();
		
		if(participant.getCheckedIn())
			throw new AlreadyExistingException(participant.getEmail());

		
		participant.setCheckedIn(true);
		
		participantRepository.save(participant);
		
		return ResponseEntity.ok(assembler.toResource(participant));
	}
}
