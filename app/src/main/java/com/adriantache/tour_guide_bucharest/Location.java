package com.adriantache.tour_guide_bucharest;

/**
 * Class for storing details for each location in the app
 */

public class Location {

    private String type;
    private int photoResID;
    private String name;
    private String address;
    private int phone;


    public Location(String type, int photoResID, String name, String address, int phone) {
        this.type = type;
        this.photoResID = photoResID;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public int getPhotoResID() {
        return photoResID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getPhone() {
        return phone;
    }
}
