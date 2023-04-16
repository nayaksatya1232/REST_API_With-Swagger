package com.irctc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.irctc.Train;
import com.irctc.dto.Passenger;
import com.irctc.dto.Ticket;
import com.irctc.service.PassengerService;

@RestController
public class MainController {
	@Autowired
	public PassengerService p;
	@PostMapping("/book")
	public Ticket bookTicket(@RequestBody Passenger ps) {
		Ticket t = Train.bookTicket(ps).get();
		if(t!=null) {
			ps.setTicket(t);
			this.p.save(ps);
		}
		System.out.println(ps);
		System.out.println(t);
		return t;
	}
	@GetMapping("/check/{tktNo}")
	public Passenger checkTicket(@PathVariable("tktNo") int tktNo) {
		return this.p.findPassengerByTicket(tktNo);
	}
}
