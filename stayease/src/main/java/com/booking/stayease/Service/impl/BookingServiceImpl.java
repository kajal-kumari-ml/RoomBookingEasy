package com.booking.stayease.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.stayease.Entity.Booking;
import com.booking.stayease.Entity.Hotel;
import com.booking.stayease.Repository.BookingRepository;
import com.booking.stayease.Repository.HotelRepository;
import com.booking.stayease.Service.BookingService;
import com.booking.stayease.exception.UsernameNotFoundException;

@Service
public class BookingServiceImpl implements BookingService {
    
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private HotelRepository hotelRepository;

    public Booking bookRoom(Long hotelId, Booking booking) {
        // Decrease available rooms count
        try{
        Hotel hotel = hotelRepository.findById(hotelId).get();

        int availableRooms = hotel.getAvailableRooms();
        if (availableRooms > 0) {
            hotel.setAvailableRooms(availableRooms - 1);
            Booking newBooking = new Booking();
            newBooking.setHotel(booking.getHotel());
            hotelRepository.save(hotel);
            newBooking.setUser(booking.getUser());
            bookingRepository.save(newBooking);
            return newBooking;
                } else {
            throw new UsernameNotFoundException("No available rooms in the hotel");
        }
    } catch(Exception e){
        throw new UsernameNotFoundException("Hotel not found");
    }

    }

    public void cancelBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId).get();

        // Increase available rooms count
        Hotel hotel = booking.getHotel();
        hotel.setAvailableRooms(hotel.getAvailableRooms() + 1);
        hotelRepository.save(hotel);

        bookingRepository.delete(booking);
    }
}

