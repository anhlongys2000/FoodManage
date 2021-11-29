/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filedao;

import dto.Food;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class FileProcess {

    public static List<Food> readListFood(String fileName) {

        try {
            File file = new File(fileName);
            if(!file.exists()){
                writeListFood(fileName, new ArrayList<>());
            }
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
            List<Food> listFood = (List<Food>) ois.readObject();
            return listFood;
            
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Read file failed");
        }
        return null;
            
    }

    
    public static void writeListFood(String fileName, List<Food> list) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(list);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileProcess.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
