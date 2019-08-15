package com.springdatarest.eventmanagement.repos;

import java.time.ZoneId;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import com.springdatarest.eventmanagement.entities.Event;
import com.springdatarest.eventmanagement.entities.projections.PartialEventProjection;

@RepositoryRestResource(excerptProjection = PartialEventProjection.class)
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {
	// PagingAndSortingRepository<Event, Long> in return extends to
	// CrudRepository<Event, Long>

	Page<Event> findByName(@Param("name") String name, Pageable pageable);
	// http://localhost:8080/eventmanagement-api/events/search/findByName?name=Tom
	// Hardy Event and INC

	Page<Event> findByNameAndZoneId(@Param("name") String name, @Param("zoneId") ZoneId zoneId, Pageable pageable);

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	void delete(Long id);
}
