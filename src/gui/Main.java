/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.FoodDao;
import util.validation;

/**
 *
 * @author asus
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FoodDao folder = new FoodDao();
        while (true) {
            menu1();
            int option = validation.getAnInteger("Enter your option:", "Option[1-5]", 1, 5);
            switch (option) {
                case 1:
                    int flag = 1;
                    do {
                        folder.create();
                        String answer = new String();
                        answer = validation.validyn("Do you want to add more yes or no?",
                                "Please enter (yes/no) !!!");
                        if (answer.equalsIgnoreCase("yes")) {
                            flag = 1;
                        } else {
                            flag = 0;
                        }
                    } while (flag == 1);
                    break;
                case 2:
                    int flagS = 1;
                    do {

                        folder.search();
                        String answerS = new String();
                        answerS = validation.validyn("Do you want to search more yes or no?",
                                "Please enter (yes/no) !!!");
                        if (answerS.equalsIgnoreCase("yes")) {
                            flagS = 1;
                        } else {
                            flagS = 0;
                        }
                    } while (flagS == 1);
                    break;
                case 3:
                    String input = new String();
                    input = validation.getStringByPattern("Input id to delete:", "Id is not allow null");
                    folder.delete(input);
                    break;
                case 4:
                    folder.sort();
                    break;
                case 5:
                    System.exit(0);
            }

        }

    }

    private static void menu1() {
        System.out.println("\n---------------------------");
        System.out.println("Welcome to Food Management - @ 2021 by <SE140929 - Nguyen Le Anh Long >");
        System.out.println("Select the options below:");
        System.out.println("1.Add a new food");
        System.out.println("2.Search a food by name");
        System.out.println("3.Remove the food by ID");
        System.out.println("4.Print the food list in the descending order of expired date");
        System.out.println("5.Quit");
    }

}
