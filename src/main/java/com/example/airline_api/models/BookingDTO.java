package com.example.airline_api.models;

public class BookingDTO {
// DTO is a POJO class
    private long passengerId;
    private long flightId;


    public BookingDTO(long passengerId, long flightId) {
        this.passengerId = passengerId;
        this.flightId = flightId;
    }

    public BookingDTO(){

    }

    public long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(long passengerId) {
        this.passengerId = passengerId;
    }

    public long getFlightId() {
        return flightId;
    }

    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }

}
