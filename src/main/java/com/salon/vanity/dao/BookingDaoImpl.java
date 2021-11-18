package com.salon.vanity.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.jdbc.core.JdbcTemplate;

import com.salon.vanity.model.Booking;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component
public class BookingDaoImpl implements BookingDao {
	
  DataSource datasource;
  JdbcTemplate jdbcTemplate;
  
  public int insertBooking(Booking booking, String username, String servicetype) {
	  System.out.println("entered bookingdaoimpl");
	  PreparedStatement prepareStatement;
		Connection conn = null;
		ResultSet resultset;
		int ans = 0;
		try {
			conn = ConnectionHandler.getConnection();
			if (conn != null) {
				try {
					Date date=new SimpleDateFormat("dd/MM/yyyy").parse(booking.getDate());
					Date currentDate = new Date();
					if(date.after(currentDate)) {
						System.out.println("Date is new");
					}
					else {
						System.out.println("Date is old");
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				prepareStatement = conn.prepareStatement("select * from bookings where date=? and slot=?");
				prepareStatement.setString(1, (String)booking.getDate() );
				prepareStatement.setString(2, (String)booking.getSlot());
//				prepareStatement.setInt(3, (Integer)booking.getMinutes());
				resultset = prepareStatement.executeQuery();
				while (resultset.next())
				{
					ans++;
				}
				if(ans==0) {
				prepareStatement = conn.prepareStatement("insert into bookings values(?,?,?,?,?,?)");
				prepareStatement.setString(1, username);
				prepareStatement.setString(2, servicetype);
				prepareStatement.setString(3, (String)booking.getName());
				prepareStatement.setString(4, (String)booking.getPhoneNumber() );
				prepareStatement.setString(5, (String)booking.getDate() );
				prepareStatement.setString(6, (String)booking.getSlot());
				

				prepareStatement.executeUpdate();
				System.out.println("Record inserted successfully...");
				}
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ans;
}
  
@Override
public List<Booking> displayFutureBooking(String username) {
	PreparedStatement prepareStatement;
	Connection conn = null;
	ResultSet resultset;
	Booking booking;
	List<Booking> BookingList = new ArrayList<Booking>();
	try {
		conn = ConnectionHandler.getConnection();
		prepareStatement = conn.prepareStatement("select * from bookings where username=?");
		prepareStatement.setString(1, username );
		resultset = prepareStatement.executeQuery();
		while (resultset.next())
		{
			String username1 = resultset.getString(1);
			String service = resultset.getString(2);
			String name = resultset.getString(3);
			String phone = resultset.getString(4);
			String date = resultset.getString(5);
			String slot = resultset.getString(6);
			Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(date);
			Date currentDate = new Date();
			System.out.println(date1+" and "+currentDate);
			if(date1.after(currentDate)) {
				booking = new Booking(username1, service, name, phone, date, slot);
				BookingList.add(booking);	
			}			
		}
}catch (SQLException se) {
	se.printStackTrace();
} catch (ParseException e) {
	e.printStackTrace();
} finally {
	try {
		conn.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
	
	return BookingList;
}

@Override
public List<Booking> displayPastBooking(String username) {
	PreparedStatement prepareStatement;
	Connection conn = null;
	ResultSet resultset;
	Booking booking;
	List<Booking> BookingList = new ArrayList<Booking>();
	try {
		conn = ConnectionHandler.getConnection();
		prepareStatement = conn.prepareStatement("select * from bookings where username=?");
		prepareStatement.setString(1, username );
		resultset = prepareStatement.executeQuery();
		while (resultset.next())
		{
			String username1 = resultset.getString(1);
			String service = resultset.getString(2);
			String name = resultset.getString(3);
			String phone = resultset.getString(4);
			String date = resultset.getString(5);
			String slot = resultset.getString(6);
			Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(date);
			Date currentDate = new Date();
			System.out.println(date1+" and "+currentDate);
			if(date1.before(currentDate)) {
				booking = new Booking(username1, service, name, phone, date, slot);
				BookingList.add(booking);	
			}			
		}
}catch (SQLException se) {
	se.printStackTrace();
} catch (ParseException e) {
	e.printStackTrace();
} finally {
	try {
		conn.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
	
	return BookingList;
}


@Override
public void deleteBooking(String username, String servicetype, String date, String slot) {
	PreparedStatement prepareStatement;
	Connection conn = null;
	try {
		conn = ConnectionHandler.getConnection();
		if (conn != null) {
			prepareStatement = conn.prepareStatement("delete from bookings where username=? and serviceType= ? and date=? and slot=?");

			prepareStatement.setString(1, username);
			prepareStatement.setString(2, servicetype);
			prepareStatement.setString(3, date);
			prepareStatement.setString(4, slot);

			prepareStatement.executeUpdate();
			System.out.println("Record deleted successfully...");
		}
	} catch (SQLException se) {
		se.printStackTrace();
	} finally {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
   
}
