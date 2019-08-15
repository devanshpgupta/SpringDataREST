package com.springdatarest.eventmanagement.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.springdatarest.eventmanagement.entities.Venue;

public interface VenueRepository extends PagingAndSortingRepository<Venue, Long>{
//  extends CrudRepository<Venue, Long> 
	
	Page<Venue> findByPostalcode(@Param("postalcode") String postalcode,Pageable pageable);
}
