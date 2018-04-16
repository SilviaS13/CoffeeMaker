package com.coffeeManager;


import java.time.LocalTime;

public class CoffeeManagerModel {

    private LocalTime time;
    private boolean isOneTimeCoffee;
    private String coffeeName;
    private byte week;

    public CoffeeManagerModel(){};

    CoffeeManagerModel(String time, boolean isOneTimeCoffee, String coffeeName, byte week){
        this.time = LocalTime.parse(time);
        this.isOneTimeCoffee = isOneTimeCoffee;
        this.coffeeName = coffeeName;
        this.week = week;
    }

    //region Getters
    public LocalTime getTime() {
        return time;
    }

    public boolean getIsOneTimeCoffee() {
        return isOneTimeCoffee;
    }

    public String getCoffeeName() {
        return coffeeName;
    }

    public byte getWeek() {
        return week;
    }

    //endregion

    //region Setters

    public void setTime(String time) {

        this.time = LocalTime.parse(time);
    }

    public void setOneTimeCoffee(boolean oneTimeCoffee) {
        isOneTimeCoffee = oneTimeCoffee;
    }

    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }

    public void setWeek(byte week) {
        this.week = week;
    }

    //endregion
}
