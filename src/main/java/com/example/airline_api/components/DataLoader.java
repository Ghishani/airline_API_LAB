package com.example.airline_api.components;

import com.example.airline_api.models.Booking;
import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.BookingRepository;
import com.example.airline_api.services.BookingService;
import com.example.airline_api.services.FlightService;
import com.example.airline_api.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    PassengerService passengerService;

    @Autowired
    FlightService flightService;

    @Autowired
    BookingRepository bookingRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Flight dubai = new Flight("Dubai", 100, "03-12-2024", "12:00");
        flightService.saveFlight(dubai);

        Passenger ghish = new Passenger("Ghish", "ghish@hotmail.com");
        passengerService.savePassenger(ghish);

        Booking booking1 = new Booking(dubai, ghish, 25);
        bookingRepository.save(booking1);
}

}
