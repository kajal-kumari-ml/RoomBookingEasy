package com.booking.stayease.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.stayease.Entity.Booking;
import com.booking.stayease.Service.BookingService;

@RestController
@RequestMapping("api/v1/customer")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/hotels/{hotelId}/book")
    public ResponseEntity<?> bookRoom(@RequestBody Booking booking,@PathVariable Long hotelId) {
        return new ResponseEntity<>(bookingService.bookRoom(hotelId, booking), HttpStatus.CREATED);
    }

    @DeleteMapping("/bookings/{bookingId}")
    public ResponseEntity<?> cancelBooking(@PathVariable Long bookingId) {
        bookingService.cancelBooking(bookingId);
        return new ResponseEntity<>("Booking cancelled successfully", HttpStatus.OK);
    }
    
}
