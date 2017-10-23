/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testobjectoutputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class TestObjectOutputStream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            //Create an Output stream for the file
            ObjectOutputStream output = new ObjectOutputStream( new FileOutputStream("Object.dat"));
            //Write a string, double value, and object to the file
            output.writeUTF("Valentin De Jesus");
            output.writeDouble(70);//
            output.writeObject(new Date());
            
            //Close Output stream
            output.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "There is an error of not found" + ex.getMessage());
            Logger.getLogger(TestObjectOutputStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "There is a error of IO" + ex.getMessage());
            Logger.getLogger(TestObjectOutputStream.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("Object.dat"));
            
            String name = input.readUTF();
            double weight = input.readDouble();
            Date date = (Date)input.readObject();
            
            
            System.out.println("name  " + name+ " weight " + weight + "date " + date);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "There is an error of not found" + ex.getMessage());
            Logger.getLogger(TestObjectOutputStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "There is an error of IO" + ex.getMessage());
            Logger.getLogger(TestObjectOutputStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestObjectOutputStream.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
