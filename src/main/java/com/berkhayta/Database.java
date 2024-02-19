package com.berkhayta;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private List<Restaurant> RestaurantArrayList;
    private List<Customer> CustomerArrayList;
    private List<Reservation> ReservationArrayList;

    public Database() {
        RestaurantArrayList = new ArrayList<>();
        CustomerArrayList = new ArrayList<>();
        ReservationArrayList = new ArrayList<>();
    }

    public List<Restaurant> getRestaurantArrayList() {
        return RestaurantArrayList;
    }

    public void setRestaurantArrayList(List<Restaurant> restaurantArrayList) {
        RestaurantArrayList = restaurantArrayList;
    }

    public List<Customer> getCustomerArrayList() {
        return CustomerArrayList;
    }

    public void setCustomerArrayList(List<Customer> customerArrayList) {
        CustomerArrayList = customerArrayList;
    }

    public List<Reservation> getReservationArrayList() {
        return ReservationArrayList;
    }

    public void setReservationArrayList(List<Reservation> reservationArrayList) {
        ReservationArrayList = reservationArrayList;
    }
}