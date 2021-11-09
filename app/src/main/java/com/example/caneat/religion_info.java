package com.example.caneat;

public class religion_info {
   private String religion_name;
   private String religion_ingredient;

    public boolean isInSelected() {
        return inSelected;
    }

    public void setInSelected(boolean inSelected) {
        this.inSelected = inSelected;
    }

    boolean inSelected;

    public String getReligion_name() {
        return religion_name;
    }

    public void setReligion_name(String religion_name) {
        this.religion_name = religion_name;
    }

    public String getReligion_ingredient() {
        return religion_ingredient;
    }

    public void setReligion_ingredient(String religion_ingredient) {
        this.religion_ingredient = religion_ingredient;
    }
}
