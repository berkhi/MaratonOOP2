package com.berkhayta;

public class RestaurantServices {
    public static void addRestaurant() {
        String name = InputUtil.getStringValue("Restoran Adı Giriniz:");
        String address = InputUtil.getStringValue("Restoran Adresi Giriniz:");
        String phoneNumber = InputUtil.getStringValue("Restoran Telefon no Giriniz:");
        int capacity = InputUtil.getIntegerValue("Restoran Misafir Kapasitesi Giriniz:");
        Status status = restaurantStatus();

        DatabaseModel.database.getRestaurantArrayList().add(new Restaurant(name,address,phoneNumber,capacity,status));
    }
    private static Status restaurantStatus() {
        System.out.println("Restoran Durumunu Seçiniz:");
        System.out.println("1-AÇIK");
        System.out.println("2-KAPALI");
        int statusChoice = InputUtil.getIntegerValue("Seçiminizi yapınız:");
        switch (statusChoice) {
            case 1:
                return Status.OPEN;
            case 2:
                return Status.CLOSED;
            default:
                throw new IllegalArgumentException("Geçersiz seçim: " + statusChoice);
        }
    }

    public static void removeRestaurant() {
        listAllRestaurants();
        String restaurantID = InputUtil.getStringValue("Silinecek Restoranın ID sini Girin:");
        for (Restaurant restaurant: DatabaseModel.database.getRestaurantArrayList()){
            if (restaurant.getRestaurantID().equals(restaurantID)){
                DatabaseModel.database.getRestaurantArrayList().remove(restaurant);
                System.out.println(restaurantID+" ID li Restoran Silindi!");
                break;
            }else{
                System.out.println(restaurantID+" ID li Restoran Bulunamadı!");
                return;
            }
        }
    }

    public static void searchRestaurant() {
        String restaurantName = InputUtil.getStringValue("Bulunacak Restoranın Adını Girin:");
        for (Restaurant restaurant: DatabaseModel.database.getRestaurantArrayList()){
            if (restaurant.getRestaurantName().equals(restaurantName)){
                System.out.println(restaurantName+" İsimli Restoran Bilgileri:");
                System.out.println(restaurantName.toString());
                break;
            }else{
                System.out.println(restaurantName+" İsimli Restoran BULUNAMADI!");
                return;
            }
        }
    }

    public static void updateRestaurant() {
        listAllRestaurants();
        String restaurantID = InputUtil.getStringValue("Güncellenecek Restoranın ID sini Girin:");
        Restaurant guncellenecekRestoran = null;
        for(Restaurant restaurant :DatabaseModel.database.getRestaurantArrayList()){
            if(restaurant.getRestaurantID().equals(restaurantID)){
                guncellenecekRestoran = restaurant;

                System.out.println("Güncellemek istediğiniz özelliği seçin");
                System.out.println("1-Ad");
                System.out.println("2-Adres");
                System.out.println("3-Telefon No");
                System.out.println("4-Kapasite");
                System.out.println("5-Durumu(Açık/Kapalı)");

                int secim = InputUtil.getIntegerValue("Seçiminizi Giriniz: ");
                switch (secim){
                    case 1:
                        String newName = InputUtil.getStringValue("Yeni Adı Giriniz: ");
                        guncellenecekRestoran.setRestaurantName(newName);
                        break;
                    case 2:
                        String newAddress = InputUtil.getStringValue("Yeni Adresi Girin: ");
                        guncellenecekRestoran.setRestaurantAdress(newAddress);
                        break;
                    case 3:
                        String newPhoneNumber = InputUtil.getStringValue("Yeni Telefon Numarası Girin: ");
                        guncellenecekRestoran.setRestaurantPhone(newPhoneNumber);
                        break;
                    case 4:
                        int newCapacity = InputUtil.getIntegerValue("Yeni Kapasite Girin: ");
                        guncellenecekRestoran.setRestaurantCapacity(newCapacity);
                        break;
                    case 5:
                        guncellenecekRestoran.setRestaurantStatus(restaurantStatus());
                        break;
                }
            }
        }
        if (guncellenecekRestoran == null){
            System.out.println(restaurantID+" ID li Restoran Bulunamadı!");
        }
    }

    public static void listAllRestaurants() {
        DatabaseModel.database.getRestaurantArrayList().forEach(restaurant -> System.out.println(restaurant.toString()));
    }
}
