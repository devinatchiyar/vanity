package com.salon.vanity.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



import com.salon.vanity.dao.BookingDao;

import com.salon.vanity.model.Booking;



@Service

public class BookingService {



	@Autowired

	  BookingDao bookingDao;

		String username, servicetype,date,slot;



	  public int insertBooking(Booking booking, String username, String servicetype) {

		System.out.println("entered service");

	    return bookingDao.insertBooking(booking,username,servicetype);

	  }

	  public List<Booking> displayFutureBooking(String username) {

		  System.out.println("entered service");

		    return bookingDao.displayFutureBooking(username);

	  }
	  
	  public List<Booking> displayPastBooking(String username) {

		  System.out.println("entered service");

		    return bookingDao.displayPastBooking(username);

	  }

	  public void deleteBooking(String username, String servicetype, String date, String slot) {

		  bookingDao.deleteBooking(username,servicetype,date,slot);

	  }

}