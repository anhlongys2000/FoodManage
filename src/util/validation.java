/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author asus
 */
public class validation {

    private static Scanner sc = new Scanner(System.in);

    public static int getAnInteger(String inPutMsg, String errorMsg, int lowerBound, int upperBound) {
        int n;
        while (true) {
            try {
                System.out.println(inPutMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n < lowerBound || n > upperBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static String getStringByPattern(String inputMsg, String errorMsg) {
        String stdString;

        while (true) {
            System.out.println(inputMsg);
            stdString = sc.nextLine().trim();
            if (stdString.length() == 0 || stdString.isEmpty()) {
                System.out.println(errorMsg);
            } else {
                return stdString;
            }
        }
    }

    public static double getADouble(double lowerBound, double upperBound, String inputMsg, String errMsg) {
        double n;
        while (true) {
            try {
                System.out.println(inputMsg);
                n = Double.parseDouble(sc.nextLine());
                if (n < lowerBound || n > upperBound) {
                    throw new Exception();
                }

                return n;

            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }


    public static Date getDate(String inputMsg, String errMsg, String format) {
        while (true) {
            try {
                System.out.println(inputMsg);
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                sdf.setLenient(false);
                Date date = sdf.parse(sc.nextLine());
                return date;
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }

    public static String validyn(String inputMsg, String errMsg) {
        String answer = new String();
        while (true) {
            try {
                System.out.println(inputMsg);
                answer = sc.nextLine();
                if (!(answer.equalsIgnoreCase("yes")
                        || answer.equalsIgnoreCase("no"))) {
                    throw new Exception();
                }
                return answer;
            } catch (Exception e) {
                System.out.println(errMsg);
            }
        }
    }
}
