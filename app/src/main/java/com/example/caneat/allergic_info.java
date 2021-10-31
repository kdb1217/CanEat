package com.example.caneat;

public class allergic_info {
    private String Allergic_ingredient;
    private String Allergic_name;
    boolean inSelected;

    public void setInSelected(boolean inSelected) {
        this.inSelected = inSelected;
    }

    public boolean isInSelected() {
        return inSelected;
    }

    public allergic_info(){}

    public String getAllergic_name() {
        return Allergic_name;
    }

    public String getAllergic_ingredient() {
        return Allergic_ingredient;
    }

    public void setAllergic_name(String allergic_name) {
        Allergic_name = allergic_name;
    }

    public void setAllergic_ingredient(String allergic_ingredient) {
        Allergic_ingredient = allergic_ingredient;
    }
}
