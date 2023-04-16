package com.irctc.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.irctc.dto.Passenger;

public interface PassengerService extends CrudRepository<Passenger, Integer>{
	@Query("select p from Passenger p where p.ticket.id=:id")
	public Passenger findPassengerByTicket(@Param("id") int id);
}
