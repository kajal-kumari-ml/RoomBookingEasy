package com.booking.stayease.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.stayease.Entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>{
    
}
