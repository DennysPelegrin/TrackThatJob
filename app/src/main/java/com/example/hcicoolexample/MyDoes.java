package com.example.hcicoolexample;

public class MyDoes {
    String itemType;
    String position;
    String company;
    String location;
    String date;
    String status;
    String tags;
    String notes;
    String keydoes;

    public MyDoes(){

    }

    public MyDoes(String itemType, String position, String company, String location, String date, String status, String tags, String notes, String keydoes){
        this.itemType = itemType;
        this.position = position;
        this.company = company;
        this.location = location;
        this.date = date;
        this.status = status;
        this.tags = tags;
        this.notes = notes;
        this.keydoes = keydoes;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setCompany(String company) { this.company = company; }

    public void setLocation(String location) { this.location = location; }

    public void setDate(String date) { this.date = date; }

    public void setStatus(String status) { this.status = status; }

    public void setTags(String tags) { this.tags = tags; }

    public void setNotes(String notes) { this.notes = notes; }

    public void setKeydoes(String keydoes) { this.keydoes = keydoes; }

    public String getItemType() {
        return itemType;
    }

    public String getPosition() {
        return position;
    }

    public String getCompany() { return company; }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public String getTags() {
        return tags;
    }

    public String getNotes() {
        return notes;
    }

    public String getKeydoes() { return keydoes; }
}
