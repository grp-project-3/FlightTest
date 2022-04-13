package com.flightPackage;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="Fleet")
public class Fleet 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message="Code should be given for each flight")
	private String code;
	
	@NotNull(message="Model name must be mention")
	private String model;
	
	@NotNull
	@Column(name="EconomySeats")
	private int totalEconomySeats;
	
	@NotNull
	@Column(name="PremiumSeats")
	private int totalPremiumSeats;
	
	@NotNull
	@Column(name="BusinessSeats")
	private int totalBusinessSeats;
	
	@OneToOne(mappedBy = "fleet")
	private Flight flight;
	
	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Fleet() {}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getCode() 
	{
		return code;
	}

	public void setCode(String code) 
	{
		this.code = code;
	}

	public String getModel() 
	{
		return model;
	}

	public void setModel(String model) 
	{
		this.model = model;
	}

	public int getTotalEconomySeats() 
	{
		return totalEconomySeats;
	}

	public void setTotalEconomySeats(int totalEconomySeats) 
	{
		this.totalEconomySeats = totalEconomySeats;
	}

	public int getTotalPremiumSeats() 
	{
		return totalPremiumSeats;
	}

	public void setTotalPremiumSeats(int totalPremiumSeats) 
	{
		this.totalPremiumSeats = totalPremiumSeats;
	}

	public int getTotalBusinessSeats() 
	{
		return totalBusinessSeats;
	}

	public void setTotalBusinessSeats(int totalBusinessSeats) 
	{
		this.totalBusinessSeats = totalBusinessSeats;
	}
}
