package com.example.airline_api.services;

import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

    // no need for empty controller as it is not used in the database but is needed in DTO

    public Passenger savePassenger(Passenger passenger){
        return passengerRepository.save(passenger);}

    public List<Passenger> getAllPassengers(){
        return passengerRepository.findAll();
    }

    public Passenger findPassengerById(Long id){
        return passengerRepository.findById(id).get();// use .get() to get out of creating optional
    }
}
