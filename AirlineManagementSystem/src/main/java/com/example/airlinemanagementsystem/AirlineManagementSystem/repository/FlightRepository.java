package com.example.airlinemanagementsystem.AirlineManagementSystem.repository;

import com.example.airlinemanagementsystem.AirlineManagementSystem.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
}
