package com.infinte.vehiclehiringsystem.dao;

import java.util.List;

import com.infinte.vehiclehiringsystem.bean.Booking;


public interface BookingDAO {
	public String insertBooking(Booking booking);

	public String deleteBooking(int bookId);

	public Booking getBooking(int bookId);

	public String updateBooking(int bookId);

	public List<Booking> getAllBooking();

}
