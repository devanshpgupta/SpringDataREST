package com.springdatarest.eventmanagement.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.springdatarest.eventmanagement.entities.Participant;

public interface ParicipantRepository extends PagingAndSortingRepository<Participant, Long>{
//  extends CrudRepository<Participant, Long> 
	
	Page<Participant> findByEmail(@Param("email") String email,Pageable pageable);
}
