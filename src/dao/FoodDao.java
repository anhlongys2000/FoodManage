/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Food;
import filedao.FileProcess;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import util.validation;

/**
 *
 * @author asus
 */
public class FoodDao implements IDao {

    private List<Food> listFood;

    public FoodDao() {
        listFood = new ArrayList<>();
    }

    @Override
    public void create() {
        listFood = FileProcess.readListFood("user.dat");
        String id = "";
        while (true) {
            id = validation.getStringByPattern("Input id:", "Id is not allow null");
            if (isExist(id)) {
                System.out.println("Duplicate id, Please another id");
            } else {
                break;
            }
        }
        String name = validation.getStringByPattern("Input name:", "Name is not allow null.");
        String type = validation.getStringByPattern("Input type:", "Type is not allow null.");
        String place = validation.getStringByPattern("Input place:", "Place is not allow null.");
        double weight = validation.getADouble(Double.MIN_VALUE, Double.MAX_VALUE, "Input weight: ", "Invalid weight.");
        Date date = validation.getDate("Input date:(dd/MM/yyyy)", "Date invalid!", "dd/MM/yyyy");

        Food f = new Food(id, name, weight, type, place, date);
        listFood.add(f);
        FileProcess.writeListFood("user.dat", listFood);
        System.out.println("Added");
    }

    @Override
    public void getList() {
        for (Food f : listFood) {
            f.display();
        }
    }

    @Override
    public void delete(String id) {
        listFood = FileProcess.readListFood("user.dat");
        int mark = 0;
        if (!listFood.isEmpty()) {
            List<Food> tmpList = new ArrayList<>();
            for (Food f : listFood) {
                if (f.getId().equals(id)) {
                    tmpList.add(f);
                    mark = 1;
                }
            }
            if (mark == 1) {
                String answer = new String();
                answer = validation.validyn("Are you sure to delete this food yes or no?",
                        "Please(yes/no)!!!");
                if (answer.equalsIgnoreCase("yes")) {
                    if (listFood.removeAll(tmpList)) {
                        System.out.println("Delete successfully!");
                        FileProcess.writeListFood("user.dat", listFood);
                    } else {
                        System.out.println("Delete failed!");
                    }
                } else {
                    System.out.println("Canceled by user!!!");
                }
            } else {
                System.out.println("Not exist food!");
            }

        } else {
            System.out.println("Nothing to delete");
        }
    }

    @Override
    public void search() {
        listFood = FileProcess.readListFood("user.dat");
        String keyword = validation.getStringByPattern(
                "Enter the name you want to search for:", "Name is not allow null.");
        boolean isValueExist= false;
        for (Food f : listFood) {
            if (f.getName().equals(keyword)) {
                f.display();
                isValueExist=true;
            }
        }
        if(!isValueExist){
            System.out.println("Not found!");
        }
    }

    @Override
    public void sort() {
        listFood = FileProcess.readListFood("user.dat");
        Collections.sort(listFood, new Comparator<Food>() {
            @Override
            public int compare(Food t, Food t1) {
                return t.getDate().compareTo(t1.getDate());
            }
        });
        getList();
    }

    private boolean isExist(String id) {
        for (Food f : listFood) {
            if (f.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
