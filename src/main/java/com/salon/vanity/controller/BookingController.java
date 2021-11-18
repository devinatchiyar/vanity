package com.salon.vanity.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

import org.springframework.ui.ModelMap;



import com.salon.vanity.model.Booking;

import com.salon.vanity.service.BookingService;


@Controller

public class BookingController {

	@Autowired

	BookingService bookingservice;

   @RequestMapping(value = "/book", method = RequestMethod.GET)

   public ModelAndView book(@RequestParam("service") String service, HttpServletRequest request, HttpServletResponse response) {

	 request.getSession().setAttribute("ServiceType", service); 

     ModelAndView mav = new ModelAndView("booking");

     return mav;

   }
   
   @RequestMapping(value = "/women-facial", method = RequestMethod.GET)
   
   public ModelAndView showWomenFacial(HttpServletRequest request, HttpServletResponse response) {
     ModelAndView mav = new ModelAndView("women-facial");
     return mav;
   }
   
   @RequestMapping(value = "/show-man-manipedi", method = RequestMethod.GET)
   
   public ModelAndView showManManipedi(HttpServletRequest request, HttpServletResponse response) {
     ModelAndView mav = new ModelAndView("man manipedi");
     return mav;
   }
   
   @RequestMapping(value = "/show-man-advancestyling", method = RequestMethod.GET)
   
   public ModelAndView showStyling(HttpServletRequest request, HttpServletResponse response) {
     ModelAndView mav = new ModelAndView("styling");
     return mav;
   }
   
   @RequestMapping(value = "/show-man-haircut", method = RequestMethod.GET)
   
   public ModelAndView showManHaircut(HttpServletRequest request, HttpServletResponse response) {
     ModelAndView mav = new ModelAndView("man haircut");
     return mav;
   }
   
   @RequestMapping(value = "/show-man-facial", method = RequestMethod.GET)
   
   public ModelAndView showManFacial(HttpServletRequest request, HttpServletResponse response) {
     ModelAndView mav = new ModelAndView("man facial");
     return mav;
   }
   
   @RequestMapping(value = "/show-women-haircut", method = RequestMethod.GET)
   
   public ModelAndView showWomenHaircut(HttpServletRequest request, HttpServletResponse response) {
     ModelAndView mav = new ModelAndView("haircuts");
     return mav;
   }
   
   @RequestMapping(value = "/show-women-threading", method = RequestMethod.GET)
   
   public ModelAndView showWomenThreading(HttpServletRequest request, HttpServletResponse response) {
     ModelAndView mav = new ModelAndView("threading");
     return mav;
   }
   
   @RequestMapping(value = "/show-women-manipedi", method = RequestMethod.GET)
   
   public ModelAndView showWomenManipedi(HttpServletRequest request, HttpServletResponse response) {
     ModelAndView mav = new ModelAndView("manipedi");
     return mav;
   }
   
   @RequestMapping(value = "/CompleteBooking", method = RequestMethod.POST)

   public ModelAndView processBooking(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("booking") Booking booking) {

	   String username = request.getSession().getAttribute("UserName").toString();

	   String servicetype = request.getSession().getAttribute("ServiceType").toString();

	   ModelAndView mav = null;

	   System.out.println(username+","+servicetype+","+booking);
	   
	   try {
			Date date=new SimpleDateFormat("dd/MM/yyyy").parse(booking.getDate());
			Date currentDate = new Date();
			System.out.println(date+" and "+currentDate);
			if(date.before(currentDate)) {
				mav = new ModelAndView("booking");

			    mav.addObject("message", "Select an upcoming date!!");
			    return mav;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

	   int ans = bookingservice.insertBooking(booking, username, servicetype);

		if (ans == 0) {


			   List<Booking> BookingList = bookingservice.displayFutureBooking(username);
			   List<Booking> BookingList1 = bookingservice.displayPastBooking(username);

			   mav = new ModelAndView("bookings");

			   if (BookingList == null || BookingList.size() == 0)

				{
				   mav.addObject("futuremessage", "you have no upcoming bookings");	

				}

				else {
						mav.addObject("BookingsList", BookingList);
					}
			   
			   if(BookingList1 == null || BookingList1.size() == 0) {
				   
				   mav.addObject("pastmessage", "you have no past bookings");
				   
			   }
			   else {
				   mav.addObject("BookingsList1", BookingList1);
			   }
			   
			   
		}

		else {

		    mav = new ModelAndView("booking");

		    mav.addObject("message", "The slot is booked!!");

		}

		return mav;
   }

   

   @RequestMapping(value = "/show-bookings", method = RequestMethod.GET)

   public ModelAndView showBooking(ModelMap model, HttpServletRequest request, HttpServletResponse response) {

	   String username = request.getSession().getAttribute("UserName").toString();

	   ModelAndView mav = null;

	   List<Booking> BookingList = bookingservice.displayFutureBooking(username);
	   List<Booking> BookingList1 = bookingservice.displayPastBooking(username);

	   mav = new ModelAndView("bookings");

	   if (BookingList == null || BookingList.size() == 0)

		{
		   mav.addObject("futuremessage", "you have no upcoming bookings");	

		}

		else {
				mav.addObject("BookingsList", BookingList);
			}
	   
	   if(BookingList1 == null || BookingList1.size() == 0) {
		   
		   mav.addObject("pastmessage", "you have no past bookings");
		   
	   }
	   else {
		   mav.addObject("BookingsList1", BookingList1);
	   }
	   
		return mav;

   }

   @RequestMapping(value = "/remove-booking", method = RequestMethod.GET)

	public ModelAndView removeBooking(@RequestParam("bookingService") String bookingService,@RequestParam("bookingDate") String bookingDate,@RequestParam("bookingSlot") String bookingSlot, ModelMap model, HttpServletRequest request, HttpServletResponse response) {

	   String username = request.getSession().getAttribute("UserName").toString();	

	   bookingservice.deleteBooking(username, bookingService, bookingDate, bookingSlot);

	   ModelAndView mav = null;

	   List<Booking> BookingList = bookingservice.displayFutureBooking(username);
	   List<Booking> BookingList1 = bookingservice.displayPastBooking(username);

	   mav = new ModelAndView("bookings");

	   if (BookingList == null || BookingList.size() == 0)

		{
		   mav.addObject("futuremessage", "you have no upcoming bookings");	

		}

		else {
				mav.addObject("BookingsList", BookingList);
			}
	   
	   if(BookingList1 == null || BookingList1.size() == 0) {
		   
		   mav.addObject("pastmessage", "you have no past bookings");
		   
	   }
	   else {
		   mav.addObject("BookingsList1", BookingList1);
	   }
	   

	   return mav;

	}

}