package com.coffeeChecker;

public class CoffeeCheckerModel {

    private static volatile CoffeeCheckerModel instance;

    private int waterAvaliable;
    private int coffeeAvaliable;
    private int milkAvaliable;
    private int chocolateAvaliable;
    private int sugarAvaliable;
    private boolean cupIsOnMachine;

    private boolean cupReleased;


    private CoffeeCheckerModel(){};

    public static CoffeeCheckerModel getInstance(){

        CoffeeCheckerModel localInstance = instance;

        if (localInstance == null){
            synchronized (CoffeeCheckerModel.class){
                localInstance = instance;
                if (localInstance == null){
                    instance = localInstance = new CoffeeCheckerModel();
                }
            }
        }

        return localInstance;
    }

    //region Getters

    public int getWaterAvaliable() {
        return waterAvaliable;
    }

    public int getCoffeeAvaliable() {
        return coffeeAvaliable;
    }

    public int getMilkAvaliable() {
        return milkAvaliable;
    }

    public int getChocolateAvaliable() {
        return chocolateAvaliable;
    }

    public int getSugarAvaliable() {
        return sugarAvaliable;
    }

    public boolean getCupIsOnMachine() {
        return cupIsOnMachine;
    }

    public boolean isCupReleased() {
        return cupReleased;
    }

    //endregion

    //region Setters

    public void setCoffeeAvaliable(int espressoAvaliable) {
        this.coffeeAvaliable = espressoAvaliable;
    }

    public static void setInstance(CoffeeCheckerModel instance) {
        CoffeeCheckerModel.instance = instance;
    }

    public void setWaterAvaliable(int waterAvaliable) {
        this.waterAvaliable = waterAvaliable;
    }

    public void setMilkAvaliable(int milkAvaliable) {
        this.milkAvaliable = milkAvaliable;
    }

    public void setChocolateAvaliable(int chocolateAvaliable) {
        this.chocolateAvaliable = chocolateAvaliable;
    }

    public void setSugarAvaliable(int sugarAvaliable) {
        this.sugarAvaliable = sugarAvaliable;
    }

    public void setCupIsІsOnMachine(boolean cupIsOnMachine) {
        this.cupIsOnMachine = cupIsOnMachine;
    }

    //endregion

}
