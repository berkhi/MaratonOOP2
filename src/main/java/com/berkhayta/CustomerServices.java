package com.berkhayta;

public class CustomerServices {
    static Customer guncellenecekMusteri = null;
    public static void addCustomer() {
        String name = InputUtil.getStringValue("Müşteri Adı Giriniz:");
        String lastName = InputUtil.getStringValue("Müşteri Soyadı Giriniz:");
        String phoneNumber = InputUtil.getStringValue("Müşteri Telefon no Giriniz:");
        String email = InputUtil.getStringValue("Müşteri Email Giriniz:");

        DatabaseModel.database.getCustomerArrayList().add(new Customer(name,lastName,phoneNumber,email));
    }

    public static void removeCustomer() {
        listAllCustomers();
        String phoneNumber = InputUtil.getStringValue("Silinecek Müşterinin Telefon Numarasını Girin:");
        for (Customer customer: DatabaseModel.database.getCustomerArrayList()){
            if (customer.getCustomerPhone().equals(phoneNumber)){
                DatabaseModel.database.getCustomerArrayList().remove(customer);
                System.out.println(phoneNumber+" Telefon Numaralı Müşteri Silindi!");
                break;
            }else{
                System.out.println(phoneNumber+" Telefon Numaralı Müşteri Bulunamadı!");
                return;
            }
        }
    }

    public static void searchCustomer() {
        String phoneNumber = InputUtil.getStringValue("Bulunacak Müşterinin Telefon Numarasını Girin:");
        for (Customer customer: DatabaseModel.database.getCustomerArrayList()){
            if (customer.getCustomerPhone().equals(phoneNumber)){
                System.out.println(phoneNumber+" TC No'lu Müşterinin Bilgileri:");
                System.out.println(customer.toString());
                break;
            }else{
                System.out.println(phoneNumber+" Telefon Numaralı Müşteri Bulunamadı!");
                return;
            }
        }
    }

    public static void updateCustomer() {
        listAllCustomers();
        String phoneNumber = InputUtil.getStringValue("Güncellenecek Müşterinin Telefon Numarasını Girin:");

        for(Customer customer :DatabaseModel.database.getCustomerArrayList()){
            if(customer.getCustomerPhone().equals(phoneNumber)){
                guncellenecekMusteri = customer;

                System.out.println("Güncellemek istediğiniz özelliği seçin");
                System.out.println("1-Ad");
                System.out.println("2-Soyad");
                System.out.println("3-Telefon No");
                System.out.println("4-Email");

                int secim = InputUtil.getIntegerValue("Seçiminizi Giriniz: ");
                switch (secim){
                    case 1:
                        String newName = InputUtil.getStringValue("Yeni Adı Giriniz: ");
                        guncellenecekMusteri.setCustomerName(newName);
                        break;
                    case 2:
                        String newLastName = InputUtil.getStringValue("Yeni Soyad Girin: ");
                        guncellenecekMusteri.setCustomerSurname(newLastName);
                        break;
                    case 3:
                        String newPhoneNumber = InputUtil.getStringValue("Yeni Telefon Numarası Girin: ");
                        guncellenecekMusteri.setCustomerPhone(newPhoneNumber);
                        break;
                    case 4:
                        String newEmail = InputUtil.getStringValue("Yeni Email Girin: ");
                        guncellenecekMusteri.setCustomerMail(newEmail);
                        break;
                }
            }
        }
        if (guncellenecekMusteri == null){
            System.out.println(phoneNumber+" Telefon Numaralı Müşteri Bulunamadı!");
        }
    }

    public static void listAllCustomers() {
        DatabaseModel.database.getCustomerArrayList().forEach(musteri -> System.out.println(musteri.toString()));
    }
}
