package com.example.airlinemanagementsystem.AirlineManagementSystem.controller;

import com.example.airlinemanagementsystem.AirlineManagementSystem.model.Flight;
import com.example.airlinemanagementsystem.AirlineManagementSystem.model.Ticket;
import com.example.airlinemanagementsystem.AirlineManagementSystem.repository.FlightRepository;
import com.example.airlinemanagementsystem.AirlineManagementSystem.repository.TicketRepository;
import com.example.airlinemanagementsystem.AirlineManagementSystem.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private FlightRepository flightRepository;

    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/{id}")
    public Ticket getTicketById(@PathVariable Long id) {
        return ticketService.getTicketById(id);
    }

    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket) {
        Flight flight = flightRepository.findById(ticket.getFlight().getId())
                .orElseThrow(() -> new RuntimeException("Flight not found"));
        ticket.setFlight(flight);
        return ticketRepository.save(ticket);
    }

    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
    }
}
