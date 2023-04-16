package com.irctc.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String startLocation;
	private String endLocation;
	private String trainNum;
	private int tktCost;
	private String tktStatus;
	@OneToOne(mappedBy = "ticket")
	@JsonBackReference
	private Passenger passenger;
}
