package com.booking.stayease.Service;

import java.util.List;

import com.booking.stayease.Entity.Hotel;

public interface HotelService {

        public List<Hotel> getAllHotels();

        public Hotel createHotel(Hotel hotel);

        public Hotel updateHotel(Long hotelId, Hotel hotelDetails);

        public void deleteHotel(Long hotelId);
    
}
