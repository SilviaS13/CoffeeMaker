package com.coffeeChief;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class CoffeechiefController {

    @Autowired
    private CoffeechiefService service;


    @GetMapping("/api/coffee")
    public String home(){
        return "<a href=\"/api/coffee/coffees\">/api/coffee/coffees</a>" + "<br/>" +
                "<a href=\"/api/coffee/coffees/1\">/api/coffee/coffees/{id}</a>";

    }

    @GetMapping("/api/coffee/coffees")
    public HashMap<Integer, CoffeechiefModel> getCoffees(){

        HashMap<Integer, CoffeechiefModel>  coffeeList = CoffeechiefService.coffeelist();
        return coffeeList;

    }

    @GetMapping("/api/coffee/coffees/{coffeeid}")
    public String getCoffee(@PathVariable Integer coffeeid){
        CoffeechiefModel coff = service.getCoffee(coffeeid);

        String mess = "Name = " + coff.getCoffeeName() + "; Espresso (g) = " + coff.getEspressoQuantity() +
                "; Water = " + coff.getWaterQuantity() + "; Milk = " + coff.getMilkQuantity() + "; Chocolate = "+
                coff.getChocolateQuantity() + "; Sugar = " + coff.getSugarQuantity();

        return mess;
    }

    @PostMapping(path = "/api/coffee/coffees")
    public int createCoffee(@RequestBody CoffeechiefModel coffeeModel){
        return service.createCoffee(coffeeModel);
    }

    @PostMapping(path = "/api/coffee/coffees/rm")
    public String removeCoffee(@RequestBody Integer id){
        service.removeCoffee(id);
         return "Successful";
    }
}
