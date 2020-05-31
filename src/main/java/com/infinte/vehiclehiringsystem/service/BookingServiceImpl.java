package com.infinte.vehiclehiringsystem.service;

import java.util.List;

import com.infinte.vehiclehiringsystem.bean.Booking;
import com.infinte.vehiclehiringsystem.dao.BookingDAO;
import com.infinte.vehiclehiringsystem.dao.BookingDAOImpl;

public class BookingServiceImpl implements BookingService {
	BookingDAO bookingDAO = new BookingDAOImpl();

	public String insertBooking(Booking booking) {
		// TODO Auto-generated method stub
		return bookingDAO.insertBooking(booking);
	}

	public String deleteBooking(int bookId) {
		// TODO Auto-generated method stub
		return bookingDAO.deleteBooking(bookId);
	}

	public Booking getBooking(int bookId) {
		// TODO Auto-generated method stub
		return bookingDAO.getBooking(bookId);
	}

	public String updateBooking(int bookId) {
		// TODO Auto-generated method stub
		return bookingDAO.updateBooking(bookId);
	}

	public List<Booking> getAllBooking() {
		// TODO Auto-generated method stub
		return bookingDAO.getAllBooking();
	}

}
