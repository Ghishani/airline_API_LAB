package com.example.airline_api.services;

import com.example.airline_api.models.Booking;
import com.example.airline_api.models.BookingDTO;
import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.BookingRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    PassengerService passengerService;

    @Autowired
    FlightService flightService;


    public List<Booking> findAllBookings(){
        return bookingRepository.findAll();
    }

    public Optional<Booking> findBooking(long id){
        return bookingRepository.findById(id);
    }

    public Booking saveBooking(BookingDTO bookingDTO){
        Passenger passenger = passengerService.findSinglePassenger(bookingDTO.getPassengerId()).get();
        Flight flight = flightService.findSingleFlight(bookingDTO.getFlightId()).get();
        Booking booking = new Booking(
                flight,
                passenger,
                bookingDTO.getSeatNumber()
        );

        bookingRepository.save(booking);
        return booking;
    }

}
