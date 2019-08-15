package com.springdatarest.eventmanagement.repos;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.springdatarest.eventmanagement.entities.Organizer;

public interface OrganizerRepository extends PagingAndSortingRepository<Organizer, Long>
{
//  extends CrudRepository<Organizer, Long> 
}
