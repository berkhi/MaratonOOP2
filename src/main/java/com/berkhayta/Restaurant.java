package com.berkhayta;

import java.util.UUID;

public class Restaurant {
    private String restaurantID;
    private String restaurantName;
    private String restaurantAdress;
    private String restaurantPhone;
    private int restaurantCapacity;
    private Status restaurantStatus;

    public Restaurant(String restaurantName, String restaurantAdress, String restaurantPhone, int restaurantCapacity, Status restaurantStatus) {
        this.restaurantID = UUID.randomUUID().toString();
        this.restaurantName = restaurantName;
        this.restaurantAdress = restaurantAdress;
        this.restaurantPhone = restaurantPhone;
        this.restaurantCapacity = restaurantCapacity;
        this.restaurantStatus = restaurantStatus;
    }

    public String getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(String restaurantID) {
        this.restaurantID = restaurantID;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantAdress() {
        return restaurantAdress;
    }

    public void setRestaurantAdress(String restaurantAdress) {
        this.restaurantAdress = restaurantAdress;
    }

    public String getRestaurantPhone() {
        return restaurantPhone;
    }

    public void setRestaurantPhone(String restaurantPhone) {
        this.restaurantPhone = restaurantPhone;
    }

    public int getRestaurantCapacity() {
        return restaurantCapacity;
    }

    public void setRestaurantCapacity(int restaurantCapacity) {
        this.restaurantCapacity = restaurantCapacity;
    }

    public Status getRestaurantStatus() {
        return restaurantStatus;
    }

    public void setRestaurantStatus(Status restaurantStatus) {
        this.restaurantStatus = restaurantStatus;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantID='" + restaurantID + '\'' +
                ", restaurantName='" + restaurantName + '\'' +
                ", restaurantAdress='" + restaurantAdress + '\'' +
                ", restaurantPhone='" + restaurantPhone + '\'' +
                ", restaurantCapacity='" + restaurantCapacity + '\'' +
                ", restaurantStatus=" + restaurantStatus +
                '}';
    }
}
