package com.salon.vanity.dao;



import java.util.List;



import com.salon.vanity.model.Booking;





public interface BookingDao {

  int insertBooking(Booking booking, String username, String servicetype);

  List<Booking> displayFutureBooking(String username);
  
  List<Booking> displayPastBooking(String username);

  void deleteBooking(String username, String servicetype, String date, String slot);
  
}