package com.coffeeManager;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class CoffeeManagerController {



    @GetMapping("/api/manager")
    public String home(){
        return "<a href=\"/api/manager/coffeetasks\">/api/manager/coffeetasks</a>" + "<br/>" +
                "<a href=\"/api/manager/coffeetasks/0\">/api/manager/coffeetasks/{id}</a>";

    }

    @GetMapping("/api/manager/coffeetasks")
    public ArrayList<CoffeeManagerModel> getComponents(){

        HashMap<Integer, CoffeeManagerModel> coffeeList = CoffeeManagerService.coffeeTimeList();
        ArrayList<CoffeeManagerModel> mod = new ArrayList<CoffeeManagerModel>(coffeeList.values());
        return mod;
    }

    @GetMapping("/api/manager/coffeetasks/{id}")
    public String getComponent(@PathVariable int id){

        CoffeeManagerModel manager = CoffeeManagerService.getCoffeeTime(id);

        return  "Coffee time: " + manager.getTime() + "<br/>" +
                "One time Coffee: " + manager.getIsOneTimeCoffee() + "<br/>" +
                "Coffee Name: " + manager.getCoffeeName() +"<br/>" +
                "Coffee Week: " + CoffeeManagerService.WeekByteToStr(manager.getWeek());
    }
}
