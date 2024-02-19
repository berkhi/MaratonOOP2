package com.berkhayta;

import java.time.LocalDateTime;

import static com.berkhayta.CustomerServices.listAllCustomers;
import static com.berkhayta.RestaurantServices.listAllRestaurants;

public class ReservationServices {
    public static void addReservation() {
        listAllCustomers();
        Customer isCustomerExist = null;
        String customerID = InputUtil.getStringValue("Rezervasyon Yapmak İstediğiniz Müşterinin customerID sini Girin:");
        for (Customer customer : DatabaseModel.database.getCustomerArrayList()) {
            if (customer.getCustomerID().equals(customerID)) { //Kullanıcıdan aldığımız veriyi database de olup olmadığı kontrolünü yapıyoruz.
                isCustomerExist = customer;
                break;
            } else {
                System.out.println(customerID + " ID'li Müşteri Bulunamadı!");
                return;
            }
        }
        listAllRestaurants();
        Restaurant isRestaurantExist = null;
        String restaurantID = InputUtil.getStringValue("Rezervasyon Yapmak İstediğiniz Restoran restaurantID sini Girin:");
        for (Restaurant restaurant : DatabaseModel.database.getRestaurantArrayList()) {
            if (restaurant.getRestaurantID().equals(restaurantID)) {
                isRestaurantExist = restaurant;
                break;
            } else {
                System.out.println(restaurantID + " ID'li Restoran Bulunamadı!");
                return;
            }
        }
        System.out.println("Rezervasyon Tarihini Giriniz");
        int year = LocalDateTime.now().getYear();
        int dayOfMonth = InputUtil.getIntegerValue("Günü giriniz:");
        int month = InputUtil.getIntegerValue("Ayı giriniz:");
        int hour = InputUtil.getIntegerValue("Saatı giriniz:");
        int minute = InputUtil.getIntegerValue("Dakikayı giriniz:");

        int numberOfPeople = InputUtil.getIntegerValue("Misafir Sayisi Giriniz");

        //Restoran kapasitesini ve o restoranda o anki müşterileri sayisi
        int totalCustomersOfRestaurant = totalCustomersOfRestaurant(restaurantID);
        int restaurantCapacity = restaurantCapacity(restaurantID);
        //Restoranda yer kalıp kalmadığı kontrol ediliyor
        if ((totalCustomersOfRestaurant + numberOfPeople) <= restaurantCapacity) {
            DatabaseModel.database.getReservationArrayList().add(new Reservation(isCustomerExist.getCustomerID(), isRestaurantExist.getRestaurantID(), LocalDateTime.of(year, month, dayOfMonth, hour, minute), numberOfPeople));
            System.out.println("Rezervasyon başarılı bir şekilde oluşturuldu!");
        }else {
            int maxCustomerCapacity = restaurantCapacity - totalCustomersOfRestaurant;
            System.out.println("Rezervasyon oluşturulamadı en fazla "+maxCustomerCapacity+" misafirlik yer kalmıştır!");
        }
    }

    public static void removeReservation() {
        listAllReservations();
        String reservationID = InputUtil.getStringValue("Silinecek Rezervasyon ID sini Girin:");
        for (Reservation reservation : DatabaseModel.database.getReservationArrayList()) {
            if (reservation.getReservationID().equals(reservationID)) {
                DatabaseModel.database.getReservationArrayList().remove(reservation);
                System.out.println(reservationID + " ID li Rezervasyon Silindi!");
                break;
            } else {
                System.out.println(reservationID + " ID li Rezervasyon Bulunamadı!");
                return;
            }
        }
    }

    public static void searchReservation() {
        String reservationID = InputUtil.getStringValue("Bulunacak Rezervasyon ID Girin:");
        for (Reservation reservation : DatabaseModel.database.getReservationArrayList()) {
            if (reservation.getReservationID().equals(reservationID)) {
                System.out.println(reservationID + " ID'li Rezervasyon Bilgileri:");
                System.out.println(reservationID.toString());
                break;
            } else {
                System.out.println(reservationID + " ID'li Rezervasyon BULUNAMADI!");
                return;
            }
        }
    }

    public static void updateReservation() {
        listAllReservations();
        String reservationID = InputUtil.getStringValue("Güncellenecek Rezervasyon ID sini Girin:");
        Reservation guncellenecekReservation = null;
        for (Reservation reservation : DatabaseModel.database.getReservationArrayList()) {
            if (reservation.getReservationID().equals(reservationID)) {
                guncellenecekReservation = reservation;

                System.out.println("Güncellemek istediğiniz özelliği seçin");
                System.out.println("1-Müşteri ID");
                System.out.println("2-Restoran ID");
                System.out.println("3-Rezervasyon Tarihi");
                System.out.println("4-Kişi Sayısı");

                int secim = InputUtil.getIntegerValue("Seçiminizi Giriniz: ");
                switch (secim) {
                    case 1:
                        String newCustomerID = InputUtil.getStringValue("Yeni Müşteri ID Giriniz: ");
                        guncellenecekReservation.setCustomerID(newCustomerID);
                        break;
                    case 2:
                        String newRestaurantID = InputUtil.getStringValue("Yeni Restoran ID Girin: ");
                        guncellenecekReservation.setRestaurantID(newRestaurantID);
                        break;
                    case 3:
                        System.out.println("Yeni Rezervasyon Tarihi Girin: ");
                        int year = LocalDateTime.now().getYear();
                        int dayOfMonth = InputUtil.getIntegerValue("Günü giriniz:");
                        int month = InputUtil.getIntegerValue("Ayı giriniz:");
                        int hour = InputUtil.getIntegerValue("Saati giriniz:");
                        int minute = InputUtil.getIntegerValue("Dakikayı giriniz:");
                        LocalDateTime newReservationDate = LocalDateTime.of(year, month, dayOfMonth, hour, minute);
                        guncellenecekReservation.setReservationDate(newReservationDate);
                        break;
                    case 4:
                        int newNuberOfPeople = InputUtil.getIntegerValue("Yeni Kişi Sayisi Girin: ");
                        guncellenecekReservation.setNumberOfPeople(newNuberOfPeople);
                        break;
                    default:
                        throw new IllegalStateException("Geçersiz seçim: " + secim);
                }
            }
        }
        if (guncellenecekReservation == null) {
            System.out.println(reservationID + " ID li Rezervasyon Bulunamadı!");
        }
    }

    public static void listAllReservations() {
        DatabaseModel.database.getReservationArrayList().forEach(reservation -> System.out.println(reservation.toString()));
    }

    public static int totalCustomersOfRestaurant(String restaurantID){
        //O restoranda kaç misafir olduğunu buluyoruz
        int totalCustomersOfRestaurant = 0;
        for (Reservation reservation : DatabaseModel.database.getReservationArrayList()) {
            if (reservation.getRestaurantID().equals(restaurantID)) {
                totalCustomersOfRestaurant += reservation.getNumberOfPeople();
            }
        }
        return totalCustomersOfRestaurant;
    }

    public static int restaurantCapacity(String restaurantID){
        //O restoranın kapasitesini öğreniyoruz
        int restaurantCapacity = 0;
        for (Restaurant restaurant : DatabaseModel.database.getRestaurantArrayList()) {
            if (restaurant.getRestaurantID().equals(restaurantID)) {
                restaurantCapacity = restaurant.getRestaurantCapacity();
                break;
            }
        }
        return restaurantCapacity;
    }
}
