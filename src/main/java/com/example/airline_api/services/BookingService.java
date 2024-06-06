package com.example.airline_api.services;

import com.example.airline_api.models.Booking;
import com.example.airline_api.models.BookingDTO;
import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.BookingRepository;
import com.example.airline_api.repositories.FlightRepository;
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
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;


    public List<Booking> findAllBookings(){
        return bookingRepository.findAll();
    }

    public Optional<Booking> findBooking(long id){
        return bookingRepository.findById(id);
    }


    public Booking saveBooking(BookingDTO bookingDTO){
        Passenger passenger = passengerRepository.findById(bookingDTO.getPassengerId()).get();
        Flight flight = flightRepository.findById(bookingDTO.getFlightId()).get();
        int seatNumber = 0;
        Booking booking = new Booking(
                flight,
                passenger,
                seatNumber);

        bookingRepository.save(booking);
        return booking;
    }

}
