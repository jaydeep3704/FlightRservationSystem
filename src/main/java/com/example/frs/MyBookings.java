package com.example.frs;

public class MyBookings {
    private String flightId,from,to,passengerName,departureDate,time;
    private int bookingid;

    public MyBookings(int bookingid, String flightId, String from, String to, String passengerName, String departureDate, String time) {
        this.bookingid = bookingid;
        this.flightId = flightId;
        this.from = from;
        this.to = to;
        this.passengerName = passengerName;
        this.departureDate = departureDate;
        this.time=time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getBookingId() {
        return bookingid;
    }

    public void setBookingId(int bookingId) {
        this.bookingid = bookingId;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }
}