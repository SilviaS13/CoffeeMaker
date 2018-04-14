package com.coffeeChecker;

import org.springframework.stereotype.Service;

@Service
public class CoffeeCheckerService {

    private static CoffeeCheckerModel checker = CoffeeCheckerModel.getInstance();

    static {
        checker.setChocolateAvaliable(200);
        checker.setCoffeeAvaliable(150);
        checker.setCupIsІsOnMachine(false);
        checker.setMilkAvaliable(300);
        checker.setSugarAvaliable(250);
        checker.setWaterAvaliable(500);
    }


//
//    public static void addCoffee(String coffeeName, int espressoAvaliable, int waterAvaliable, int milkAvaliable, int chocolateAvaliable, int sugarAvaliable){
//
//        coffees.put(id++, new CoffeeCheckerModel(coffeeName, espressoAvaliable, waterAvaliable,  milkAvaliable, chocolateAvaliable, sugarAvaliable));
//    }

//    public static void removeCoffee(Integer id){
//        Iterator iter = coffees.keySet().iterator();
//        while (iter.hasNext()){
//            if(iter.next() == id)
//                coffees.remove(id);
//        }
//    }
//
//    public static CoffeeCheckerModel getCoffee(Integer id){
//        Iterator iter = coffees.keySet().iterator();
//        while (iter.hasNext()){
//            if(iter.next() == id)
//                return coffees.get(id);
//        }
//       return null;
//    }
}
