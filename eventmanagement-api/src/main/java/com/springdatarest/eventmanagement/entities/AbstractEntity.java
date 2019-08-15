package com.springdatarest.eventmanagement.entities;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author dgupta51
 *
 */
@MappedSuperclass
public class AbstractEntity {

	@Id
	@Column(nullable = false, updatable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected long id;
	
	@CreationTimestamp
	@Column(updatable = false)
	@JsonIgnore
	private Instant created;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Instant getCreated() {
		return created;
	}

	public void setCreated(Instant created) {
		this.created = created;
	}
	
	public long getResourceId() {
		return this.id;
	}
	
	
}
