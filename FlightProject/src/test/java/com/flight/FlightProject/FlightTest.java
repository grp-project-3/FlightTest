package com.flight.FlightProject;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dao.FlightService;
import com.flightPackage.Fleet;
import com.flightPackage.Flight;
import com.flightPackage.FlightStatus;

import junit.framework.Assert;

@SpringBootTest
class FlightTest 
{
	@Autowired
	FlightService service;
	
	@Test
	void testAdd() 
	{
		Flight flight = new Flight();
		
		Fleet fleet = new Fleet();
		fleet.setCode("23654");
		fleet.setModel("Dracula");
		
		FlightStatus flightStatus = new FlightStatus();
		
		String str="2022-03-30";
		String str1="2022-04-02";
		Date date = Date.valueOf(str);
		Date date1=Date.valueOf(str1);
		flight.setDepartureLocation("Mumbai");
		flight.setDepartureTime(date);
		flight.setArrivalTime(date1);
		flight.setArrivalLocation("London");
		
		flight.setFleet(fleet);
		flight.setStatus(flightStatus);
		service.add(flight);
		
		Flight flight1=service.find(flight.getId());
		Assert.assertEquals(flight1.getDepartureLocation(),"Mumbai");
	}

	@Test
	void testFind() 
	{
		Flight flight= new Flight();
		flight.setDepartureLocation("London");
		try
		{
			service.add(flight);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		Flight flight1 = service.find(flight.getId());
		Assert.assertNull(flight1);
	}

	@Test
	void testFindAll() 
	{
		Flight flight = new Flight();
		Fleet fleet = new Fleet();
		fleet.setCode("ABVG32");
		fleet.setModel("Monster");
		FlightStatus flightStatus = new FlightStatus();
		flight.setDepartureLocation("Dubai");
		String str="2023-08-30";
		String str1="2023-09-02";
		Date date = Date.valueOf(str);
		Date date1=Date.valueOf(str1);
		flight.setDepartureTime(date);
		flight.setArrivalTime(date1);
		flight.setArrivalLocation("London");
		flight.setFleet(fleet);
		flight.setStatus(flightStatus);
		service.add(flight);
		
		Flight flight1 = new Flight();
		Fleet fleet1 = new Fleet();
		fleet1.setCode("6598V");
		fleet1.setModel("Vampire");
		FlightStatus flightStatus1 = new FlightStatus();
		flight1.setDepartureLocation("Chennai");
		String str2="2021-06-10";
		String str3="2021-06-12";
		Date date2 = Date.valueOf(str2);
		Date date3=Date.valueOf(str3);
		flight1.setDepartureTime(date2);
		flight1.setArrivalTime(date3);
		flight1.setArrivalLocation("UK");
		flight1.setFleet(fleet1);
		flight1.setStatus(flightStatus1);
		service.add(flight1);
		
		Flight flight2 = new Flight();
		Fleet fleet2 = new Fleet();
		fleet2.setCode("354680");
		fleet2.setModel("Captain");
		FlightStatus flightStatus2 = new FlightStatus();
		flight2.setDepartureLocation("Kolkata");
		String str4="2022-03-11";
		String str5="2022-03-11";
		Date date4 = Date.valueOf(str4);
		Date date5=Date.valueOf(str5);
		flight2.setDepartureTime(date4);
		flight2.setArrivalTime(date5);
		flight2.setArrivalLocation("Madhurai");
		flight2.setFleet(fleet2);
		flight2.setStatus(flightStatus2);
		service.add(flight2);
		
		List<Flight> flightlist = service.findAll();
		Assert.assertEquals(flightlist.get(0).getDepartureLocation(),"Mumbai");
	}

	@Test
	void testUpdate() 
	{
		Flight flight = new Flight();
		Flight flight1 = service.find(1);
		Fleet fleet = new Fleet();
		fleet.setCode("23465");
		fleet.setModel("Hulk Buster");
		FlightStatus flightStatus = new FlightStatus();
		flight1.setDepartureLocation("Australia");
		String str="2023-08-30";
		String str1="2023-09-02";
		Date date = Date.valueOf(str);
		Date date1=Date.valueOf(str1);
		flight1.setDepartureTime(date);
		flight1.setArrivalTime(date1);
		flight1.setArrivalLocation("Srilanka");
		flight1.setFleet(fleet);
		flight1.setStatus(flightStatus);
		
		service.update(flight1);
		
		Flight flight_to_be_tested = service.find(1);
		
		Assert.assertEquals("Australia",flight_to_be_tested.getDepartureLocation());
	}

	@Test
	void testDelete() 
	{
		service.delete(2);
		
		Flight flight_to_be_tested = service.find(2);
		Assert.assertNull(flight_to_be_tested);
	}

}
