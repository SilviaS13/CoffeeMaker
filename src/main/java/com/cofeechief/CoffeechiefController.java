package com.cofeechief;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class CoffeechiefController {


    @GetMapping("/api/coffee")
    public String home(){
        return "<a href=\"/api/coffee/coffees\">/api/coffee/coffees</a>" +
                "<br/>" +
                "<a href=\"/api/coffee/coffees/1\">/api/coffee/coffees/{id}</a>";

    }

    @GetMapping("/api/coffee/coffees")
    public ArrayList<CoffeechiefModel> getCoffees(){

        HashMap<Integer, CoffeechiefModel>  coffeeList = CoffeechiefService.coffeelist();
        ArrayList<CoffeechiefModel> mod = new ArrayList<CoffeechiefModel>(coffeeList.values());
        return mod;

    }

    @GetMapping("/api/coffee/coffees/{coffeeid}")
    public String getCoffee(@PathVariable Integer coffeeid){

        CoffeechiefModel coff = CoffeechiefService.getCoffee(coffeeid);

        String mess = "Name = " + coff.getCoffeeName() + "; Espresso (g) = " + coff.getEspressoQuantity() +
                "; Water = " + coff.getWaterQuantity() + "; Milk = " + coff.getMilkQuantity() + "; Chocolate = "+
                coff.getChocolateQuantity() + "; Sugar = " + coff.getSugarQuantity();

        return mess;
    }
}
