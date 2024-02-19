package com.berkhayta;


import java.time.LocalDateTime;

public class Runner {
    public static void main(String[] args) {
        mockData();
        mainMenu();
    }

    private static void mainMenu() {
        do {
            System.out.println("1-MÜŞTERİ YÖNET");
            System.out.println("2-RESTORAN YÖNET");
            System.out.println("3-REZERVASYON YÖNET");
            System.out.println("0-CIKIS YAP");

            int secim = InputUtil.getIntegerValue("Seçiminizi Giriniz.");
            switch (secim) {
                case 1:
                    customerServices();
                    break;
                case 2:
                    restaurantServices();
                    break;
                case 3:
                    reservationServices();
                case 0:
                    System.exit(0);
                    break;
            }
        } while (true);
    }

    private static void customerServices() {
        do {
            System.out.println("1- MÜŞTERİ EKLE");
            System.out.println("2- MÜŞTERİ SİL");
            System.out.println("3- MÜŞTERİ BUL");
            System.out.println("4- MÜŞTERİ GÜNCELLE");
            System.out.println("5- MÜŞTERİLERİ LİSTELE");
            System.out.println("0- ANA MENU");

            int secim = InputUtil.getIntegerValue("Seçiminizi Giriniz.");
            switch (secim) {
                case 1:
                    CustomerServices.addCustomer();
                    break;
                case 2:
                    CustomerServices.removeCustomer();
                    break;
                case 3:
                    CustomerServices.searchCustomer();
                    break;
                case 4:
                    CustomerServices.updateCustomer();
                    break;
                case 5:
                    CustomerServices.listAllCustomers();
                    break;
                case 0:
                    mainMenu();
                    break;
            }
        } while (true);
    }

    private static void restaurantServices() {
        do {
            System.out.println("1- RESTORAN EKLE");
            System.out.println("2- RESTORAN SİL");
            System.out.println("3- RESTORAN BUL");
            System.out.println("4- RESTORAN GÜNCELLE");
            System.out.println("5- RESTORANLARI LİSTELE");
            System.out.println("0- ANA MENU");

            int secim = InputUtil.getIntegerValue("Seçiminizi Giriniz.");
            switch (secim) {
                case 1:
                    RestaurantServices.addRestaurant();
                    break;
                case 2:
                    RestaurantServices.removeRestaurant();
                    break;
                case 3:
                    RestaurantServices.searchRestaurant();
                    break;
                case 4:
                    RestaurantServices.updateRestaurant();
                    break;
                case 5:
                    RestaurantServices.listAllRestaurants();
                    break;
                case 0:
                    mainMenu();
                    break;
            }
        } while (true);
    }

    private static void reservationServices() {
        do {
            System.out.println("1- REZERVASYON EKLE");
            System.out.println("2- REZERVASYON SİL");
            System.out.println("3- REZERVASYON BUL");
            System.out.println("4- REZERVASYON GÜNCELLE");
            System.out.println("5- REZERVASYONLARI LİSTELE");
            System.out.println("0- ANA MENU");

            int secim = InputUtil.getIntegerValue("Seçiminizi Giriniz.");
            switch (secim) {
                case 1:
                    ReservationServices.addReservation();
                    break;
                case 2:
                    ReservationServices.removeReservation();
                    break;
                case 3:
                    ReservationServices.searchReservation();
                    break;
                case 4:
                    ReservationServices.updateReservation();
                    break;
                case 5:
                    ReservationServices.listAllReservations();
                    break;
                case 0:
                    mainMenu();
                    break;
            }
        } while (true);
    }
    private static void mockData() {
        DatabaseModel.database.getCustomerArrayList().add(new Customer("Ali", "Yilmaz", "55500504004", "ali@gmail.com"));
        DatabaseModel.database.getCustomerArrayList().add(new Customer("Ece", "Yilmaz", "55500504005", "ece@gmail.com"));
        DatabaseModel.database.getCustomerArrayList().add(new Customer("Ada", "Yilmaz", "55500504006", "ada@gmail.com"));

        DatabaseModel.database.getRestaurantArrayList().add(new Restaurant("Cipriani", "Levent Mah. Büyükdere Cad. No.2 Levent / Beşiktaş", "0555060404", 15, Status.OPEN));
        DatabaseModel.database.getRestaurantArrayList().add(new Restaurant("Kydonia", "Kuruçeşme Mh. Muallim Naci Caddesi No:107 Beşiktaş", "0555060405", 12, Status.OPEN));
        DatabaseModel.database.getRestaurantArrayList().add(new Restaurant("La torre", "Cengiz Topel Caddesi 39, Etiler, Beşiktaş", "0555060406", 10, Status.OPEN));

        System.out.println(DatabaseModel.database.getCustomerArrayList());
        System.out.println(DatabaseModel.database.getRestaurantArrayList());

        DatabaseModel.database.getReservationArrayList().add(new Reservation(DatabaseModel.database.getCustomerArrayList().getFirst().getCustomerID(), DatabaseModel.database.getRestaurantArrayList().get(0).getRestaurantID(), LocalDateTime.now(), 12));

        System.out.println(DatabaseModel.database.getReservationArrayList());
    }
}
