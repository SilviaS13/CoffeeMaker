package com.cofeeChief;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;

@Service
public class CoffeechiefService {
    private static HashMap< Integer, CoffeechiefModel> coffees = new HashMap<Integer, CoffeechiefModel>();
    private static Integer id = 4;

    static {
        coffees.put(0, new CoffeechiefModel("Cappucino", 30, 60, 30, 0, 10 ));
        coffees.put(1, new CoffeechiefModel("Americano", 30, 100, 0,0,  0 ));
        coffees.put(2, new CoffeechiefModel("Mocco",40, 30, 30,20,  0 ));
        coffees.put(3, new CoffeechiefModel("Espresso",40, 0, 0,0,  0 ));
    }



    public static void addCoffee(String coffeeName, int espressoQuantity, int waterQuantity, int milkQuantity, int chocolateQuantity, int sugarQuantity){

        coffees.put(id++, new CoffeechiefModel(coffeeName, espressoQuantity, waterQuantity,  milkQuantity, chocolateQuantity, sugarQuantity));
    }

    public static HashMap< Integer, CoffeechiefModel> coffeelist(){
        return coffees;
    }

    public static void removeCoffee(Integer id){
        Iterator iter = coffees.keySet().iterator();
        while (iter.hasNext()){
            if(iter.next() == id)
                coffees.remove(id);
        }
    }

    public static CoffeechiefModel getCoffee(Integer id){
        Iterator iter = coffees.keySet().iterator();
        while (iter.hasNext()){
            if(iter.next() == id)
                return coffees.get(id);
        }
       return null;
    }
}
