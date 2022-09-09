package com.example.demo.TpcW.model;

import java.util.List;

public class CreateShoppingCardInput {
   private Integer I_ID;
   private List<String> ids;
   private List<String> quantities;
   private Integer SHOPPING_ID;

    public Integer getI_ID() {
        return I_ID;
    }

    public void setI_ID(Integer i_ID) {
        I_ID = i_ID;
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public List<String> getQuantities() {
        return quantities;
    }

    public void setQuantities(List<String> quantities) {
        this.quantities = quantities;
    }

    public Integer getSHOPPING_ID() {
        return SHOPPING_ID;
    }

    public void setSHOPPING_ID(Integer SHOPPING_ID) {
        this.SHOPPING_ID = SHOPPING_ID;
    }

    public CreateShoppingCardInput() {
    }
}