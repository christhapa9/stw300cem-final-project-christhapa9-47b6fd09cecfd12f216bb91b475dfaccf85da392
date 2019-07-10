package com.example.bookyourvenue;

public class Venue {
    private static String venueId;
    String venuename, address, venueimage, details;

    public Venue(String venuename, String address, String venueimage, String details) {
        this.venuename = venuename;
        this.address = address;
        this.venueimage = venueimage;
        this.details = details;
    }
//
//    public Venue(String venueId, String venuename, String address, String venueimage, String details) {
//        this.venueId = venueId;
//        this.venuename = venuename;
//        this.address = address;
//        this.venueimage = venueimage;
//        this.details = details;
//    }

//    public static String getVenueId() {
//        return venueId;
//    }
//
//    public void setVenueId(String venueId) {
//        this.venueId = venueId;
//    }

    public String getVenuename() {
        return venuename;
    }

    public void setVenuename(String venuename) {
        this.venuename = venuename;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getVenueimage() {
        return venueimage;
    }

    public void setVenueimage(String venueimage) {
        this.venueimage = venueimage;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
