package com.infinte.vehiclehiringsystem.service;

import java.util.List;

import com.infinte.vehiclehiringsystem.bean.Booking;

public interface BookingService {
	public String insertBooking(Booking booking);

	public String deleteBooking(int bookId);

	public Booking getBooking(int bookId);

	public String updateBooking(int bookId);

	public List<Booking> getAllBooking();


}
