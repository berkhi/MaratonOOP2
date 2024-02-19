package com.berkhayta;

import java.time.LocalDateTime;
import java.util.UUID;

public class Reservation {
    private String reservationID;
    private String customerID;
    private String restaurantID;
    private LocalDateTime reservationDate;
    private int numberOfPeople;

    public Reservation(String customerID, String restaurantID, LocalDateTime reservationDate, int numberOfPeople) {
        this.reservationID = UUID.randomUUID().toString();
        this.customerID = customerID;
        this.restaurantID = restaurantID;
        this.reservationDate = reservationDate;
        this.numberOfPeople = numberOfPeople;
    }

    public String getReservationID() {
        return reservationID;
    }

    public void setReservationID(String reservationID) {
        this.reservationID = reservationID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(String  restaurantID) {
        this.restaurantID = restaurantID;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationID='" + reservationID + '\'' +
                ", customerID=" + customerID +
                ", restaurantID=" + restaurantID +
                ", reservationDate=" + reservationDate +
                ", numberOfPeople=" + numberOfPeople +
                '}';
    }
}
