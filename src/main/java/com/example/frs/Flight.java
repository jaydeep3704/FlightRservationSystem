package com.example.frs;

public class Flight {
    String from,to,flightId,DepartureDate,ArrivalDate;
    int price;
    public Flight(String from, String to, String flightId, String departureDate, String arrivalDate, int price) {
        this.from = from;
        this.to = to;
        this.flightId=flightId;
        this.DepartureDate = departureDate;
        this.ArrivalDate = arrivalDate;
        this.price = price;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getDepartureDate() {
        return this.DepartureDate;
    }

    public String getArrivalDate() {
        return this.ArrivalDate;
    }

    public int getPrice() {
        return this.price;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }


    public void setDepartureDate(String departureDate) {
        DepartureDate = departureDate;
    }

    public void setArrivalDate(String arrivalDate) {
        ArrivalDate = arrivalDate;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
