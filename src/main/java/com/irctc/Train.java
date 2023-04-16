package com.irctc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.irctc.dto.Passenger;
import com.irctc.dto.Ticket;

public enum Train {
	T1("112233", "Rajdhani Express", 2500, 10), T2("554433", "Surat Express", 900, 20),
	T3("102030", "Chennai Passenger", 200, 100), T4("504030", "Bengaluru SuperFast Express", 3500, 30),
	T5("101010", "Mysore Express", 1300, 50);

	
	private Train(String trainNo, String trainName, int cost, int seatsAvailable) {
		this.trainNo = trainNo;
		this.trainName = trainName;
		this.cost = cost;
		this.seatsAvailable = seatsAvailable;
	}

	private static List<Train> trainList = Arrays.asList(T1, T2, T3, T4, T5);
	private String trainNo;
	private String trainName;
	private int cost;
	private int seatsAvailable;

	private static Ticket book(Passenger ps) {
		System.out.println("Start");
		Train train = trainList.stream().filter(t -> t.trainNo.equals(ps.getTrainNum())).findFirst().get();
		System.out.println("End");
		if (train.seatsAvailable > 0) {
			train.seatsAvailable--;
			Ticket t = new Ticket();
			t.setStartLocation(ps.getStartLocation());
			t.setEndLocation(ps.getEndLocation());
			t.setTrainNum(ps.getTrainNum());
			t.setTktCost(train.getCost());
			t.setTktStatus("Confirmed");
			return t;
		}
		return null;
	}

	public String getTrainNo() {
		return trainNo;
	}

	public String getTrainName() {
		return trainName;
	}

	public int getCost() {
		return cost;
	}

	public int getSeatsAvailable() {
		return seatsAvailable;
	}

	public static Optional<Ticket> bookTicket(Passenger ps) {
		return Optional.of(book(ps));
	}

}
