package com.booking.stayease.Service;

import com.booking.stayease.Entity.Booking;

public interface BookingService {

        public Booking bookRoom(Long hotelId, Booking booking);
        public void cancelBooking(Long bookingId) ;
    
}
