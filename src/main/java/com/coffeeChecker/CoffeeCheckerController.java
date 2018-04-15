package com.coffeeChecker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoffeeCheckerController {

    CoffeeCheckerModel checker;

    @GetMapping("/api/checking")
    public String home(){
        return "<a href=\"/api/checking/all\">/api/checking/all</a>" + "<br/>" +
                "<a href=\"/api/checking/sugar\">/api/checking/sugar</a>"+"<br/>" +
                "<a href=\"/api/checking/water\">/api/checking/water</a>" +"<br/>" +
                "<a href=\"/api/checking/milk\">/api/checking/milk</a>" +"<br/>" +
                "<a href=\"/api/checking/coffee\">/api/checking/coffee</a>" +"<br/>" +
                "<a href=\"/api/checking/cup\">/api/checking/cup</a>" +"<br/>" +
                "<a href=\"/api/checking/chocolate\">/api/checking/chocolate</a>";
    }

    @GetMapping("/api/checking/all")
    public String getComponents(){

        checker = CoffeeCheckerModel.getInstance();

        return  "Products avaliable: " + "<br/>" +
                "The cup is on coffee machine: " + checker.getCupIsOnMachine() + "<br/>" +
                "Coffee = " + checker.getCoffeeAvaliable() +"<br/>" +
                "Water = " + checker.getWaterAvaliable() + "<br/>" +
                "Milk = " + checker.getMilkAvaliable() + "<br/>" +
                "Chocolate = "+ checker.getChocolateAvaliable() + "<br/>" +
                "Sugar = " + checker.getSugarAvaliable();

    }

    @GetMapping("/api/checking/{component}")
    public int getComponent(@PathVariable String component){

        checker = CoffeeCheckerModel.getInstance();

        int a = checker.getCoffeeAvaliable();


        switch (component){
            case ("coffee"): return checker.getCoffeeAvaliable();
            case ("water"): return checker.getWaterAvaliable();
            case ("milk"): return checker.getMilkAvaliable();
            case ("sugar"): return checker.getSugarAvaliable();
            case ("chocolate"): return checker.getChocolateAvaliable();
            case ("cup"): return checker.getCupIsOnMachine() == true ? 1 : 0;
        }
        return 0;
    }
}
