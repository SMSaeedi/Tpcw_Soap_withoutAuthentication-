package com.example.demo.TpcW.model;

public class AdminUpdateOutParams {
    private int i_id;
    private double cost;
    private String image;
    private String thumbnail;
    private AdminUpdateInParams inParams = new AdminUpdateInParams();

    public int getI_id() {
        return i_id;
    }

    public void setI_id(int i_id) {
        this.i_id = i_id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setInParams(AdminUpdateInParams inParams) {
        this.inParams = inParams;
    }
}