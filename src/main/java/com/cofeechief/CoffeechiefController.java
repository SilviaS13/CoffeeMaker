package com.cofeechief;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class CoffeechiefController {

    @Autowired
    private CoffeechiefService coffeservice;

    @GetMapping("/")
    public String home(){
        return "<a href=\"/api/coffees\">/api/coffees</a>" +
                "<br/>" +
                "<a href=\"/api/coffees/1\">/api/coffees/{id}</a>";

    }

    @GetMapping("/api/coffees")
    public ArrayList<CoffeechiefModel> getCoffees(){

        HashMap<Integer, CoffeechiefModel>  coffeeList = CoffeechiefService.coffeelist();
        ArrayList<CoffeechiefModel> mod = new ArrayList<CoffeechiefModel>(coffeeList.values());
        return mod;

    }

    @GetMapping("/api/coffees/{coffeeid}")
    public String getCoffee(@PathVariable Integer coffeeid){

        CoffeechiefModel coff = CoffeechiefService.getCoffee(coffeeid);

        String mess = "Name = " + coff.getCoffeeName() + "; Espresso (g) = " + coff.getEspressoQuantity() +
                "; Water = " + coff.getWaterQuantity() + "; Milk = " + coff.getMilkQuantity() + "; Chocolate = "+
                coff.getChocolateQuantity() + "; Sugar = " + coff.getSugarQuantity();

        return mess;
    }
}
