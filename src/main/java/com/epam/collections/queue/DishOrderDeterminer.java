package com.epam.collections.queue;

import java.util.ArrayList;
import java.util.List;

public class DishOrderDeterminer {
    public static List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {
        List<Integer> list = new ArrayList<>();
        ArrayList<Integer> tempList = new ArrayList<>();
        for (int i = 1; i <= numberOfDishes; i++) {
            tempList.add(i);
        }
        int count = 0;
        int temp = 0;
        while (count < tempList.size()) {
            if ((count + 1) % everyDishNumberToEat == 0) {
                list.add(tempList.get(count));
            } else {
                if (count + everyDishNumberToEat > tempList.size() && ((count + 1) / everyDishNumberToEat) >= (tempList.size() / everyDishNumberToEat)) {
                    if (tempList.size() > everyDishNumberToEat) {
                        tempList.add(temp++, tempList.get(count));
                        tempList.remove(count + 1);
                    } else if (tempList.size() < everyDishNumberToEat) {
                        list.add(tempList.get(count));
                    }
                }

            }
            count++;
            if (count == tempList.size()) {
                tempList.removeAll(list);
                count = 0;
                temp = 0;
            }
        }
        return list;
    }

}
