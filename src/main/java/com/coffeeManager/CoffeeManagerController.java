package com.coffeeManager;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class CoffeeManagerController {

    @GetMapping("/api/manager")
    public String home(){
        return "<a href=\"/api/manager/coffeetasks\">/api/manager/coffeetasks</a>" + "<br/>" +
                "<a href=\"/api/manager/coffeetasks/0\">/api/manager/coffeetasks/{id}</a>";

    }

    @GetMapping("/api/manager/coffeetasks")
    public HashMap<Integer, CoffeeManagerModel> getComponents(){
        return CoffeeManagerService.coffeeTimeList();
    }

    @GetMapping("/api/manager/coffeetasks/{id}")
    public String getComponent(@PathVariable int id){

        CoffeeManagerModel manager = CoffeeManagerService.getCoffeeTime(id);

        return  "Coffee time: " + manager.getTime() + "<br/>" +
                "One time Coffee: " + manager.getIsOneTimeCoffee() + "<br/>" +
                "Coffee Name: " + manager.getCoffeeName() +"<br/>" +
                "Coffee Week: " + CoffeeManagerService.WeekByteToStr(manager.getWeek());
    }

    @PostMapping(path = "/api/manager/coffeetasks")
    public int createCoffee(@RequestBody CoffeeManagerModel coffeeTime){
        return CoffeeManagerService.createCoffeeTime(coffeeTime);
    }

    @PostMapping(path = "/api/manager/coffeetasks/rm")
    public String removeCoffee(@RequestBody Integer id){
        CoffeeManagerService.removeCoffeeTime(id);
        return "Successful";
    }

}
