 package com.flightPackage;

import java.sql.Date;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Flight 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message="Departure Location name cannot be null")
	@Column(name="DepartureLocation")
	private String departureLocation;
	
	@NotNull(message="Arrival Location name cannot be null")
	@Column(name="ArrivalLocation")
	private String arrivalLocation;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fleet_id")
	private Fleet fleet;
	
	@OneToOne(cascade=CascadeType.ALL)
	private FlightStatus status;
	
	@NotNull
	@Column(name="DepartureTime")
	private Date departureTime;
	
	@NotNull
	@Column(name="ArrivalTime")
	private Date arrivalTime;
	
	public Flight() {}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getDepartureLocation() 
	{
		return departureLocation;
	}

	public void setDepartureLocation(String departureLocation) 
	{
		this.departureLocation = departureLocation;
	}

	public String getArrivalLocation() 
	{
		return arrivalLocation;
	}

	public void setArrivalLocation(String arrivalLocation) 
	{
		this.arrivalLocation = arrivalLocation;
	}

	public Fleet getFleet() 
	{
		return fleet;
	}

	public void setFleet(Fleet fleet) 
	{
		this.fleet = fleet;
	}

	public FlightStatus getStatus() 
	{
		return status;
	}

	public void setStatus(FlightStatus status) 
	{
		this.status = status;
	}

	public Date getDepartureTime() 
	{
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) 
	{
		this.departureTime = departureTime;
	}

	public Date getArrivalTime() 
	{
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) 
	{
		this.arrivalTime = arrivalTime;
	}
}
