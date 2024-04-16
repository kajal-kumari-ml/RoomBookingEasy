package com.booking.stayease.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.stayease.Entity.Hotel;

@Repository
public interface HotelRepository  extends JpaRepository<Hotel, Long>{
    
}
