package com.epam.collections.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class DishOrderDeterminer {
    public static List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {
        List<Integer> list = new ArrayList<>();
        /*ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        for (int i = 1; i <= numberOfDishes; i++) {
            arrayDeque.addLast(i);
        }*/
        ArrayList<Integer> tempList = new ArrayList<>();
        for (int i = 1; i <= numberOfDishes; i++) {
            tempList.add(i);
        }
        int count = 0;
        int temp = 0;
        while (count < tempList.size()) {
            if ((count + 1) % everyDishNumberToEat == 0) {
                list.add(tempList.get(count));
                //tempList.remove(count);
                //count--;
            } else {
                if (count + everyDishNumberToEat > tempList.size() && ((count + 1) / everyDishNumberToEat) >= (tempList.size() / everyDishNumberToEat)) {
                    //if (tempList.size() > everyDishNumberToEat) {
                    tempList.add(temp++, tempList.get(count));
                    tempList.remove(count + 1);
                    /*} else if (tempList.size() < everyDishNumberToEat) {
                        list.add(tempList.get(count));
                    }*/
                }
                if (tempList.size() < everyDishNumberToEat) {
                    if (everyDishNumberToEat - count < everyDishNumberToEat) {
                        //System.out.println(count);
                        list.add(list.size() - count + 1, tempList.get(count));
                    } else {
                        list.add(tempList.get(count));
                    }
                }
            }

            /*if (list.size() == numberOfDishes) {
                System.out.println("LOL");
                break;
            }*/
            count++;
            if (count == tempList.size()) {
                tempList.removeAll(list);
                //System.out.println("LAST " + tempList);
                count = 0;
                temp = 0;
            }
        }
        //System.out.println(list);
        return list;
    }

    public static void main(String[] args) {
        determineDishOrder(11, 4);
        // 1 2 3 5 6 7 9 10 11
        // 9 10 11 2 3 5 7
        // 7 9 10 2 3 5
        // 2 3 5 9 10
        // 9 10 2 5
        // 5 9 10

    }
}
