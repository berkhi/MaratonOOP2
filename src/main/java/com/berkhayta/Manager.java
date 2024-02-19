package com.berkhayta;

public class Manager {
    private String managerID;
    private String managerName;
    private String managerSurname;

    public Manager(String managerID, String managerName, String managerSurname) {
        this.managerID = managerID;
        this.managerName = managerName;
        this.managerSurname = managerSurname;
    }

    public String getManagerID() {
        return managerID;
    }

    public void setManagerID(String managerID) {
        this.managerID = managerID;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerSurname() {
        return managerSurname;
    }

    public void setManagerSurname(String managerSurname) {
        this.managerSurname = managerSurname;
    }
}
