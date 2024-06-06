package com.example.airline_api.controllers;

import com.example.airline_api.models.Booking;
import com.example.airline_api.models.BookingDTO;
import com.example.airline_api.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    BookingService bookingService;

    // Display all bookings
    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings(){
        return new ResponseEntity<>(bookingService.findAllBookings(), HttpStatus.OK);
    }

    // Add details of a new booking
    @PostMapping // postmapping should not take in an id
    public ResponseEntity<Booking> addNewBooking(@RequestBody BookingDTO bookingDTO){
           Booking booking = bookingService.saveBooking(bookingDTO);
            return new ResponseEntity<>(booking, HttpStatus.CREATED);
        }

    // Extension - Update passenger meal preference
    @PatchMapping(value = "/{id}")
    public ResponseEntity<Booking> updateMealPreference(@RequestBody BookingDTO bookingDTO, @PathVariable long id){
        Booking updatedMealPreference = bookingService.updateMealPreference(bookingDTO, id);
        return new ResponseEntity<>(updatedMealPreference, HttpStatus.OK);
    }

}
