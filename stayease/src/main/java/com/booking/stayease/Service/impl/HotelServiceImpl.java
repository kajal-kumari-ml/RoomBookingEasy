package com.booking.stayease.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.stayease.Entity.Hotel;
import com.booking.stayease.Repository.HotelRepository;
import com.booking.stayease.Service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {
    
    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Hotel createHotel(Hotel hotel) {
        // Set available rooms to total rooms initially
        hotel.setAvailableRooms(hotel.getAvailableRooms());
        return hotelRepository.save(hotel);
    }

    public Hotel updateHotel(Long hotelId, Hotel hotelDetails) {
        Hotel hotel = hotelRepository.findById(hotelId).get();
        hotel.setName(hotelDetails.getName());
        hotel.setLocation(hotelDetails.getLocation());
        hotel.setDescription(hotelDetails.getDescription());

        return hotelRepository.save(hotel);
    }

    public void deleteHotel(Long hotelId) {
        Hotel hotel = hotelRepository.findById(hotelId).get();
        hotelRepository.delete(hotel);
    }
}

