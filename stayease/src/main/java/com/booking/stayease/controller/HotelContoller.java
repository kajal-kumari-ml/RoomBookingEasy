package com.booking.stayease.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.stayease.Entity.Hotel;
import com.booking.stayease.Service.HotelService;

@RestController
@RequestMapping("/api/v1/hotel_manager/")
public class HotelContoller {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/hotels")
    public ResponseEntity<?> bookHotel(@RequestBody Hotel hotel)
    {
        return new ResponseEntity<>(hotelService.createHotel(hotel), HttpStatus.CREATED);
    }

    @GetMapping("/hotel")
    public ResponseEntity<?> getAllHotels()
    {
        return new ResponseEntity<>(hotelService.getAllHotels(), HttpStatus.OK);
    }

   @DeleteMapping("/hotel/{hotelId}")
    public ResponseEntity<?> deleteHotel(@PathVariable Long hotelId)
    {
        hotelService.deleteHotel(hotelId);
        return new ResponseEntity<>("Hotel deleted successfully", HttpStatus.OK);
    }

    
    
}
